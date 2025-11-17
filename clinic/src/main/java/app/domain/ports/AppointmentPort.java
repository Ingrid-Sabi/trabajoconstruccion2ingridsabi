package app.domain.ports;

import java.sql.Date;

import app.domain.model.Appointment;
import app.domain.model.Employee;
import app.domain.model.Patient;

public interface AppointmentPort {

	public Appointment findById(Appointment appointment) throws Exception;
	public boolean isDoctorAvailable(Employee doctor, Date date) throws Exception;
	public boolean isPatientAvailable(Patient patient, Date date) throws Exception;
	public void save(Appointment appointment) throws Exception;
}
