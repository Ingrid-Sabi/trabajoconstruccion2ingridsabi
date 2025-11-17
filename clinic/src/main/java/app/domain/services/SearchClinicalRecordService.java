package app.domain.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.ClinicalRecord;
import app.domain.model.Patient;

import app.domain.ports.PatientPort;
import app.domain.ports.ShearchClinicalRecordPort;


@Service
public class SearchClinicalRecordService {
	
	  @Autowired
	    private PatientPort patientPort;
	    @Autowired
	    private ShearchClinicalRecordPort shearchClinicalRecordPort;

	    public List<ClinicalRecord> search(Patient patient) throws Exception {
	        Patient existingPatient = patientPort.findByDocument(patient);

	        if (existingPatient == null) {
	            throw new Exception("Debe consultar historia clínica de un paciente registrado");
	        }

	        List<ClinicalRecord> records = shearchClinicalRecordPort.findByPatient(existingPatient);

	        if (records == null || records.isEmpty()) {
	            throw new Exception("El paciente no tiene historias clínicas registradas");
	        }

	        return records;
	    }

}
