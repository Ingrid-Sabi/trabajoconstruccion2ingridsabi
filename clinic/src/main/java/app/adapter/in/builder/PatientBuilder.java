package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.PatientValidator;
import app.domain.model.Patient;



@Component
public class PatientBuilder {
	
	@Autowired
	private PatientValidator patientValidator;
	
	
	public Patient build(String name, String document,String email,String address,String phone, String age, String gender) throws Exception {
		Patient patient = new Patient();
		patient.setPatientName(patientValidator.namePatientValidator(name));
		patient.setDocument(patientValidator.documentValidator(document));
		patient.setEmail(patientValidator.emailValidator(email));
		patient.setAddress(patientValidator.addressValidator(address));
		patient.setPhoneNumber(patientValidator.phoneValidator(phone));
		patient.setAge(patientValidator.ageValidator(age));
		patient.setGender(patientValidator.genderValidator(gender));
	
		return patient;
	}

}
