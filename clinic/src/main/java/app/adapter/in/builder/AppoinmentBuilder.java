package app.adapter.in.builder;

import app.adapter.in.validators.AppoinmentValidator;
import app.domain.model.Appointment;

public class AppoinmentBuilder {
	
	private AppoinmentValidator appointmentValidator;

    public Appointment build(String date, String time, String reason, String patientName, String document, String phoneNumber, String email) throws Exception{
    	Appointment appoinment = new Appointment();
        appoinment.setDate(appointmentValidator.dateValidator(date));
        appoinment.setTime(appointmentValidator.timeValidator(time));
        appoinment.setReason(appointmentValidator.reasonValidator(reason));

        return appoinment;
    }

}
