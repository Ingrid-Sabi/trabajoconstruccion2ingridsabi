package app.domain.services;

import java.util.List;

import app.domain.model.ClinicalOrder;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.model.enums.Role;
import app.domain.ports.ClinicalOrderPort;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;

//@Service
public class CreateClinicalOrder {
	private UserPort userPort;
    private PatientPort patientPort;
    private ClinicalOrderPort clinicalOrderPort;

    public void create(ClinicalOrder clinicalOrder) throws Exception {
        User doctor = userPort.findByDocument(clinicalOrder.getDoctorName());
        if(doctor == null || !doctor.getRole().equals(Role.DOCTORS)) {
            throw new Exception("Las ordenes solo la puede crear un doctor");
        }
        Patient posiblePatient = new Patient();
        posiblePatient.setDocument(clinicalOrder.getDocument());
        Patient patient = patientPort.findByDocument(posiblePatient);
        if(patient == null) {
            throw new Exception("Las ordenes se deben de aplicar a pacientes registrados");
        }

        clinicalOrder.setPatientName(patient);
        clinicalOrder.setDoctorName(doctor);
        clinicalOrderPort.save(clinicalOrder);

    }

    public List<ClinicalOrder> search(Patient patient) {
        throw new UnsupportedOperationException("Unimplemented method 'search'");
    }

}
