package app.adapter.out.persistence;

import org.springframework.stereotype.Service;

import app.domain.model.EmergencyContact;
import app.domain.ports.CreateEmergencyContactPort;

@Service
public class EmergencyContactAdapter implements CreateEmergencyContactPort {

	@Override
	public void save(EmergencyContact contact) {
		// TODO Auto-generated method stub
		
	}

}



