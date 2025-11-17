package app.domain.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.DiagnosticHelp;
import app.domain.ports.DiagnosticHelpPort;


@Service
public class DiagnosticHelpService {
	@Autowired
	private DiagnosticHelpPort diagnosticHelpPort;
	
	public void createDiagnosticAid(DiagnosticHelp diagnosticHelp) throws Exception{
		if(diagnosticHelpPort.findByOrderNumber(diagnosticHelp)!=null) {
			throw new Exception("No pueden haber dos ayudas diagnosticas con el mismo numero de orden");
		}
		
		diagnosticHelpPort.save(diagnosticHelp);
	}
}
