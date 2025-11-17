package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Patient;
import app.domain.model.RegisterVisit;
import app.domain.ports.PatientPort;
import app.domain.ports.RegisterVisitPort;
@Service
public class RegisterVisitService {
	@Autowired
    private RegisterVisitPort registerVisitPort;
	@Autowired
	private PatientPort patientPort;

    public void registerVisit(RegisterVisit registerVisit) throws Exception {
      
        Patient patient = patientPort.findByDocument(registerVisit.getPatient());
        if (patient == null) {
            throw new Exception("Debe asociar la visita a un paciente registrado.");
        }
        registerVisit.setPatient(patient);

        
        if (registerVisit.getBloodPressure() == 0 || registerVisit.getBloodPressure() < 50 || registerVisit.getBloodPressure() > 250) {
            throw new Exception("Debe registrar una presión arterial válida (entre 50 y 250 mmHg).");
        }

       
        if (registerVisit.getTemperature() == 0 || registerVisit.getTemperature() < 30 || registerVisit.getTemperature() > 45) {
            throw new Exception("Debe registrar una temperatura válida (entre 30°C y 45°C).");
        }

        
        if (registerVisit.getPulse() == 0 || registerVisit.getPulse() < 30 || registerVisit.getPulse() > 220) {
            throw new Exception("Debe registrar un pulso válido (entre 30 y 220 bpm).");
        }

        if (registerVisit.getOxygenLevel() == 0 || registerVisit.getOxygenLevel() < 70 || registerVisit.getOxygenLevel() > 100) {
            throw new Exception("Debe registrar un nivel de oxígeno válido (entre 70% y 100%).");
        }

        
        registerVisitPort.save(registerVisit);
    }

    }
	    


