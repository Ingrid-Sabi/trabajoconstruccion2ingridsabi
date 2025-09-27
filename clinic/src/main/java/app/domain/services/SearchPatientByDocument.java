package app.domain.services;

import app.domain.model.Patient;
import app.domain.ports.PatientPort;

public class SearchPatientByDocument {
	
	 private PatientPort patientPort;

	    public Patient search(Patient patient) throws Exception {
	        patient = patientPort.findByDocument(patient);
	        if (patient == null) {
	            throw new Exception("El paciente no se encuentra registrado");
	        }
	        return patientPort.findByDocument(patient);
	    }

}
