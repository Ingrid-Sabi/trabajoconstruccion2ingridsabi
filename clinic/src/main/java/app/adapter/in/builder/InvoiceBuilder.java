package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.InvoiceValidator;
import app.adapter.in.validators.PatientValidator;
import app.domain.model.ClinicalOrder;
import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.model.User;


@Component
public class InvoiceBuilder {
	
	@Autowired
	private InvoiceValidator invoiceValidator;
	@Autowired
    private Patient patient;
    
    public Invoice build(String document, String patientName,String age, String doctorName, String insuranceCompany, String policyNumber, String policyValidity, String policyEndingDate, String medicine, String productName, String order) throws Exception{
        Invoice invoice = new Invoice();
        User name = new User();
        invoice.setDocument(invoiceValidator.documentValidator(document));
        patient.setPatientName(invoiceValidator. namePatientValidator(patientName));
        invoice.setPatientAge(invoiceValidator. ageNumberValidator(age));
        name.setName(invoiceValidator.nameValidator(doctorName));
        invoice.setInsuranceCompany(invoiceValidator.insuranceCompanyValidator(insuranceCompany));
        invoice.setPolicyNumber(invoiceValidator.policyNumberValidator(policyNumber));
        invoice.setPolicyValidity(invoiceValidator.policyValidityValidator(policyValidity));
        /*invoice.setPolicyEndingDate(invoiceValidator.policyEndingDateValidator(policyEndingDate));*/
        invoice.setProductName(invoiceValidator.productNameValidator(productName));
        if (invoice.isMedicine()) {
			ClinicalOrder clinicalOrder = new ClinicalOrder();
			clinicalOrder.setId(invoiceValidator.idvalidator(order));
			invoice.setOrder(clinicalOrder);
		}

        return invoice;      
    }

}
