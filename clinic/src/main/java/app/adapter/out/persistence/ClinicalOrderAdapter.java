package app.adapter.out.persistence;

import java.util.List;

import org.springframework.stereotype.Service;

import app.domain.model.ClinicalOrder;
import app.domain.model.Patient;
import app.domain.ports.ClinicalOrderPort;

@Service
public class ClinicalOrderAdapter implements ClinicalOrderPort {

	@Override
	public ClinicalOrder findByDocument(ClinicalOrder clinicalOrder) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ClinicalOrder> findByPatient(Patient patient) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(ClinicalOrder clinicalOrder) throws Exception {
		// TODO Auto-generated method stub
		
	}

}



