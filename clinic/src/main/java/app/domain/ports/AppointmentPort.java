package app.domain.ports;

import app.domain.model.Appointment;

public interface AppointmentPort {

	public void save(Appointment appointment) throws Exception;
}
