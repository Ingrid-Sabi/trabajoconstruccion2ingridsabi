package app.infrastructure.persistence.mapper;



import app.domain.model.ClinicalRecord;
import app.infrastructure.persistence.entities.ClinicalRecordEntity;

public class ClinicalRecordMapper {

    // ===== Dominio → Entidad =====
    public static ClinicalRecordEntity toEntity(ClinicalRecord record) {
        if (record == null) {
            return null;
        }

        ClinicalRecordEntity entity = new ClinicalRecordEntity();
        entity.setId(record.getId());
        entity.setDocument(record.getDocument());
        entity.setDate(record.getDate());
        entity.setMotive(record.getMotive());
        entity.setDiagnosis(record.getDiagnosis());
        entity.setMedicine(record.getMedicine());
        entity.setMedicalProcedure(record.getMedicalProcedure());
        entity.setDoce(record.getDoce());
        entity.setVaccinationRecord(record.getVaccinationRecord());
        entity.setAllergies(record.getAllergies());
        entity.setProceddureDetail(record.getProceddureDetail());
        entity.setSymptoms(record.getSymptoms());
        entity.setStatus(record.isStatus());

        // Relaciones
        if (record.getPatientName() != null) {
            entity.setPatient(PatientMapper.toEntity(record.getPatientName()));
        }
        if (record.getDoctorName() != null) {
            entity.setDoctor(UserMapper.toEntity(record.getDoctorName()));
        }
        if (record.getClinicalOrder() != null) {
            entity.setClinicalOrder(ClinicalOrderMapper.toEntity(record.getClinicalOrder()));
        }

        return entity;
    }

    // ===== Entidad → Dominio =====
    public static ClinicalRecord toDomain(ClinicalRecordEntity entity) {
        if (entity == null) {
            return null;
        }

        ClinicalRecord record = new ClinicalRecord();
        record.setId(entity.getId());
        record.setDocument(entity.getDocument());
        record.setDate(entity.getDate());
        record.setMotive(entity.getMotive());
        record.setDiagnosis(entity.getDiagnosis());
        record.setMedicine(entity.getMedicine());
        record.setMedicalProcedure(entity.getMedicalProcedure());
        record.setDoce(entity.getDoce());
        record.setVaccinationRecord(entity.getVaccinationRecord());
        record.setAllergies(entity.getAllergies());
        record.setProceddureDetail(entity.getProceddureDetail());
        record.setSymptoms(entity.getSymptoms());
        record.setStatus(entity.isStatus());

        // Relaciones
        if (entity.getPatient() != null) {
            record.setPatientName(PatientMapper.toDomain(entity.getPatient()));
        }
        if (entity.getDoctor() != null) {
            record.setDoctorName(UserMapper.toDomain(entity.getDoctor()));
        }
        if (entity.getClinicalOrder() != null) {
            record.setClinicalOrder(ClinicalOrderMapper.toDomain(entity.getClinicalOrder()));
        }

        return record;
    }
}

