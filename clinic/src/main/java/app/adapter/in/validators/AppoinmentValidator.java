package app.adapter.in.validators;

import org.springframework.stereotype.Component;


@Component
public class AppoinmentValidator  extends SimpleValidator {
	
	
	 public String dateValidator(String value) throws Exception{
	        return stringValidator("Fecha de la cita", value);
	    }

	    public String timeValidator(String value) throws Exception{
	        return stringValidator("Hora de la cita", value);
	    }

	    public String reasonValidator(String value) throws Exception{
	        return stringValidator("Razon de la cita", value);
	    }
}
