package app.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.ClinicalOrderEntity;
import app.infrastructure.persistence.entities.PatientEntity;


@Repository
public interface ClinicalOrderRepository extends JpaRepository<ClinicalOrderEntity, Long> {
	public ClinicalOrderEntity findById(long id);

	public List<ClinicalOrderEntity> findByPatient(PatientEntity entity);
	
}
