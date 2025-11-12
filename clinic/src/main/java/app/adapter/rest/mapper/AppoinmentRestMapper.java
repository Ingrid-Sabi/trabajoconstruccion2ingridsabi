package app.adapter.rest.mapper;

import org.springframework.beans.factory.annotation.Autowired;

import app.adapter.in.builder.AppoinmentBuilder;
import app.adapter.in.rest.controllers.AdminController.AppointmentRequest;
import app.adapter.rest.response.AppoinmentResponse;
import app.domain.model.Appointment;



public class AppoinmentRestMapper {
	
	private long id;
	private long document;
	private String date;
	private String time;
	private String reason;
	
	@Autowired
    private AppoinmentBuilder appoinmentBuilder;
	
	 public Appointment toDomain(AppointmentRequest req) throws Exception {
	        return appoinmentBuilder.build(
	            req.getPatientName(),
	            
	            req.getDocument(),
	            req.getDate(),
	            req.getTime(),
	            req.getReason(),"",""
	           
	            
	            
	        );
	    }

	    public AppoinmentResponse toResponse(Appointment appointment) {
	    	AppoinmentResponse res = new AppoinmentResponse();
	    	 
		     /*
	        res.setId(appointment.getId());
	        res.setDocument(appointment.getDocument());
	        res.setDate(appointment.getDate());
	        res.setTime(appointment.getTime());
	        res.setReason(appointment.getReason());
	       
	       */
	       
	        
	        
	        return res;
	    }

}
