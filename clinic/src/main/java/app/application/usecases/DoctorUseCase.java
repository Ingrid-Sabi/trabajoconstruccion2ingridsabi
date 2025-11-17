package app.application.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import app.domain.model.ClinicalOrder;
import app.domain.model.ClinicalRecord;

import app.domain.model.Patient;

import app.domain.services.ClinicalOrderService;
import app.domain.services.ClinicalRecordService;
import app.domain.services.SearchClinicalRecordService;


@Service
public class DoctorUseCase {
	@Autowired
	private ClinicalRecordService clinicalRecordService;
	@Autowired
	private SearchClinicalRecordService searchMedicalRecordService;
	@Autowired
	private ClinicalOrderService orderService;
	
	public void createMedicalRecord(ClinicalRecord medicalRecord) throws Exception {
		
		clinicalRecordService.create(medicalRecord);		
	}
	
    public void updateMedicalRecord(ClinicalRecord medicalRecord) throws Exception {
    	
    	clinicalRecordService.update(medicalRecord);
    }
    
	public List<ClinicalRecord> searchMedicalRecord(Patient patient) throws Exception{
		return searchMedicalRecordService.search(patient);
	}
	
	public void createOrder(ClinicalOrder order) throws Exception {
		
		orderService.createOrder(order);		
	}
}
