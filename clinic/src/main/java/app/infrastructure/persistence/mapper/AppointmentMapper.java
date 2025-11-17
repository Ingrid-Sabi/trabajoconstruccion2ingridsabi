package app.infrastructure.persistence.mapper;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.domain.model.Appointment;
import app.infrastructure.persistence.entities.AppointmentEntity;

@Component
public class AppointmentMapper {

	  @Autowired
	    private final EmployeeMapper employeeMapper;

	    @Autowired
	    private final PatientMapper patientMapper;

	    public AppointmentMapper(EmployeeMapper employeeMapper, PatientMapper patientMapper) {
	        this.employeeMapper = employeeMapper;
	        this.patientMapper = patientMapper;
	    }

	    // === Domain → Entity ===
	    public AppointmentEntity toEntity(Appointment appointment) {
	        if (appointment == null) return null;

	        AppointmentEntity entity = new AppointmentEntity();
	        entity.setAppointmentId(appointment.getAppointmentId());
	        entity.setDoctor(employeeMapper.toEntity(appointment.getDoctor()));
	        entity.setPatient(patientMapper.toEntity(appointment.getPatient()));

	        if (appointment.getDate() != null)
	            entity.setDate(appointment.getDate().toLocalDate());

	        return entity;
	    }

	    // === Entity → Domain ===
	    public Appointment toDomain(AppointmentEntity entity) {
	        if (entity == null) return null;

	        Appointment appointment = new Appointment();
	        appointment.setAppointmentId(entity.getAppointmentId());
	        appointment.setDoctor(employeeMapper.toDomain(entity.getDoctor()));
	        appointment.setPatient(patientMapper.toDomain(entity.getPatient()));

	        if (entity.getDate() != null)
	            appointment.setDate(java.sql.Date.valueOf(entity.getDate()));

	        return appointment;
	    }
}
