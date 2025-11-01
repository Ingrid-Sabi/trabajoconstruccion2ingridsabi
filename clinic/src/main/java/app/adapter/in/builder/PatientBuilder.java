package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.PatientValidator;
import app.domain.model.Patient;



@Component
public class PatientBuilder {
	
	@Autowired
	private PatientValidator patientValidator;

    public Patient build(String document, String patientName, String age, String gender, String address, String phoneNumber, 
    String email) throws Exception{
        Patient patient = new Patient();
        patient.setPatientName(patientValidator.patientNameValidator(patientName));
        patient.setDocument(patientValidator.documentValidator(document));
        patient.setAge(patientValidator.ageValidator(age));
        patient.setGender(patientValidator.genderValidator(gender));
        patient.setAddress(patientValidator.addressValidator(address));
        patient.setPhoneNumber(patientValidator.phoneNumberValidator(phoneNumber));;
        patient.setEmail(patientValidator.emailValidator(email));

        return patient;      
    }

}
