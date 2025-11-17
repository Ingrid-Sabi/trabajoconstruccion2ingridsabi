package app.domain.ports;

import app.domain.model.RegisterVisit;

public interface RegisterVisitPort {
	void save(RegisterVisit registerVisit) throws Exception;
    RegisterVisit findByPatientDocument(long document) throws Exception;
	}
