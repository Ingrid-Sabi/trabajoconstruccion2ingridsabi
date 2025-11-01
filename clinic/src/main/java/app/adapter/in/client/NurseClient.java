package app.adapter.in.client;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import app.adapter.in.builder.PatientBuilder;
import app.application.usecases.AdminUseCase;
import app.application.usecases.NurseUseCase;
import app.domain.model.ClinicalOrder;
import app.domain.model.Patient;
import app.domain.services.SearchClinicalOrderByPatient;
import app.domain.services.SearchPatientByDocument;

public class NurseClient {
	
	private static final String MENU = "Ingrese una de las opciones" +
			    "\n 1. Buscar orden medica" +
			    "\n 2. Buscar paciente" +
			    "\n 3. Registrar visita" +
			    "\n 4. Salir";
			    
	private static Scanner reader = new Scanner(System.in);
		@Autowired
		private NurseUseCase nurseUseCase;
		@Autowired
		private PatientBuilder patientBuilder;
	
	    public void session() {
	        boolean session = true;
	        while (session) {
	            session = menu();
	        }
	    }
	
	    private boolean menu(){
	        try {
	            System.out.println(MENU);
	            String option = reader.nextLine();
	            switch (option) {
	                case "1":{
	                	ClinicalOrder order = nurseUseCase.searchClinicalOrder(patient);
	                	if (order != null) {
	                	    System.out.println("Orden médica encontrada: " + order);
	                	} else {
	                	    System.out.println("No se encontró ninguna orden para este paciente.");
	                	}
	                	
	                	
	                }
	                    
	                    
	
	                case "2":{
	                	SearchClinicalOrderByPatient patientSearch = readPatientSearchData();
	                    var patient = nurseUseCase.searchPatient(patientSearch); 
	                    if (patient != null) {
	                        System.out.println("Paciente encontrado: " + patient);
	                    } else {
	                        System.out.println("No se encontró el paciente.");
	                    }
	                    return true;
	                }
	                	
	
	                case "3":{
	                	Patient patient = readPatientByDocument();
	                    nurseUseCase.registerVisit(patient);
	                    System.out.println("Visita registrada correctamente.");
	                    return true;
	                }
	                    
	                    
	
	                case "4":
	                    System.out.println("¡Hasta luego!");
	                    return false;
	            
	                default:
	                System.out.println("Ingrese una opcion valida");
	                    return true;
	            
	                }
	        } catch (Exception e) {
	            System.out.println(e.getMessage());
	            return true;
	        }
	        
	    }

	    private Patient readPatientByDocument() {
	        System.out.println("Ingrese el documento del paciente:");
	        String document = reader.nextLine();

	        
	        return patientBuilder.build( document);
	    }

}
