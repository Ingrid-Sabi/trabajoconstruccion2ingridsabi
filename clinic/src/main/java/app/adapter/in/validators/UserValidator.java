package app.adapter.in.validators;

import org.springframework.stereotype.Component;

@Component
public class UserValidator extends SimpleValidator {
	
	public String nameValidator(String value) throws Exception {
		return stringValidator("nombre de la persona", value);
	}
	
	public String userNameValidator(String value) throws Exception {
		return stringValidator("nombre del usuario", value);
	}
	
	public String passwordValidator(String value) throws Exception {
		return stringValidator("contraseña", value);
	}
	
	public long documentValidator(String value) throws Exception {
		return longValidator("el documento de la persona", value);
	}
	
	public int ageValidator(String value) throws Exception {
		return integerValidator("edad de la persona", value);
	}
	public long phoneValidator(String value) throws Exception {
		return longValidator("Telefono de la persona", value);
	}
	public String emailValidator(String value) throws Exception {
		return stringValidator("Correo de la persona", value);
	}
	public String addressValidator(String value) throws Exception {
		return stringValidator("Dirrecion de la persona", value);
	}

}
