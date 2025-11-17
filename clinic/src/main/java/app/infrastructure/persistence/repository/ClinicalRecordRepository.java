package app.infrastructure.persistence.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.ClinicalRecordEntity;


@Repository
public interface ClinicalRecordRepository extends JpaRepository<ClinicalRecordEntity, Long> {

	  ClinicalRecordEntity findByDoctorDocumentAndPatient_Id(Long doctorDocument, Long patientId);
	    Optional<ClinicalRecordEntity> findById(Long id);
	    List<ClinicalRecordEntity> findByPatient_Document(Long document);

}
