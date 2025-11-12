package app.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.domain.model.Appointment;
import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.services.CreateInvoice;
import app.domain.services.CreateAppointment;
import app.domain.services.CreatePatient;
import app.domain.services.UpdatePatient;

@Component
public class AdminUseCase {
	
	@Autowired
	private CreatePatient createPatient;
	@Autowired
	private CreateAppointment createAppointment;
	@Autowired
	private CreateInvoice createInvoice;
	@Autowired
	private UpdatePatient updatePatient;

	    public void createPatient(Patient patient) throws Exception {
	        createPatient.createPatient(patient);
	    }

	    public void createAppointment(Appointment medicalAppointment) throws Exception {
	    	createAppointment.createMedicalAppointment(medicalAppointment);
	    }

	    public void createInvoice(Invoice invoice) throws Exception {
	        createInvoice.createInvoice(invoice);
	    }

	    public void update(Patient patient) throws Exception {
	        updatePatient.update(patient);
	    }

}
