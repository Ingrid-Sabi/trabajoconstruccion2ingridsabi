package app.adapter.out.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Invoice;
import app.domain.ports.InvoicePort;
import app.infrastructure.persistence.entities.InvoiceEntity;
import app.infrastructure.persistence.mapper.InvoiceMapper;
import app.infrastructure.persistence.repository.InvoiceRepository;

@Service
public class InvoiceAdapter implements InvoicePort {
	@Autowired
	private InvoiceRepository invoiceRepository;
	@Autowired
	private InvoiceMapper invoiceMapper;
	
	
	@Override
	public Invoice findByPatientDocument(Invoice invoice) throws Exception {
		InvoiceEntity invoiceEntity = invoiceRepository.findByPatientDocument(invoice.getPatientDocument());	
		return invoiceMapper.toDomain(invoiceEntity);	
		
	}

	@Override
	public void save(Invoice invoice) throws Exception {
		InvoiceEntity invoiceEntity = invoiceMapper.toEntity(invoice);
		invoiceEntity.setId(null);
		
		invoiceRepository.save(invoiceEntity);
		System.out.println("Se ha guardado correctamente la factura!");

		
	}

}



