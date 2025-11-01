package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Patient;
import app.domain.ports.PatientPort;
@Service
public class CreatePatient {
	@Autowired
	 private PatientPort patientPort;

	    public void createPatient(Patient patient) throws Exception {
	        if (patientPort.findByDocument(patient) != null) {
				throw new Exception("Ya existe una persona registrada con esa cedula");
			}
	        patientPort.save(patient);
	    }

}
