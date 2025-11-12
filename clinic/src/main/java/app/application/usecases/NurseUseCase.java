package app.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.domain.model.ClinicalOrder;
import app.domain.model.Patient;
import app.domain.services.RegisterVisit;
import app.domain.services.SearchClinicalOrderByPatient;
import app.domain.services.SearchPatientByDocument;

@Component
public class NurseUseCase {
	
	@Autowired
	private SearchClinicalOrderByPatient searchClinicalOrderByPatient;
	@Autowired
	private SearchPatientByDocument searchPatientByDocument;
	@Autowired
	private RegisterVisit registerVisit;

    public List<ClinicalOrder> searchClinicalOrder(Patient patient) throws Exception{
		return searchClinicalOrderByPatient.search(patient);
	}

    public void searchPatient(Patient patient) throws Exception{
        searchPatientByDocument.search(patient);
    }

    public void registerVisit(Patient patient) throws Exception{
        registerVisit.registerVisit(patient);
    }

}
