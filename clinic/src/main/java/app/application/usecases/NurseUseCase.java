package app.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import app.domain.model.ClinicalOrder;
import app.domain.model.Patient;
import app.domain.model.RegisterVisit;
import app.domain.services.RegisterVisitService;

import app.domain.services.SearchPatientService;
import app.domain.services.ShearchClinicalOrderService;

@Service
public class NurseUseCase {
	
	@Autowired
	private RegisterVisitService registerVisitService;
	@Autowired
	private SearchPatientService searchPatientService;
	@Autowired
	private ShearchClinicalOrderService shearchClinicalOrderService;
	
	public void registerVisit(RegisterVisit registerVisit) throws Exception {		
		registerVisitService.registerVisit(registerVisit);	
	}
	
	public List<Patient> searchPatient(Patient patient) throws Exception{
		return searchPatientService.search(patient);
	}
	
	public List<ClinicalOrder> searchOrder(ClinicalOrder clinicalorder) throws Exception{
		return shearchClinicalOrderService.search(clinicalorder);
	}

}
