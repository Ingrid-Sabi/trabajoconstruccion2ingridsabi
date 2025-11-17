package app.infrastructure.persistence.repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.AppointmentEntity;

@Repository
public interface AppointmentRepository  extends JpaRepository<AppointmentEntity, Long> {

    boolean existsByDoctorIdAndDate(Long doctorId, LocalDate date);

    boolean existsByPatientIdAndDate(Long patientId, LocalDate date);

}
