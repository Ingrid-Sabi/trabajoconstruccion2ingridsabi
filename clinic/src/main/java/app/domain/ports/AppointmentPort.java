package app.domain.ports;

import app.domain.model.Appointment;
import app.domain.model.Patient;

public interface AppointmentPort {

	 public Patient findByDocument(Appointment medicalAppointment) throws Exception;
	    public void save(Patient patient) throws Exception;
	}
