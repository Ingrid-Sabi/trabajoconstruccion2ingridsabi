package app.domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.ClinicalRecord;
import app.domain.model.Employee;

import app.domain.model.Patient;
import app.domain.model.enums.Role;
import app.domain.ports.ClinicalRecordPort;
import app.domain.ports.EmployeePort;
import app.domain.ports.PatientPort;


@Service
public class ClinicalRecordService {
	@Autowired
	private ClinicalRecordPort clinicalRecordPort;
	@Autowired
	private EmployeePort employeePort;
	@Autowired
	private PatientPort patientPort;
	
	public void create(ClinicalRecord clinicalRecord) throws Exception{
		Patient patient = patientPort.findByDocument(clinicalRecord.getPatient());
		if(patient == null) {
			throw new Exception("La historia clinica debe tener un paciente valido");
		}
		
		Employee doctor = employeePort.findByDocument(clinicalRecord.getDoctor());
		
		if(doctor == null || !doctor.getRole().equals(Role.DOCTORS)) {
			throw new Exception("La historia clinica debe ser registrada por un doctor valido");
		}
		
		clinicalRecord.setPatient(patient);
		clinicalRecord.setDoctor(doctor);
		clinicalRecordPort.save(clinicalRecord);
	}
	
	public void update(ClinicalRecord clinicalRecord) throws Exception{
		Patient patient = patientPort.findByDocument(clinicalRecord.getPatient());
		if(patient == null) {
			throw new Exception("La historia clinica debe tener un paciente valido");					
		}
		clinicalRecordPort.update(clinicalRecord);
	}
	
}