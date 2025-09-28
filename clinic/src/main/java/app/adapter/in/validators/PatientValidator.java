package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class PatientValidator extends SimpleValidator {
	
	public String namePatientValidator(String value) throws Exception {
		return stringValidator("nombre del Paciente", value);
	}
	public long documentValidator(String value) throws Exception {
		return longValidator("el documento del Paciente", value);
	}
	
	public int ageValidator(String value) throws Exception {
		return integerValidator("edad del Paciente", value);
	}
	public long phoneValidator(String value) throws Exception {
		return longValidator("Telefono del Paciente", value);
	}
	public String emailValidator(String value) throws Exception {
		return stringValidator("Correo del Paciente", value);
	}
	public String addressValidator(String value) throws Exception {
		return stringValidator("Dirrecion del Paciente", value);
	}
	
	public String genderValidator(String value) throws Exception {
		return stringValidator("Genero del Paciente", value);
	}

}
