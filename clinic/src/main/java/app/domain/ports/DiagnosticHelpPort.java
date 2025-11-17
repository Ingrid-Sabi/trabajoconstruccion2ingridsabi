package app.domain.ports;

import app.domain.model.DiagnosticHelp;

public interface DiagnosticHelpPort {
	public DiagnosticHelp findByOrderNumber(DiagnosticHelp diagnosticHelp) throws Exception;
	public void save(DiagnosticHelp diagnosticHelp) throws Exception;
}