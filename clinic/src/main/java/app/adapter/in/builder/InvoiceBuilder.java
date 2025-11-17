package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.EmployeeValidator;
import app.adapter.in.validators.InvoiceValidator;
import app.adapter.in.validators.PatientValidator;
import app.domain.model.ClinicalOrder;
import app.domain.model.Employee;
import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.model.User;


@Component
public class InvoiceBuilder {
	
	  @Autowired
	    private InvoiceValidator invoiceValidator;
	    @Autowired
	    private EmployeeValidator employeeValidator;
	    @Autowired
	    private PatientValidator patientValidator;
	    
	    public Invoice build(String namePatient, String doctorName, String patientDocument,String doctorDocument, String patientAge, String policyNumber, String insuranceCompanyName, String policyValidity, String policyEndDate) throws Exception {
	    	Invoice billing = new Invoice();
	        Employee doctor = new Employee();
	        Patient patient = new Patient();
	        doctor.setFullName(employeeValidator.fullNameValidator(doctorName));
	        doctor.setDocument(employeeValidator.documentValidator(doctorDocument));
	        patient.setDocument(patientValidator.documentValidator(patientDocument));
	        billing.setPatientDocument(patient.getDocument());
	        patient.setFullName(patientValidator.fullNameValidator(namePatient));
	        billing.setDoctorName(doctor);
	        billing.setPatientName(patient);
	        billing.setInsuranceCompanyName(invoiceValidator.insuranceCompanyNameValidator(insuranceCompanyName));
	        billing.setPatientAge(invoiceValidator.patientAgeValidator(patientAge));
	        billing.setPolicyNumber(invoiceValidator.policyNumberValidator(policyNumber));
	        billing.setPolicyValidity(invoiceValidator.policyValidityValidator(policyValidity));
	        billing.setPolicyEndDate(invoiceValidator.policyEndDateValidator(policyEndDate)); 

	        return billing;
	    }

}
