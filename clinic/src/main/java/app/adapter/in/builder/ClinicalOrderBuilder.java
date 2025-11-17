package app.adapter.in.builder;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.ClinicalOrderValidator;
import app.adapter.in.validators.PatientValidator;

import app.domain.model.ClinicalOrder;
import app.domain.model.Patient;


@Component
public class ClinicalOrderBuilder {
	@Autowired
	private ClinicalOrderValidator clinicalOrderValidator;
	@Autowired
	private PatientValidator patientValidator;
	
	public ClinicalOrder build(String medications, String procedure, String diagnosticAid, String patientDocument) throws Exception{
		ClinicalOrder clinicalOrder = new ClinicalOrder();
		Patient patient= new Patient();
		clinicalOrder.setDiagnosticAid(clinicalOrderValidator.DiagnosticAidValidator(diagnosticAid));
		clinicalOrder.setMedications(clinicalOrderValidator.MedicationsValidator(medications));
		clinicalOrder.setProcedure(clinicalOrderValidator.ProcedureValidator(procedure));	
		patient.setDocument(patientValidator.documentValidator(patientDocument));
		clinicalOrder.setPatient(patient);

		
		return clinicalOrder;
		
	}
}
