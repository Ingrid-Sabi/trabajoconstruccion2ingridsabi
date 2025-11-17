package app.adapter.in.builder;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import app.adapter.in.validators.ClinicalRecordValidator;
import app.adapter.in.validators.EmployeeValidator;
import app.adapter.in.validators.PatientValidator;


import app.domain.model.ClinicalRecord;
import app.domain.model.Employee;
import app.domain.model.Patient;


@Component
public class ClinicalRecordBuilder {
	@Autowired
	private ClinicalRecordValidator clinicalRecordValidator;
	@Autowired
	private EmployeeValidator employeeValidator;
	@Autowired
	private PatientValidator patientValidator;
	
	public ClinicalRecord build(String doctorName, String symptomatology, String reasonConsultation, String diagnosis, String date, String doctorDocument, String patientName) throws Exception{
		ClinicalRecord medicalRecord = new ClinicalRecord();
		Employee doctor = new Employee();
		Patient patient = new Patient();
		doctor.setFullName(employeeValidator.fullNameValidator(doctorName));
		doctor.setDocument(employeeValidator.documentValidator(doctorDocument));
		medicalRecord.setDiagnosis(clinicalRecordValidator.diagnosisValidator(diagnosis));
		medicalRecord.setReasonConsultation(clinicalRecordValidator.reasonConsultationValidator(reasonConsultation));
		medicalRecord.setSymptomatology(clinicalRecordValidator.symptomatologyValidator(symptomatology));
		medicalRecord.setDate(clinicalRecordValidator.dateValidator(date));
		patient.setFullName(patientValidator.fullNameValidator(patientName));
		
		return medicalRecord;
	
	}

}
