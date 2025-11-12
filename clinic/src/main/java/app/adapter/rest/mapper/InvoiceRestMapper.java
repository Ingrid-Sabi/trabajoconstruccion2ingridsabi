package app.adapter.rest.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import app.adapter.in.builder.InvoiceBuilder;
import app.adapter.in.rest.controllers.AdminController.InvoiceRequest;
import app.adapter.rest.response.InvoiceResponse;
import app.domain.model.ClinicalOrder;
import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.model.User;

public class InvoiceRestMapper {
	
	

    

	@Autowired
    private InvoiceBuilder invoiceBuilder;
	
	 public Invoice toDomain(InvoiceRequest req) throws Exception {
	        return invoiceBuilder.build(
	            req.getPatientName(),
	            
	            req.getDocument(),
	            req.getDoctorName(),
	            req.getInsuranceCompany(),
	            //req.getpPlicyNumber(),
	            req.getPolicyValidity(),
	            req.getPolicyEndingDate(),
	            req.getMedicine(),
	           // req.getOrderId(),
	            req.getProductName(),"",""
	            
	            
	        );
	    }

	    public InvoiceResponse toResponse(Invoice invoice) {
	    	InvoiceResponse res = new InvoiceResponse();
	    	 User doctor = new User();
		     Patient patient = new Patient();
		     ClinicalOrder order = new ClinicalOrder();
		     
	       /* res.setId(Invoice.getId());
	        res.setPatientId(patient.getPatientId());
	        res.setgetOrderId(order.getOrderId());
	        res.setDocument(invoice.getDocument());
	        res.setDoctorName(doctor.getDoctorName());
	        res.setInsuranceCompany(invoice.getInsuranceCompany());
	        res.setDocument(invoice.getpPlicyNumber());
	        res.setPolicyValidity(invoice.getPolicyValidity());
	        res.setPolicyEndingDate(invoice.getPolicyEndingDate());
	        res.setPolicyEndingDate(invoice.getPolicyEndingDate());
	        res.setProductName(invoice.getProductName());
	       
	       */
	        
	        
	        return res;
	    }

}
