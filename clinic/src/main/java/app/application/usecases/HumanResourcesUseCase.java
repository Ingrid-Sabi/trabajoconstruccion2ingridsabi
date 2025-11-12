package app.application.usecases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.services.CreateUser;
import app.domain.services.UpdateUser;

@Component
public class HumanResourcesUseCase {
	
	@Autowired
	private CreateUser createUser;
	@Autowired
	private UpdateUser updateUser;
	    

	    public void createRrHh(User user) throws Exception {
	        user.setRole(Role.HUMANRESOURCES);
	        createUser.create(user);
	    }

	    public void createAdministrativeStaff(User user) throws Exception {
	        user.setRole(Role.ADMIN);
	        createUser.create(user);
	    }

	    public void createInformationSupport(User user) throws Exception {
	        user.setRole(Role.SUPPORT);
	        createUser.create(user);
	    }

	    public void createNurse(User user) throws Exception {
	        user.setRole(Role.NURSE);
	        createUser.create(user);
	    }

	    public void createDoctor(User user) throws Exception {
	        user.setRole(Role.DOCTORS);
	        createUser.create(user);
	    }

	    public void updateRrHh(User user) throws Exception {
	        user.setRole(Role.HUMANRESOURCES);
	        updateUser.update(user);
	    }

	    public void updateAdministrativeStaff(User user) throws Exception {
	        user.setRole(Role.ADMIN);
	        updateUser.update(user);
	    }

	    public void updateInformationSupport(User user) throws Exception {
	        user.setRole(Role.SUPPORT);
	        updateUser.update(user);
	    }

	    public void updateNurse(User user) throws Exception {
	        user.setRole(Role.NURSE);
	        updateUser.update(user);
	    }

	    public void updateDoctor(User user) throws Exception {
	        user.setRole(Role.DOCTORS);
	        updateUser.update(user);
	    }

}
