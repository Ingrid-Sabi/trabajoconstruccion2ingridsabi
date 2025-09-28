package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.AppoinmentValidator;

import app.domain.model.Appointment;
import app.domain.model.Patient;
import app.domain.model.User;


@Component
public class AppointmentBuilder {
	
	@Autowired
	private AppoinmentValidator appoinmentValidator;
	@Autowired
	private Patient patient;
	
	@Autowired
	User name = new User();
	
	
	public Appointment build(String namePatient, String doctorName/*,String id*/) throws Exception {
		Appointment appointment = new Appointment();
		patient.setPatientName(appoinmentValidator.namePatientValidator(namePatient));
		name.setName(appoinmentValidator.nameValidator(doctorName));
		/*appointment.setId(appoinmentValidator.orderIdValidator(id));*/
		
		
	
		return appointment;
	}

}
