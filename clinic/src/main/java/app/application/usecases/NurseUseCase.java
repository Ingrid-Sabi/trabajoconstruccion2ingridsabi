package app.application.usecases;

import app.domain.model.Patient;
import app.domain.services.RegisterVisit;
import app.domain.services.SearchClinicalOrderByPatient;
import app.domain.services.SearchPatientByDocument;

public class NurseUseCase {
	
	private SearchClinicalOrderByPatient searchClinicalOrderByPatient;
    private SearchPatientByDocument searchPatientByDocument;
    private RegisterVisit segisterVisit;

    public List<ClinicalOrder> searchClinicalOrder(Patient patient) throws Exception{
		return searchClinicalOrderByPatient.search(patient);
	}

    public void searchPatient(Patient patient) throws Exception{
        searchPatientByDocument.search(patient);
    }

    public void registerVisit(Patient patient) throws Exception{
        segisterVisit.registerVisit(patient);
    }

}
