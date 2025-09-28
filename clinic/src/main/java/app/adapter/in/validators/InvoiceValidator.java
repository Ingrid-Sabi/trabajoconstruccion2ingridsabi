package app.adapter.in.validators;

import org.springframework.stereotype.Component;



@Component
public class InvoiceValidator extends SimpleValidator {
	
	public String namePatientValidator(String value) throws Exception {
		return stringValidator("nombre del Paciente", value);
	}
	public int ageValidator(String value) throws Exception {
		return integerValidator("edad del Paciente", value);
	}
	public long documentValidator(String value) throws Exception {
		return longValidator("el documento del Paciente", value);
	}
	
	public String nameValidator(String value) throws Exception {
		return stringValidator("Nombre del Doctor", value);
	}
	public String insuranceCompanyValidator(String value) throws Exception {
		return stringValidator("nombre de compañia de seguros", value);
	}
	public int policyNumberValidator(String value) throws Exception {
		return integerValidator("Numero de poliza", value);
	}
	public String policyValidityValidator(String value) throws Exception {
		return stringValidator("Validez de la poliza", value);
	}
	/*public String policyEndingDateValidator(String value) throws Exception {
		return stringValidator("Finalizacion de la poliza", value);
	}*/
	 public boolean isMedicineValidator(String value) throws Exception {
			stringValidator("venta de mediciona", value);
			return value.equals("si");
		}
	  public long idvalidator(String value) throws Exception{
	        return longValidator("Id de la orden clinica", value);
	    }
	  public String productNameValidator(String value) throws Exception {
			return stringValidator("nombre del Producto", value);
		}
	  public int ageNumberValidator(String value) throws Exception {
			return integerValidator("edad del paciente", value);
		}

}
