package app.domain.services;

import app.domain.model.ClinicalRecord;
import app.domain.ports.ClinicalRecordPort;

public class UpdateClinicalRecord {
	
	private ClinicalRecordPort clinicalRecordPort;

    public void update(ClinicalRecord clinicalRecord) throws Exception {
        if (clinicalRecordPort.findByPatient(clinicalRecord) == null) {
            throw new Exception("No existe un historial clinico registrado para este paciente");
        }
        clinicalRecordPort.save(clinicalRecord);
    }

}
