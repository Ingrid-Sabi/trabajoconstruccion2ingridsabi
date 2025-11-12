package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.AppoinmentValidator;
import app.domain.model.Appointment;

@Component
public class AppoinmentBuilder {
	
	@Autowired
	private AppoinmentValidator appointmentValidator;

    public Appointment build(String date, String time, String reason, String patientName, String document, String phoneNumber, String email) throws Exception{
    	Appointment appoinment = new Appointment();
        appoinment.setDate(appointmentValidator.dateValidator(date));
        appoinment.setTime(appointmentValidator.timeValidator(time));
        appoinment.setReason(appointmentValidator.reasonValidator(reason));

        return appoinment;
    }

}
