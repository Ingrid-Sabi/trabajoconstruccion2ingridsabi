package app.domain.ports;

import app.domain.model.Invoice;

public interface InvoicePort {
	
	public void save(Invoice billing) throws Exception;
	public Invoice findByPatientDocument(Invoice billing) throws Exception;

}
