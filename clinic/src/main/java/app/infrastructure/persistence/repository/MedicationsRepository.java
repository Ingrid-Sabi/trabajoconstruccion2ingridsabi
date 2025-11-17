package app.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.MedicationsEntity;


@Repository	
public interface MedicationsRepository  extends JpaRepository<MedicationsEntity, Long> {
    MedicationsEntity findByOrderNumber(Long orderNumber);

}
