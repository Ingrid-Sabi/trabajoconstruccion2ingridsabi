package app.domain.ports;

import java.util.List;

import app.domain.model.Employee;
import app.domain.model.Patient;

public interface ShearchPatientPort {
	public Employee findById(Patient patient) throws Exception; 
	public List<Patient> findByPatient(Patient patient)throws Exception;
	public void save(Patient patient) throws Exception;
}
