package app.infrastructure.persistence.mapper;



import app.domain.model.ClinicalOrder;
import app.infrastructure.persistence.entities.ClinicalOrderEntity;
import app.infrastructure.persistence.entities.PatientEntity;
import app.infrastructure.persistence.entities.UserEntity;

public class ClinicalOrderMapper {

    // ===== Dominio → Entidad =====
    public static ClinicalOrderEntity toEntity(ClinicalOrder order) {
        if (order == null) {
            return null;
        }

        ClinicalOrderEntity entity = new ClinicalOrderEntity();
        entity.setId(order.getId());
        entity.setDocument(order.getDocument());
        entity.setMedicine(order.getMedicine());
        entity.setDoce(order.getDoce());
        entity.setDate(order.getDate());

        // Mapeo de relaciones
        if (order.getPatientName() != null) {
            entity.setPatient(PatientMapper.toEntity(order.getPatientName()));
        }
        if (order.getDoctorName() != null) {
            entity.setDoctor(UserMapper.toEntity(order.getDoctorName()));
        }

        return entity;
    }

    // ===== Entidad → Dominio =====
    public static ClinicalOrder toDomain(ClinicalOrderEntity entity) {
        if (entity == null) {
            return null;
        }

        ClinicalOrder order = new ClinicalOrder();
        order.setId(entity.getId());
        order.setDocument(entity.getDocument());
        order.setMedicine(entity.getMedicine());
        order.setDoce(entity.getDoce());
        order.setDate(entity.getDate());

        // Mapeo de relaciones
        if (entity.getPatient() != null) {
            order.setPatientName(PatientMapper.toDomain(entity.getPatient()));
        }
        if (entity.getDoctor() != null) {
            order.setDoctorName(UserMapper.toDomain(entity.getDoctor()));
        }

        return order;
    }
}
