package app.adapter.in.validators;

import org.springframework.stereotype.Component;


@Component
public class AppoinmentValidator  extends SimpleValidator {
	
	
	/*public long orderIdValidator(String value) throws Exception {
		return longValidator("id de la cita", value);
	}*/
	public String namePatientValidator(String value) throws Exception {
		return stringValidator("Nombre del paciente", value);
	}
	public String nameValidator(String value) throws Exception {
		return stringValidator("Nombre del Doctor", value);
	}
	
	
	/*public LocalDate  dateValidator(String value) throws Exception {
		return dateValidator("edad del Paciente", value);
		FECHAAA
	}*/
}
