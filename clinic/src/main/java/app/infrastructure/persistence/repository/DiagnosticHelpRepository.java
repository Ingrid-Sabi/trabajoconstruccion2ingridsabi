package app.infrastructure.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import app.infrastructure.persistence.entities.DiagnosticHelpEntity;


@Repository	
public interface DiagnosticHelpRepository extends JpaRepository<DiagnosticHelpEntity, Long> {
    DiagnosticHelpEntity findByOrderNumber(Long orderNumber);


}