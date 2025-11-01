package app.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.ClinicalOrder;
import app.domain.model.Patient;
import app.domain.ports.ClinicalOrderPort;
import app.domain.ports.PatientPort;
@Service
public class SearchClinicalOrderByPatient {
	@Autowired
	 private PatientPort patientPort;
	@Autowired
	 private ClinicalOrderPort clinicalOrderPort;
	    
	    public List<ClinicalOrder> search(Patient patient) throws Exception {
	        patient = patientPort.findByDocument(patient);
	        if (patient == null) {
	            throw new Exception("el paciente no se encuentra registrado");
	        }
	        return clinicalOrderPort.findByPatient(patient);
	        
	    }

}
