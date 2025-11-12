package app.adapter.rest.mapper;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.builder.ClinicalOrderBuilder;
import app.adapter.in.builder.ClinicalRecordBuilder;
import app.adapter.in.rest.controllers.DoctorController.ClinicalOrderRequest;
import app.adapter.in.rest.controllers.DoctorController.ClinicalRecordRequest;
import app.adapter.rest.response.ClinicalOrderResponse;
import app.adapter.rest.response.ClinicalRecordResponse;
import app.domain.model.ClinicalOrder;
import app.domain.model.ClinicalRecord;
import app.domain.model.Patient;
import app.domain.model.User;
@Component
public class ClinicalRecordRestMapper {
	
	
	
	
	
	@Autowired
    private ClinicalRecordBuilder clinicalRecordBuilder;
	
	 public ClinicalRecord toDomain(ClinicalRecordRequest req) throws Exception {
	        return clinicalRecordBuilder.create(
	            req.getPatientId(),
	            req.getOrderId(),
	            req.getDocument()

	            
	        );
	    }

	    public ClinicalRecordResponse toResponse(ClinicalRecord clinicalRecord) {
	    	ClinicalRecordResponse res = new ClinicalRecordResponse();
	    	 User doctor = new User();
		     Patient patient = new Patient();
		     ClinicalOrder order = new ClinicalOrder();
	      /*  res.setId(clinicalRecord.getId());
	        res.setPatientId(patient.getPatientId());
	        res.setgetOrderId(order.getOrderId());
	        res.setDocument(clinicalRecord.getDocument());
	       
	       
	        */
	        
	        return res;
	    }
}
