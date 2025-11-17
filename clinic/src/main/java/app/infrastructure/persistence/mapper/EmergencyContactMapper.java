package app.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import app.domain.model.EmergencyContact;
import app.infrastructure.persistence.entities.EmergencyContactEntity;


@Component
public class EmergencyContactMapper {
	 // === Domain → Entity ===
    public EmergencyContactEntity toEntity(EmergencyContact contact) {
        if (contact == null) return null;

        EmergencyContactEntity entity = new EmergencyContactEntity();
        entity.setName(contact.getName());
        entity.setLastName(contact.getLastName());
        entity.setPhoneNumber(contact.getPhoneNumber());

        return entity;
    }

    // === Entity → Domain ===
    public EmergencyContact toDomain(EmergencyContactEntity entity) {
        if (entity == null) return null;

        EmergencyContact contact = new EmergencyContact();
        contact.setName(entity.getName());
        contact.setLastName(entity.getLastName());
        contact.setPhoneNumber(entity.getPhoneNumber());

        return contact;
    }
}
