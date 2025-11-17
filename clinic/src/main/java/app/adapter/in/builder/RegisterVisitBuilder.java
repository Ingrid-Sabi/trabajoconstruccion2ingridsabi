package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.ClinicalOrderValidator;
import app.adapter.in.validators.RegisterVisitValidator;
import app.domain.model.ClinicalOrder;
import app.domain.model.RegisterVisit;

@Component
public class RegisterVisitBuilder {

	@Autowired
	private RegisterVisitValidator registerVisitValidator;
	@Autowired
	private ClinicalOrderValidator clinicalorderValidator;
	
	public RegisterVisit build(String bloodPressure, String oxygenLevel, String pulse, String temperature,String medication, String procedures, String diagnosticAids) throws Exception{
		RegisterVisit registerVisit = new RegisterVisit();
		ClinicalOrder order = new ClinicalOrder();
		registerVisit.setBloodPressure(registerVisitValidator.bloddPressureValidator(bloodPressure));
		registerVisit.setOxygenLevel(registerVisitValidator.oxygenLevelValidator(oxygenLevel));
		registerVisit.setPulse(registerVisitValidator.pulseValidator(pulse));
		registerVisit.setTemperature(registerVisitValidator.temperatureValidator(temperature));
		order.setDiagnosticAid(clinicalorderValidator.DiagnosticAidValidator(diagnosticAids));
		order.setMedications(clinicalorderValidator.MedicationsValidator(medication));
		order.setProcedure(clinicalorderValidator.ProcedureValidator(procedures));
				
		return registerVisit;
	}
}
