package app.adapter.out.persistence;

import org.springframework.stereotype.Service;

import app.domain.model.Patient;
import app.domain.ports.PatientPort;

@Service
public class PatientAdapter implements PatientPort{

	@Override
	public Patient findByDocument(Patient patient) throws Exception {
		if (patient.getPatientId()==1) {
			return patient;
		}
		return null;
	}

	@Override
	public void save(Patient patient) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
