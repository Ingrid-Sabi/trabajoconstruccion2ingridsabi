package app.domain.services;

import app.domain.model.ClinicalOrder;
import app.domain.model.ClinicalRecord;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.ports.ClinicalOrderPort;
import app.domain.ports.ClinicalRecordPort;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;

public class CreateClinicalRecord {
	
	private UserPort userPort;
    private PatientPort patientPort;
    private ClinicalOrderPort clinicalOrderPort;
    private ClinicalRecordPort clinicalRecordPort;

    public void create(ClinicalRecord clinicalRecord) throws Exception {
        Patient patient = patientPort.findByDocument(clinicalRecord.getPatientName());
        if(patient==null) {
            throw new Exception("La historia debe de tener un paciente válido");
        }
        User doctor = userPort.findByDocument(clinicalRecord.getDoctorName());
        if(doctor==null || !doctor.getRole().equals(Role.DOCTORS)) {
        throw new Exception("la historia clinica debe ser registrada por un veterinario valido");
        }
        ClinicalOrder clinicalOrder = clinicalOrderPort.findByDocument(ClinicalRecord.getclinicalOrder());
        if(clinicalOrder==null) {
            throw new Exception("La historia debe de tener una orden válida asociada");
        }
        clinicalRecord.setPatientName(patient);
        clinicalRecord.setDoctorName(doctor);
        clinicalRecord.setClinicalOrder(clinicalOrder);
        clinicalRecordPort.save(clinicalRecord);
}

}
