package app.domain.services;

import java.util.List;

import app.domain.model.ClinicalRecord;
import app.domain.model.Patient;
import app.domain.ports.PatientPort;

public class SearchClinicalRecordByPatient {
	
	public List<ClinicalRecord> search(Patient patient) throws Exception {
        patient = PatientPort.findByDocument(patient);
        if (patient == null) {
            throw new Exception("No existe el paciente buscado");
        }
        Object clinicalRecordPort;
		return clinicalRecordPort.findByPatient(patient);
        
    }

}
