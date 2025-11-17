package app.adapter.out.persistence;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.ClinicalRecord;

import app.domain.ports.ClinicalRecordPort;
import app.infrastructure.persistence.entities.ClinicalRecordEntity;
import app.infrastructure.persistence.mapper.ClinicalRecordMapper;
import app.infrastructure.persistence.repository.ClinicalRecordRepository;


@Service
public class ClinicalRecordAdapter implements ClinicalRecordPort {

	 @Autowired
	    private ClinicalRecordRepository clinicalRecordRepository;

	    @Autowired
	    private ClinicalRecordMapper clinicalRecordMapper;

	    @Override
	    public void save(ClinicalRecord clinicalRecord) throws Exception {
	    	ClinicalRecordEntity entity = clinicalRecordMapper.toEntity(clinicalRecord);
	        entity.setId(null);
	        clinicalRecordRepository.save(entity);

	    }

	    @Override
	    public void update(ClinicalRecord clinicalRecord) throws Exception {
	    	ClinicalRecordEntity existing = clinicalRecordRepository.findById(clinicalRecord.getId())
	                .orElseThrow(() -> new Exception("No se encontró la historia clínica para actualizar."));

	        existing.setDiagnosis(clinicalRecord.getDiagnosis());
	        existing.setReasonConsultation(clinicalRecord.getReasonConsultation());
	        existing.setSymptomatology(clinicalRecord.getSymptomatology());
	        existing.setDate(clinicalRecord.getDate().toLocalDate());

	        clinicalRecordRepository.save(existing);
	    }
	

	
	

	

}



