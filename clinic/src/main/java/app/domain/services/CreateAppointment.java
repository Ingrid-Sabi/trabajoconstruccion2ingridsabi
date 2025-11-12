package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Appointment;
import app.domain.model.Patient;

import app.domain.ports.AppointmentPort;
import app.domain.ports.PatientPort;

@Service
public class CreateAppointment {
	@Autowired
	private AppointmentPort appointmentPort;
	@Autowired
	private PatientPort patientPort;

	public void createMedicalAppointment(Appointment medicalAppointment) throws Exception {
		Patient posiblePatient = new Patient();
		posiblePatient.setDocument(medicalAppointment.getDocument());
		Patient patient = patientPort.findByDocument(posiblePatient);
		if (patient == null) {
			throw new Exception("El usuario no se encuentra registrado");
		}
		appointmentPort.save(medicalAppointment);
	}

}
