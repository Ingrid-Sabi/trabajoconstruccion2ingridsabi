package app.domain.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.ClinicalOrder;
import app.domain.model.Patient;
import app.domain.ports.ClinicalOrderPort;
import app.domain.ports.PatientPort;

import jakarta.transaction.Transactional;

@Service
public class ClinicalOrderService {
	@Autowired
	private ClinicalOrderPort clinicalOrderPort;
	@Autowired
	private PatientPort patientPort;

	
	@Transactional
    public void createOrder(ClinicalOrder clinicalorder) throws Exception {
    	Patient patient= patientPort.findByDocument(clinicalorder.getPatient());
        if (patient == null) {
            throw new Exception("La orden debe estar asociada a un paciente.");
        }
        clinicalorder.setPatient(patient);

        if ((clinicalorder.getMedications() == null) &&
            (clinicalorder.getProcedure() == null) &&
            (clinicalorder.getDiagnosticAid() == null)) {
            throw new Exception("La orden debe tener al menos un medicamento, procedimiento o ayuda diagnóstica.");
        }
        
        clinicalOrderPort.save(clinicalorder);
    }

}
