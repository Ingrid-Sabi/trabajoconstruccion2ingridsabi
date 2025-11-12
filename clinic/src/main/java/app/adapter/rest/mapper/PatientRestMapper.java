package app.adapter.rest.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.builder.PatientBuilder;

import app.adapter.rest.request.PatientRequest;
import app.adapter.rest.response.PatientResponse;
import app.domain.model.Patient;






@Component
public class PatientRestMapper {
	
	
	   @Autowired
	    private PatientBuilder patientBuilder;

	    public Patient toDomain(PatientRequest req) throws Exception {
	        return patientBuilder.build(
	            req.getPatientName(),
	            req.getDocument(),
	            req.getAge(),
	            req.getGender(),
	            req.getAddress(),
	            req.getPhoneNumber(),
	            req.getEmail()
	        );
	    }

	    public PatientResponse toResponse(Patient patient) {
	    	PatientResponse res = new PatientResponse();
	    	/*res.setPatientId(patient.getPatientId());
	        res.setPatientName(patient.getPatientName());
	        res.setDocument(patient.getDocument());
	        res.setAge(patient.getAge());
	        res.setGender(patient.getGender());
	        res.setAddress(patient.getAddress());
	        res.setPhoneNumber(patient.getPhoneNumber());
	        res.setAEmail(patient.getEmail());*/
	        
	        return res;
	    }
}
