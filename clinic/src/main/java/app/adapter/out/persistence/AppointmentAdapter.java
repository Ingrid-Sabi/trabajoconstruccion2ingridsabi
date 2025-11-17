package app.adapter.out.persistence;

import java.sql.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Appointment;
import app.domain.model.Employee;
import app.domain.model.Patient;
import app.domain.ports.AppointmentPort;
import app.infrastructure.persistence.entities.AppointmentEntity;
import app.infrastructure.persistence.mapper.AppointmentMapper;
import app.infrastructure.persistence.repository.AppointmentRepository;

@Service
public class AppointmentAdapter implements AppointmentPort {

    @Autowired
    private AppointmentRepository mappointmentRepository;

    @Autowired
    private AppointmentMapper mappointmentMapper;

    @Override
    public Appointment findById(Appointment mappointment) throws Exception {
        Optional<AppointmentEntity> appointmentEntityOpt =
                mappointmentRepository.findById(mappointment.getAppointmentId());

        if (appointmentEntityOpt.isPresent()) {
            return mappointmentMapper.toDomain(appointmentEntityOpt.get());
        } else {
            throw new Exception("No se encontró la cita médica con id: " + mappointment.getAppointmentId());
        }
    }

    @Override
    public boolean isDoctorAvailable(Employee doctor, Date date) throws Exception {
        Long doctorId = doctor.getId();
        if (doctorId == null) {
            throw new Exception("El doctor no tiene un ID asignado.");
        }

        boolean exists = mappointmentRepository.existsByDoctorIdAndDate(doctorId, date.toLocalDate());
        return !exists;
    }

    @Override
    public boolean isPatientAvailable(Patient patient, Date date) throws Exception {
        Long patientId = patient.getId();
        if (patientId == null) {
            throw new Exception("El paciente no tiene un ID asignado.");
        }

        boolean exists = mappointmentRepository.existsByPatientIdAndDate(patientId, date.toLocalDate());
        return !exists;
    }

    @Override
    public void save(Appointment mappointment) throws Exception {
        AppointmentEntity entity = mappointmentMapper.toEntity(mappointment);
        entity.setAppointmentId(null); 
        mappointmentRepository.save(entity);
        System.out.println("Cita médica guardada correctamente para el doctor " + mappointment.getDoctor().getFullName() + " y el paciente " + mappointment.getPatient().getFullName());
    }

}



