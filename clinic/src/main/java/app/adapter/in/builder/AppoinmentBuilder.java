package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.AppointmentValidator;
import app.adapter.in.validators.EmployeeValidator;
import app.adapter.in.validators.PatientValidator;
import app.domain.model.Appointment;
import app.domain.model.Employee;
import app.domain.model.Patient;

@Component
public class AppoinmentBuilder {
	
	@Autowired
	private AppointmentValidator AppointmentValidator;
	@Autowired
	private EmployeeValidator employeeValidator;
	@Autowired
	private PatientValidator patientValidator;
	
	public Appointment build(String doctorName, String patientName, String date) throws Exception{
		Appointment medicalAppointment = new Appointment();
		Employee doctor= new Employee();
		Patient patient = new Patient();
		doctor.setFullName(employeeValidator.fullNameValidator(doctorName));
		patient.setFullName(patientValidator.fullNameValidator(patientName));
		medicalAppointment.setDate(AppointmentValidator.dateValidator(date));	
		
		return medicalAppointment;
		
	}

}
