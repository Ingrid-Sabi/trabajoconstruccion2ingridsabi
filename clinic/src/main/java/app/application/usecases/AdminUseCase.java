package app.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import app.domain.model.Appointment;
import app.domain.model.EmergencyContact;
import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.services.AppointmentService;
import app.domain.services.EmergencyContactService;
import app.domain.services.InvoiceService;
import app.domain.services.PatientServices;


@Service
public class AdminUseCase {
	
	
	@Autowired
	private PatientServices patientServices;
	@Autowired
	private AppointmentService appointmentService;
	@Autowired
	private EmergencyContactService emergencyContactService;
	@Autowired
	private InvoiceService invoiceService;
	
	public void createPatient(Patient patient) throws Exception {	
		patientServices.createPatient(patient);		
	}
	
	public void updatePatient(Patient patient) throws Exception {	
		patientServices.updatePatient(patient);		
	}
	public void createAppointment(Appointment appointment) throws Exception {	
		appointmentService.createMedicalAppointment(appointment);		
	}
	public void createBilling(Invoice invoice) throws Exception {	
		invoiceService.createInvoice(invoice);		
	}
	public void createEmergencyContact(EmergencyContact emergencyContact) throws Exception {	
		emergencyContactService.createEmergencyContact(emergencyContact);		
	}

}
