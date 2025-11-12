package app.adapter.in.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.adapter.in.builder.AppoinmentBuilder;
import app.adapter.in.builder.InvoiceBuilder;
import app.adapter.in.builder.PatientBuilder;
import app.application.usecases.AdminUseCase;
import app.domain.model.Appointment;
import app.domain.model.Invoice;
import app.domain.model.Patient;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	private AdminUseCase adminUseCase;

	@Autowired
	private PatientBuilder patientBuilder;

	@Autowired
	private AppoinmentBuilder appointmentBuilder;

	@Autowired
	private InvoiceBuilder invoiceBuilder;

	@PostMapping("/patients")
	public ResponseEntity<String> createPatient(@RequestBody PatientRequest request) throws Exception {
		Patient patient = patientBuilder.build(
			request.getDocument(),
			request.getPatientName(),
			request.getAge(),
			request.getGender(),
			request.getAddress(),
			request.getPhoneNumber(),
			request.getEmail()
		);
		adminUseCase.createPatient(patient);
		return ResponseEntity.status(HttpStatus.CREATED).body("Paciente creado exitosamente");
	}

	@PutMapping("/patients")
	public ResponseEntity<String> updatePatient(@RequestBody PatientRequest request) throws Exception {
		Patient patient = patientBuilder.build(
			request.getDocument(),
			request.getPatientName(),
			request.getAge(),
			request.getGender(),
			request.getAddress(),
			request.getPhoneNumber(),
			request.getEmail()
		);
		adminUseCase.update(patient);
		return ResponseEntity.ok("Paciente actualizado exitosamente");
	}

	@PostMapping("/appointments")
	public ResponseEntity<String> createAppointment(@RequestBody AppointmentRequest request) throws Exception {
		Appointment appointment = appointmentBuilder.build(
			request.getDate(),
			request.getTime(),
			request.getReason(),
			request.getPatientName(),
			request.getDocument(),
			request.getPhoneNumber(),
			request.getEmail()
		);
		appointment.setDocument(Long.parseLong(request.getDocument()));
		adminUseCase.createAppointment(appointment);
		return ResponseEntity.status(HttpStatus.CREATED).body("Cita creada exitosamente");
	}

	@PostMapping("/invoices")
	public ResponseEntity<String> createInvoice(@RequestBody InvoiceRequest request) throws Exception {
		Invoice invoice = invoiceBuilder.build(
			request.getDocument(),
			request.getPatientName(),
			request.getDoctorName(),
			request.getInsuranceCompany(),
			request.getPolicyNumber(),
			request.getPolicyValidity(),
			request.getPolicyEndingDate(),
			request.getMedicine(),
			request.getProductName(),
			request.getOrder()
		);
		adminUseCase.createInvoice(invoice);
		return ResponseEntity.status(HttpStatus.CREATED).body("Factura creada exitosamente");
	}

	// Inner classes for request DTOs
	public static class PatientRequest {
		private String document;
		private String patientName;
		private String age;
		private String gender;
		private String address;
		private String phoneNumber;
		private String email;

		public String getDocument() { return document; }
		public void setDocument(String document) { this.document = document; }
		public String getPatientName() { return patientName; }
		public void setPatientName(String patientName) { this.patientName = patientName; }
		public String getAge() { return age; }
		public void setAge(String age) { this.age = age; }
		public String getGender() { return gender; }
		public void setGender(String gender) { this.gender = gender; }
		public String getAddress() { return address; }
		public void setAddress(String address) { this.address = address; }
		public String getPhoneNumber() { return phoneNumber; }
		public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
		public String getEmail() { return email; }
		public void setEmail(String email) { this.email = email; }
	}

	public static class AppointmentRequest {
		private String date;
		private String time;
		private String reason;
		private String patientName;
		private String document;
		private String phoneNumber;
		private String email;

		public String getDate() { return date; }
		public void setDate(String date) { this.date = date; }
		public String getTime() { return time; }
		public void setTime(String time) { this.time = time; }
		public String getReason() { return reason; }
		public void setReason(String reason) { this.reason = reason; }
		public String getPatientName() { return patientName; }
		public void setPatientName(String patientName) { this.patientName = patientName; }
		public String getDocument() { return document; }
		public void setDocument(String document) { this.document = document; }
		public String getPhoneNumber() { return phoneNumber; }
		public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
		public String getEmail() { return email; }
		public void setEmail(String email) { this.email = email; }
	}

	public static class InvoiceRequest {
		private String document;
		private String patientName;
		private String doctorName;
		private String insuranceCompany;
		private String policyNumber;
		private String policyValidity;
		private String policyEndingDate;
		private String medicine;
		private String productName;
		private String order;

		public String getDocument() { return document; }
		public void setDocument(String document) { this.document = document; }
		public String getPatientName() { return patientName; }
		public void setPatientName(String patientName) { this.patientName = patientName; }
		public String getDoctorName() { return doctorName; }
		public void setDoctorName(String doctorName) { this.doctorName = doctorName; }
		public String getInsuranceCompany() { return insuranceCompany; }
		public void setInsuranceCompany(String insuranceCompany) { this.insuranceCompany = insuranceCompany; }
		public String getPolicyNumber() { return policyNumber; }
		public void setPolicyNumber(String policyNumber) { this.policyNumber = policyNumber; }
		public String getPolicyValidity() { return policyValidity; }
		public void setPolicyValidity(String policyValidity) { this.policyValidity = policyValidity; }
		public String getPolicyEndingDate() { return policyEndingDate; }
		public void setPolicyEndingDate(String policyEndingDate) { this.policyEndingDate = policyEndingDate; }
		public String getMedicine() { return medicine; }
		public void setMedicine(String medicine) { this.medicine = medicine; }
		public String getProductName() { return productName; }
		public void setProductName(String productName) { this.productName = productName; }
		public String getOrder() { return order; }
		public void setOrder(String order) { this.order = order; }
	}
}
