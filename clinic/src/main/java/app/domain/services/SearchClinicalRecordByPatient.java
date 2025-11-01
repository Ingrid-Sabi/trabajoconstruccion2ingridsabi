package app.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;

import app.domain.model.ClinicalRecord;
import app.domain.model.Patient;
import app.domain.ports.ClinicalRecordPort;
import app.domain.ports.PatientPort;
@Service
public class SearchClinicalRecordByPatient {
	
	private PatientPort patientPort;
	private ClinicalRecordPort clinicalRecordPort;
	
	public List<ClinicalRecord> search(Patient patient) throws Exception {
        patient = patientPort.findByDocument(patient);
        if (patient == null) {
            throw new Exception("No existe el paciente buscado");
        }
		return clinicalRecordPort.findByPatient(patient);
        
    }

}
