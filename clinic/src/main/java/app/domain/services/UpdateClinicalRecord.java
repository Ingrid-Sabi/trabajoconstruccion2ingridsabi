package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.ClinicalRecord;
import app.domain.ports.ClinicalRecordPort;
@Service
public class UpdateClinicalRecord {
	@Autowired
	private ClinicalRecordPort clinicalRecordPort;

    public void update(ClinicalRecord clinicalRecord) throws Exception {
        if (clinicalRecordPort.findByPatient(clinicalRecord) == null) {
            throw new Exception("No existe un historial clinico registrado para este paciente");
        }
        clinicalRecordPort.save(clinicalRecord);
    }

}
