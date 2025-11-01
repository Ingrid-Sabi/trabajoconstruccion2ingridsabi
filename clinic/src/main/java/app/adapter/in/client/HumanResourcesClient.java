package app.adapter.in.client;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import app.adapter.in.builder.UserBuilder;

import app.application.usecases.HumanResourcesUseCase;
import app.domain.model.Patient;
import app.domain.model.User;

@Controller
public class HumanResourcesClient {
	
	private static final String MENU="Ingrese una de las Opciones "
			+ "\n 1. Crear Doctor"
			+ "\n 2. Crear Enfermera"
			+ "\n 3.Crear Administrador"
			+ "\n 4. Actualizar Doctor"
			+ "\n 5. Actualizar Enfermera"
			+ "\n 6. Actualizar Administrador"
			+ "\n 7. Salir";
	
	private static Scanner reader = new Scanner(System.in);
	@Autowired
	private HumanResourcesUseCase humanResourcesUseCase;
	@Autowired
	private UserBuilder userBuilder;
	
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
				User user = readInfoFromUser();
				humanResourcesUseCase.createDoctor(user);
				return true;
			}
			case "2":{
				User user = readInfoFromUser();
				humanResourcesUseCase.createNurse(user);
				return true;
			}
			case "3":{
				User user = readInfoFromUser();
				humanResourcesUseCase.createAdministrativeStaff(user);
				return true;
			}
			case "4":{
				User user = readInfoFromUser();
				humanResourcesUseCase.updateDoctor(user);
				return true;
			}
			case "5":{
				User user = readInfoFromUser();
				humanResourcesUseCase.updateNurse(user);
				return true;
			}
			case "6":{
				User user = readInfoFromUser();
				humanResourcesUseCase.updateAdministrativeStaff(user);
				return true;
			}
			case "7":{
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
	
	private User readInfoFromUser() throws Exception{
		System.out.println("ingrese el nombre de la persona");
		String name = reader.nextLine();
		System.out.println("ingrese la cedula de la persona");
		String document = reader.nextLine();
		System.out.println("ingrese el email de la persona");
		String email = reader.nextLine();
		System.out.println("ingrese la dirrecionde la persona");
		String address = reader.nextLine();
		System.out.println("ingrese el telefono de la persona");
		String phoneNumbre = reader.nextLine();
		System.out.println("ingrese la edad de la persona");
		String age = reader.nextLine();
		System.out.println("ingrese el nombre de de usuario");
		String userName = reader.nextLine();
		System.out.println("ingrese la contraseña");
		String password = reader.nextLine();
		
		return userBuilder.build(name, document,email,address,phoneNumbre, age, userName, password);
		
	}

}
