package app.infrastructure.persistence.mapper;

import app.domain.model.Patient;
import app.infrastructure.persistence.entities.PatientEntity;

public class PatientMapper {

    // ===== Dominio -> Entidad =====
    public static PatientEntity toEntity(Patient patient) {
        if (patient == null) {
            return null;
        }

        PatientEntity entity = new PatientEntity();
        entity.setId(patient.getPatientId());
        entity.setDocument(patient.getDocument());
        entity.setPatientName(patient.getPatientName());
        entity.setAge(patient.getAge());
        entity.setGender(patient.getGender());
        entity.setAddress(patient.getAddress());
        entity.setPhoneNumber(patient.getPhoneNumber());
        entity.setEmail(patient.getEmail());
        return entity;
    }

    // ===== Entidad -> Dominio =====
    public static Patient toDomain(PatientEntity entity) {
        if (entity == null) {
            return null;
        }

        Patient patient = new Patient();
        patient.setPatientId(entity.getId());
        patient.setDocument(entity.getDocument());
        patient.setPatientName(entity.getPatientName());
        patient.setAge(entity.getAge());
        patient.setGender(entity.getGender());
        patient.setAddress(entity.getAddress());
        patient.setPhoneNumber(entity.getPhoneNumber());
        patient.setEmail(entity.getEmail());
        return patient;
    }
}

