package app.adapter.in.builder;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.ClinicalOrderValidator;
import app.adapter.in.validators.PatientValidator;
import app.adapter.in.validators.UserValidator;
import app.domain.model.ClinicalOrder;
import app.domain.model.ClinicalRecord;
import app.domain.model.Patient;
import app.domain.model.User;

@Component
public class ClinicalRecordBuilder {
	
	  @Autowired
	    private UserValidator userValidator;

	    @Autowired
	    PatientValidator patientValidator;

	    @Autowired
	    private ClinicalOrderValidator clinicalOrderValidator;

	    public ClinicalRecord create(String document, String patientId, String orderId) throws Exception {
	        ClinicalRecord clinicalRecord = new ClinicalRecord();
	        User doctor = new User();
	        Patient patient = new Patient();
	        ClinicalOrder order = new ClinicalOrder();
	        doctor.setDocument(userValidator.documentValidator(document));
	        patient.setDocument(patientValidator.documentValidator(patientId));
	        order.setDocument(clinicalOrderValidator.idValidator(orderId));
	        clinicalRecord.setDoctorName(doctor);
	        clinicalRecord.setPatientName(patient);
	        clinicalRecord.setClinicalOrder(order);
	        clinicalRecord.setDate(new Date(System.currentTimeMillis()));
	        clinicalRecord.setStatus(true);
	        return clinicalRecord;
	    }

}
