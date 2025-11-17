package app.adapter.out.persistence;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.ClinicalOrder;

import app.domain.ports.ClinicalOrderPort;
import app.infrastructure.persistence.entities.ClinicalOrderEntity;
import app.infrastructure.persistence.entities.PatientEntity;
import app.infrastructure.persistence.mapper.ClinicalOrderMapper;
import app.infrastructure.persistence.repository.ClinicalOrderRepository;
import app.infrastructure.persistence.repository.PatientRepository;

@Service
public class ClinicalOrderAdapter implements ClinicalOrderPort {

	  @Autowired
	    private ClinicalOrderRepository clinicalOrderRepository;
	    
	    @Autowired
	    private PatientRepository patientRepository;
	    
	    @Autowired
	    private ClinicalOrderMapper orderMapper; 

	    @Override
	    public ClinicalOrder findById(ClinicalOrder clinicalOrder) throws Exception {
	    	ClinicalOrderEntity clinicalOrderEntity = clinicalOrderRepository.findById(clinicalOrder.getOrderId());
	        return orderMapper.toDomain(clinicalOrderEntity); 
	    }

	    @Override
	    public void save(ClinicalOrder clinicalOrder) throws Exception {
	    	ClinicalOrderEntity clinicalOrderEntity = orderMapper.toEntity(clinicalOrder);

	        PatientEntity patient = patientRepository.findById(clinicalOrder.getPatient().getId())
	            .orElseThrow(() -> new Exception("Paciente no encontrado"));
	        clinicalOrderEntity.setPatient(patient);
	        clinicalOrderRepository.save(clinicalOrderEntity);
	    }

}



