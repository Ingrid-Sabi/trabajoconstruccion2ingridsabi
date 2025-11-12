package app.adapter.in.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.adapter.in.builder.ClinicalOrderBuilder;
import app.adapter.in.builder.ClinicalRecordBuilder;
import app.application.usecases.DoctorUseCase;
import app.domain.model.ClinicalOrder;
import app.domain.model.ClinicalRecord;
import app.domain.model.Patient;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

	@Autowired
	private DoctorUseCase doctorUseCase;

	@Autowired
	private ClinicalRecordBuilder clinicalRecordBuilder;

	@Autowired
	private ClinicalOrderBuilder clinicalOrderBuilder;

	@PostMapping("/clinical-records")
	public ResponseEntity<String> createClinicalRecord(@RequestBody ClinicalRecordRequest request) throws Exception {
		ClinicalRecord clinicalRecord = clinicalRecordBuilder.create(
			request.getDocument(),
			request.getPatientId(),
			request.getOrderId()
		);
		doctorUseCase.createClinicalRecord(clinicalRecord);
		return ResponseEntity.status(HttpStatus.CREATED).body("Registro clínico creado exitosamente");
	}

	@PutMapping("/clinical-records")
	public ResponseEntity<String> updateClinicalRecord(@RequestBody ClinicalRecordRequest request) throws Exception {
		ClinicalRecord clinicalRecord = clinicalRecordBuilder.create(
			request.getDocument(),
			request.getPatientId(),
			request.getOrderId()
		);
		doctorUseCase.updateClinicalRecord(clinicalRecord);
		return ResponseEntity.ok("Registro clínico actualizado exitosamente");
	}

	@GetMapping("/clinical-records")
	public ResponseEntity<List<ClinicalRecord>> searchClinicalRecords(@RequestBody PatientRequest request) throws Exception {
		Patient patient = new Patient();
		patient.setDocument(Long.parseLong(request.getDocument()));
		List<ClinicalRecord> records = doctorUseCase.searchRecord(patient);
		return ResponseEntity.ok(records);
	}

	@PostMapping("/clinical-orders")
	public ResponseEntity<String> createClinicalOrder(@RequestBody ClinicalOrderRequest request) throws Exception {
		ClinicalOrder clinicalOrder = clinicalOrderBuilder.build(
			request.getId(),
			request.getDocument(),
			request.getPatientName(),
			request.getName(),
			request.getMedicine(),
			request.getDoce()
		);
		doctorUseCase.createClinicalOrder(clinicalOrder);
		return ResponseEntity.status(HttpStatus.CREATED).body("Orden clínica creada exitosamente");
	}

	// Inner classes for request DTOs
	public static class ClinicalRecordRequest {
		private String document;
		private String patientId;
		private String orderId;

		// Getters and setters
		public String getDocument() { return document; }
		public void setDocument(String document) { this.document = document; }
		public String getPatientId() { return patientId; }
		public void setPatientId(String patientId) { this.patientId = patientId; }
		public String getOrderId() { return orderId; }
		public void setOrderId(String orderId) { this.orderId = orderId; }
	}

	public static class ClinicalOrderRequest {
		private String id;
		private String document;
		private String patientName;
		private String name;
		private String medicine;
		private String doce;

		// Getters and setters
		public String getId() { return id; }
		public void setId(String id) { this.id = id; }
		public String getDocument() { return document; }
		public void setDocument(String document) { this.document = document; }
		public String getPatientName() { return patientName; }
		public void setPatientName(String patientName) { this.patientName = patientName; }
		public String getName() { return name; }
		public void setName(String name) { this.name = name; }
		public String getMedicine() { return medicine; }
		public void setMedicine(String medicine) { this.medicine = medicine; }
		public String getDoce() { return doce; }
		public void setDoce(String doce) { this.doce = doce; }
	}

	public static class PatientRequest {
		private String document;

		public String getDocument() { return document; }
		public void setDocument(String document) { this.document = document; }
	}
}

