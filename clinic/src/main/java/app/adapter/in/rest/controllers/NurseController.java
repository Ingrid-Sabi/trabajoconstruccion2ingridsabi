package app.adapter.in.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.application.usecases.NurseUseCase;
import app.domain.model.ClinicalOrder;
import app.domain.model.Patient;

@RestController
@RequestMapping("/api/nurse")
public class NurseController {

	@Autowired
	private NurseUseCase nurseUseCase;

	@GetMapping("/clinical-orders")
	public ResponseEntity<List<ClinicalOrder>> searchClinicalOrders(@RequestBody PatientRequest request) throws Exception {
		Patient patient = new Patient();
		patient.setDocument(Long.parseLong(request.getDocument()));
		List<ClinicalOrder> orders = nurseUseCase.searchClinicalOrder(patient);
		return ResponseEntity.ok(orders);
	}

	@GetMapping("/patients")
	public ResponseEntity<Patient> searchPatient(@RequestBody PatientRequest request) throws Exception {
		Patient patient = new Patient();
		patient.setDocument(Long.parseLong(request.getDocument()));
		nurseUseCase.searchPatient(patient);
		return ResponseEntity.ok(patient);
	}

	@PostMapping("/visits")
	public ResponseEntity<String> registerVisit(@RequestBody PatientRequest request) throws Exception {
		Patient patient = new Patient();
		patient.setDocument(Long.parseLong(request.getDocument()));
		nurseUseCase.registerVisit(patient);
		return ResponseEntity.ok("Visita registrada exitosamente");
	}

	// Inner class for request DTO
	public static class PatientRequest {
		private String document;

		public String getDocument() { return document; }
		public void setDocument(String document) { this.document = document; }
	}
}



