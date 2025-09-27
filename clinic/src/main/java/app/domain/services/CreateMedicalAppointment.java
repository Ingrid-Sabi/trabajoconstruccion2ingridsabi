package app.domain.services;

import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;

public class CreateMedicalAppointment {
	
	private PatientPort patientPort;
    private UserPort userPort;

    public void createMedicalAppointment(User user) throws Exception {
        if (userPort.findByUserName(user) == null) {
            throw new Exception("El usuario no se encuentra registrado");
        }
    }

    public void createMedicalAppointment(Patient patient) throws Exception {
        if (patientPort.findByDocument(patient) == null) {
            throw new Exception("El paciente no se encuentra registrado");
        }
        patientPort.save(patient);
    }

}
