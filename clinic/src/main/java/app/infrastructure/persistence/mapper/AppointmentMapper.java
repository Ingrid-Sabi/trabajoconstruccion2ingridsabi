package app.infrastructure.persistence.mapper;



import app.domain.model.Appointment;
import app.infrastructure.persistence.entities.AppointmentEntity;


public class AppointmentMapper {

    // Convierte de dominio a entidad
    public static AppointmentEntity toEntity(Appointment appointment) {
        if (appointment == null) {
            return null;
        }
        AppointmentEntity entity = new AppointmentEntity();
        entity.setId(appointment.getId());
        entity.setDate(appointment.getDate());
        entity.setTime(appointment.getTime());
        entity.setReason(appointment.getReason());
        return entity;
    }

    // Convierte de entidad a dominio
    public static Appointment toDomain(AppointmentEntity entity) {
        if (entity == null) {
            return null;
        }
        Appointment appointment = new Appointment();
        appointment.setId(entity.getId());
        appointment.setDate(entity.getDate());
        appointment.setTime(entity.getTime());
        appointment.setReason(entity.getReason());
        return appointment;
    }
}
