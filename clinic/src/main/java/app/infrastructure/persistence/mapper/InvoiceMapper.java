package app.infrastructure.persistence.mapper;



import app.domain.model.Invoice;
import app.infrastructure.persistence.entities.InvoiceEntity;


public class InvoiceMapper {

    public static InvoiceEntity toEntity(Invoice invoice) {
        if (invoice == null) {
            return null;
        }
        InvoiceEntity entity = new InvoiceEntity();
        entity.setId(invoice.getId());
        entity.setDocument(invoice.getDocument());
        entity.setInsuranceCompany(invoice.getInsuranceCompany());
        entity.setPolicyNumber(invoice.getPolicyNumber());
        entity.setPolicyValidity(invoice.getPolicyValidity());
        entity.setPolicyEndingDate(invoice.getPolicyEndingDate());
        entity.setMedicine(invoice.isMedicine());
        entity.setProductName(invoice.getProductName());

        // Relaciones
        entity.setPatientName(PatientMapper.toEntity(invoice.getPatientName()));
        entity.setDoctorName(UserMapper.toEntity(invoice.getDoctorName()));
        entity.setOrder(ClinicalOrderMapper.toEntity(invoice.getOrder()));

        return entity;
    }

    public static Invoice toDomain(InvoiceEntity entity) {
        if (entity == null) {
            return null;
        }
        Invoice invoice = new Invoice();
        invoice.setId(entity.getId());
        invoice.setDocument(entity.getDocument());
        invoice.setInsuranceCompany(entity.getInsuranceCompany());
        invoice.setPolicyNumber(entity.getPolicyNumber());
        invoice.setPolicyValidity(entity.getPolicyValidity());
        invoice.setPolicyEndingDate(entity.getPolicyEndingDate());
        invoice.setMedicine(entity.isMedicine());
        invoice.setProductName(entity.getProductName());

        // Relaciones
        invoice.setPatientName(PatientMapper.toDomain(entity.getPatientName()));
        invoice.setDoctorName(UserMapper.toDomain(entity.getDoctorName()));
        invoice.setOrder(ClinicalOrderMapper.toDomain(entity.getOrder()));

        return invoice;
    }
}

