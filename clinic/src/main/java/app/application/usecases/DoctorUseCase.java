package app.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.domain.model.ClinicalOrder;
import app.domain.model.ClinicalRecord;
import app.domain.model.Patient;
import app.domain.services.CreateClinicalRecord;
import app.domain.services.SearchClinicalRecordByPatient;
import app.domain.services.UpdateClinicalRecord;

@Component
public class DoctorUseCase {
	
	@Autowired
	private CreateClinicalRecord createClinicalRecord;
	@Autowired
	private UpdateClinicalRecord updateClinicalRecord;
	@Autowired
	private app.domain.services.CreateClinicalOrder createClinicalOrder;
	@Autowired
	private SearchClinicalRecordByPatient searchClinicalRecord;
    
    public List<ClinicalRecord> searchRecord(Patient patient) throws Exception{
		return searchClinicalRecord.search(patient);
	}

    public void createClinicalRecord(ClinicalRecord clinicalRecord) throws Exception{
        createClinicalRecord.create(clinicalRecord);
    }

    public void updateClinicalRecord(ClinicalRecord clinicalRecord) throws Exception{
        updateClinicalRecord.update(clinicalRecord);
    }

    public void createClinicalOrder(ClinicalOrder clinicalOrder) throws Exception{
        createClinicalOrder.create(clinicalOrder);
    }

}
