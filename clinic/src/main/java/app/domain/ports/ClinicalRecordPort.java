package app.domain.ports;

import java.util.List;

import app.domain.model.ClinicalRecord;
import app.domain.model.Patient;


public interface ClinicalRecordPort {
	public void save(ClinicalRecord clinicalRecord) throws Exception;
    public List<ClinicalRecord> findByPatient(Patient patient) throws Exception;
    public Patient findByPatient(ClinicalRecord clinicalRecord);


}
