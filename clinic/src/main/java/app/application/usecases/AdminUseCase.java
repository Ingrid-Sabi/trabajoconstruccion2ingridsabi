package app.application.usecases;

import app.domain.model.Appointment;
import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.services.CreateInvoice;
import app.domain.services.CreateMedicalAppointment;
import app.domain.services.CreatePatient;
import app.domain.services.UpdatePatient;

public class AdminUseCase {
	
	 private CreatePatient createPatient;
	    private CreateMedicalAppointment createMedicalAppointment;
	    private CreateInvoice createInvoice;
	    private UpdatePatient updatePatient;

	    public void createPatient(Patient patient) throws Exception {
	        createPatient.createPatient(patient);
	    }

	    public void createMedicalAppointment(Appointment appointment) throws Exception {
	    	createMedicalAppointment.createMedicalAppointment(appointment);
	    }

	    public void createInvoice(Invoice invoice) throws Exception {
	        createInvoice.createInvoice(invoice);
	    }

	    public void update(Patient patient) throws Exception {
	        updatePatient.update(patient);
	    }

}
