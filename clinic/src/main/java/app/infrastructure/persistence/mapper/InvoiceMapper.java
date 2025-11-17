package app.infrastructure.persistence.mapper;



import org.springframework.stereotype.Component;

import app.domain.model.Invoice;
import app.infrastructure.persistence.entities.InvoiceEntity;



@Component
public class InvoiceMapper {

	  private final EmployeeMapper employeeMapper;
	    private final PatientMapper patientMapper;

	    public InvoiceMapper(EmployeeMapper employeeMapper, PatientMapper patientMapper) {
	        this.employeeMapper = employeeMapper;
	        this.patientMapper = patientMapper;
	    }

	    // === Domain → Entity ===
	    public InvoiceEntity toEntity(Invoice invoice) {
	        if (invoice == null) return null;

	        InvoiceEntity entity = new InvoiceEntity();
	        entity.setPatientDocument(invoice.getPatientDocument());
	        entity.setPolicyNumber(invoice.getPolicyNumber());
	        entity.setPatientAge(invoice.getPatientAge());
	        entity.setInsuranceCompanyName(invoice.getInsuranceCompanyName());

	        // java.sql.Date → LocalDate
	        if (invoice.getPolicyValidity() != null)
	            entity.setPolicyValidity(invoice.getPolicyValidity().toLocalDate());

	        if (invoice.getPolicyEndDate() != null)
	            entity.setPolicyEndDate(invoice.getPolicyEndDate().toLocalDate());

	        entity.setDoctorName(employeeMapper.toEntity(invoice.getDoctorName()));
	        entity.setPatientName(patientMapper.toEntity(invoice.getPatientName()));

	        return entity;
	    }

	    // === Entity → Domain ===
	    public Invoice toDomain(InvoiceEntity entity) {
	        if (entity == null) return null;

	        Invoice invoice = new Invoice();
	        invoice.setPatientDocument(entity.getPatientDocument());
	        invoice.setPolicyNumber(entity.getPolicyNumber());
	        invoice.setPatientAge(entity.getPatientAge());
	        invoice.setInsuranceCompanyName(entity.getInsuranceCompanyName());

	        // LocalDate → java.sql.Date
	        if (entity.getPolicyValidity() != null)
	        	invoice.setPolicyValidity(java.sql.Date.valueOf(entity.getPolicyValidity()));

	        if (entity.getPolicyEndDate() != null)
	        	invoice.setPolicyEndDate(java.sql.Date.valueOf(entity.getPolicyEndDate()));

	        invoice.setDoctorName(employeeMapper.toDomain(entity.getDoctorName()));
	        invoice.setPatientName(patientMapper.toDomain(entity.getPatientName()));

	        return invoice;
	    }
}

