package app.adapter.rest.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.builder.ClinicalOrderBuilder;
import app.adapter.in.builder.UserBuilder;
import app.adapter.in.rest.controllers.DoctorController.ClinicalOrderRequest;
import app.adapter.rest.request.CreateUserRequest;
import app.adapter.rest.response.ClinicalOrderResponse;
import app.adapter.rest.response.UserResponse;
import app.domain.model.ClinicalOrder;
import app.domain.model.Patient;
import app.domain.model.User;
@Component
public class ClinicalOrderRestMapper {
	
	

    @Autowired
    private ClinicalOrderBuilder clinicalOrderBuilder;

    public ClinicalOrder toDomain(ClinicalOrderRequest req) throws Exception {
        return clinicalOrderBuilder.build(
            req.getPatientName(),
           //req.getDoctorName(),
            req.getDocument(),
            req.getMedicine(),
            req.getDoce()
            //req.getDate(),
            ,"",""
        );
    }

    public ClinicalOrderResponse toResponse(ClinicalOrder clinicalOrder) {
    	ClinicalOrderResponse res = new ClinicalOrderResponse();
    	/*User doctor = new User();
	    Patient patient = new Patient();
        res.setId(clinicalOrder.getId());
        res.setPatientName(clinicalOrder.getPatientName());
        res.setDoctorName(clinicalOrder.getDoctorName());
        res.setDocument(clinicalOrder.getDocument());
        res.setMedicine(clinicalOrder.getMedicine());
        res.setDoce(clinicalOrder.getDoce());
        res.setDate(clinicalOrder.getDate());*/
        
        return res;
    }

}
