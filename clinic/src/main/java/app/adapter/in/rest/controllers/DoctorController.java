package app.adapter.in.rest.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.application.usecases.DoctorUseCase;
import app.domain.model.ClinicalOrder;
import app.domain.model.ClinicalRecord;
import app.domain.model.Patient;

@RestController
@RequestMapping("/api/doctor")
public class DoctorController {

	   @Autowired
	    private DoctorUseCase doctorUseCase;

	    @PostMapping("/clinical-order")
	    public ResponseEntity<String> createOrder(@RequestBody ClinicalOrder ClinicalOrder) {
	        try {
	        	doctorUseCase.createOrder(ClinicalOrder);
	            return ResponseEntity.status(HttpStatus.CREATED)
	                    .body(" Orden médica creada exitosamente");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                    .body(" Error al crear la orden médica: " + e.getMessage());
	        }
	    }

	    @PostMapping("/clinical-record")
	    public ResponseEntity<String> createMedicalRecord(@RequestBody ClinicalRecord clinicalRecord) {
	        try {
	        	doctorUseCase.createMedicalRecord(clinicalRecord);
	            return ResponseEntity.status(HttpStatus.CREATED)
	                    .body(" Registro médico creado exitosamente");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                    .body(" Error al crear el registro médico: " + e.getMessage());
	        }
	    }

	    @PutMapping("/clinical-record/{id}")
	    public ResponseEntity<String> updateMedicalRecord(
	            @PathVariable Long id,
	            @RequestBody ClinicalRecord medicalRecord) {
	        try {
	            medicalRecord.setId(id);
	            doctorUseCase.updateMedicalRecord(medicalRecord);
	            return ResponseEntity.ok("Registro médico actualizado exitosamente");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                    .body("Error al actualizar el registro médico: " + e.getMessage());
	        }
	    }

	    @GetMapping("/clinical-record/{patientDocument}")
	    public ResponseEntity<?> getMedicalRecordByPatient(@PathVariable long patientDocument) {
	        try {
	            Patient patient = new Patient();
	            patient.setDocument(patientDocument);
	            return ResponseEntity.ok(doctorUseCase.searchMedicalRecord(patient));
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                    .body("Error al obtener historial médico: " + e.getMessage());
	        }
	    }
}

