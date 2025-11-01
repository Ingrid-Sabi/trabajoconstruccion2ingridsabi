package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Patient;
import app.domain.ports.PatientPort;
@Service
public class RegisterVisit {
	@Autowired
	  private PatientPort patientPort;

	    public void registerVisit(Patient patient) throws Exception {
	        if (patientPort.findByDocument(patient) == null) {
	            throw new Exception("No existe un paciente registrado con esa cedula");
	        }
	        patientPort.save(patient);
	    }

}
