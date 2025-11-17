package app.domain.ports;

import java.util.List;

import app.domain.model.ClinicalRecord;
import app.domain.model.Patient;

public interface ShearchClinicalRecordPort {
	public ShearchClinicalRecordPort findById(Patient patient) throws Exception;
	public List<ClinicalRecord> findByPatient(Patient patient)throws Exception;
}
