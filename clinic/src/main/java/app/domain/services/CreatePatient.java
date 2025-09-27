package app.domain.services;

import app.domain.model.Patient;
import app.domain.ports.PatientPort;

public class CreatePatient {
	
	 private PatientPort patientPort;

	    public void createPatient(Patient patient) throws Exception {
	        if (patientPort.findByDocument(patient) != null) {
				throw new Exception("Ya existe una persona registrada con esa cedula");
			}
	        patientPort.save(patient);
	    }

}
