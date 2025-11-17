package app.adapter.in.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import app.application.usecases.AdminUseCase;
import app.domain.model.Appointment;
import app.domain.model.EmergencyContact;
import app.domain.model.Invoice;
import app.domain.model.Patient;

@RestController
@RequestMapping("/api/administrator")
@PreAuthorize("hasRole('ADMINISTRATOR')")
public class AdminController {

	  @Autowired
	    private AdminUseCase adminUseCase;



	    @PostMapping("/patient")
	    public ResponseEntity<String> createPatient(@RequestBody Patient patient) {
	        try {
	        	adminUseCase.createPatient(patient);
	            return ResponseEntity.status(HttpStatus.CREATED)
	                    .body("Paciente creado exitosamente");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                    .body("Error al crear el paciente: " + e.getMessage());
	        }
	    }

	    @PutMapping("/patients/{id}")
	    public ResponseEntity<String> updatePatient(@PathVariable Long id, @RequestBody Patient patient) {
	        try {
	            patient.setId(id);
	            adminUseCase.updatePatient(patient);
	            return ResponseEntity.ok("Paciente actualizado exitosamente");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                    .body("Error al actualizar el paciente: " + e.getMessage());
	        }
	    }

	    @PostMapping("/appointment")
	    public ResponseEntity<String> createAppointment(@RequestBody Appointment appointment) {
	        try {
	        	adminUseCase.createAppointment(appointment);
	            return ResponseEntity.status(HttpStatus.CREATED)
	                    .body("Cita médica creada exitosamente");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                    .body("Error al crear la cita médica: " + e.getMessage());
	        }
	    }
	    
	    @PostMapping("/invoice")
	    public ResponseEntity<String> createBilling(@RequestBody Invoice invoice) {
	        try {
	        	adminUseCase.createBilling(invoice);
	            return ResponseEntity.status(HttpStatus.CREATED)
	                    .body("Factura creada exitosamente");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                    .body("Error al crear la factura: " + e.getMessage());
	        }
	    }

	    @PostMapping("/emergencycontacts")
	    public ResponseEntity<String> createEmergencyContact(@RequestBody EmergencyContact emergencyContact) {
	        try {
	        	adminUseCase.createEmergencyContact(emergencyContact);
	            return ResponseEntity.status(HttpStatus.CREATED)
	                    .body("Contacto de emergencia creado exitosamente");
	        } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	                    .body("Error al crear el contacto de emergencia: " + e.getMessage());
	        }
	    }
}
