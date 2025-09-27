package app.domain.services;

import app.domain.model.Patient;
import app.domain.ports.ClinicalOrderPort;
import app.domain.ports.PatientPort;

public class SearchClinicalOrderByPatient {
	
	 private PatientPort patientPort;
	    private ClinicalOrderPort clinicalOrderPort;
	    
	    public List<ClinicalOrder> search(Patient patient) throws Exception {
	        patient = patientPort.findByDocument(patient);
	        if (patient == null) {
	            throw new Exception("el paciente no se encuentra registrado");
	        }
	        return clinicalOrderPort.findByPatient(patient);
	        
	    }

}
