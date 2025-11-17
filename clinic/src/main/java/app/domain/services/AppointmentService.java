package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Appointment;
import app.domain.ports.AppointmentPort;
@Service
public class AppointmentService {
	@Autowired
	private AppointmentPort appointmentPort;

    public void createMedicalAppointment(Appointment appointment) throws Exception {
  
   

    	if (appointment.getDate() == null) {
    	    throw new Exception("La fecha de la cita no puede estar vacía");
    	}
        
        if (!appointmentPort.isDoctorAvailable(appointment.getDoctor(), appointment.getDate())) {
            throw new Exception("El doctor ya tiene una cita agendada para esa fecha y hora.");
        }

        if (!appointmentPort.isPatientAvailable(appointment.getPatient(), appointment.getDate())) {
            throw new Exception("El paciente ya tiene una cita agendada para esa fecha y hora.");
        }
        appointmentPort.save(appointment);
    }
}