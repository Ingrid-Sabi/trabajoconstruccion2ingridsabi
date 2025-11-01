package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Appointment;
import app.domain.model.Patient;

import app.domain.ports.AppointmentPort;


@Service
public class CreateAppointment {
	@Autowired
	  private AppointmentPort medicalAppointmentPort;
	@Autowired
	  private Patient patient;

	    public void createMedicalAppointment(Appointment medicalAppointment) throws Exception {
	        if (medicalAppointmentPort.findByDocument(medicalAppointment) == null) {
	            throw new Exception("El usuario no se encuentra registrado");
	        }
	        medicalAppointmentPort.save(patient);
	    }


}
