package app.infrastructure.persistence.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.ClinicalOrderEntity;



@Repository
public interface ClinicalOrderRepository extends JpaRepository<ClinicalOrderEntity, Long> {
	ClinicalOrderEntity findById(long OrderId);
	List<ClinicalOrderEntity> findByPatient_Document(long document);
	
}
