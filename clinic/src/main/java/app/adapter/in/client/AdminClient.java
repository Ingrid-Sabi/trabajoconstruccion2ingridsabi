package app.adapter.in.client;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;

import app.adapter.in.builder.AppointmentBuilder;
import app.adapter.in.builder.InvoiceBuilder;
import app.adapter.in.builder.PatientBuilder;
import app.adapter.in.builder.UserBuilder;
import app.application.usecases.AdminUseCase;
import app.domain.model.Appointment;
import app.domain.model.Invoice;
import app.domain.model.Patient;
import app.domain.model.User;

public class AdminClient {
	
	private static final String MENU="Ingrese una de las Opciones \n 1. Crear Paciente"
			+ "\n 2. Actualizar Paciente"
			+ "\n 3.Crear Cita"
			+ "\n 4. Crear Factura"
			+ "\n 5. Crear Contacto De Emergencia"
			+ "\n 6. Salir";
	
	private static Scanner reader = new Scanner(System.in);
	@Autowired
	private AdminUseCase adminUseCase;
	@Autowired
	private PatientBuilder patientBuilder;
	@Autowired
	private AppointmentBuilder appointmentBuilder;
	@Autowired
	private InvoiceBuilder invoiceBuilder;
	
	public void session () {
		boolean session = true;
		while (session) {
			session= menu();
		}
			
	}
	
	private boolean menu() {
		try {
			System.out.println(MENU);
			String option =reader.nextLine();
			switch (option) {
			case "1":{
				Patient patient = readInfoFromPatient();
				adminUseCase.createPatient(patient);
				return true;
			}
			case "2":{
				Patient patient = readInfoFromPatient();
				adminUseCase.update(patient);
				return true;
			}
			case "3":{
				Patient patient = readAppointmentData();
				adminUseCase.createMedicalAppointment(patient);
				return true;
			}
			case "4":{
				Invoice invoice = readInvoiceData();
				adminUseCase.createInvoice(invoice);
				return true;
			}
			/*case "5":{
				Patient patient = readInfoFromPatient();
				adminUseCase.createInvoice(invoice);
				return true;
			}
			*/
			case "6":{
				System.out.println("Hasta luego \n Cerrando sesion");
				return false;
			}
			default :{
				System.out.println("Ingrese una opcion valida");
				return true;
			}
			}
			
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			return true;
			
		}
	}
	
	private Patient readInfoFromPatient() throws Exception{
		System.out.println("ingrese el nombre del paciente");
		String name = reader.nextLine();
		System.out.println("ingrese la cedula del paciente");
		String document = reader.nextLine();
		System.out.println("ingrese el email del paciente");
		String email = reader.nextLine();
		System.out.println("ingrese la direccion del paciente");
		String address = reader.nextLine();
		System.out.println("ingrese telefono del paciente");
		String phoneNumbre = reader.nextLine();
		System.out.println("ingrese la edad de la persona");
		String age = reader.nextLine();
		System.out.println("ingrese el genero de la persona");
		String gender = reader.nextLine();
		
		
		return patientBuilder.build(name, document,email,address,phoneNumbre, age, gender);
		
	}
	
	private Appointment readAppointmentData() throws Exception {
        System.out.println("Ingrese el nombre del paciente");
        String namePatient = reader.nextLine();
        /*System.out.println("Ingrese el documento del paciente");
        String document = reader.nextLine();*/
        
        
       /* System.out.println("Ingrese la fecha de la cita");
        String date = reader.nextLine();*/
        
        System.out.println("Ingrese el nombre del doctor");
        String doctorName = reader.nextLine();
        
        return appointmentBuilder.build( namePatient,doctorName);
    }
	
	 private Invoice readInvoiceData() throws Exception {
	        System.out.println("Ingrese el documento del paciente");
	        String document = reader.nextLine();
	        System.out.println("Ingrese el nombre del paciente");
	        String patientName = reader.nextLine();
	        System.out.println("Ingrese la edad del paciente");
	        String age = reader.nextLine();
	        System.out.println("Ingrese el nombre del doctor");
	        String nameDoctor = reader.nextLine();
	        System.out.println("Ingrese la compania de seguros");
	        String insuranceCompany = reader.nextLine();
	        System.out.println("Ingrese el numero de poliza");
	        String policyNumber = reader.nextLine();
	        System.out.println("Ingrese la vigencia de la poliza"); 
	        String policyValidity = reader.nextLine();
	        System.out.println("Ingrese la fecha de vencimiento de la poliza");
	        String policyEndingDate = reader.nextLine();
	        System.out.println("Ingrese si el paciente requiere medicamentos (Si/No)");
	        String medicine = reader.nextLine();
	        System.out.println("Ingrese el nombre del producto");
	        String productName = reader.nextLine();
	        System.out.println("Ingrese la orden clinica");
	        String order = reader.nextLine();

	        return InvoiceBuilder.build(document,patientName,age,doctorName,insuranceCompany,policyNumber,policyValidity,  policyEndingDate, medicine, productName,  order);
	    }

}
