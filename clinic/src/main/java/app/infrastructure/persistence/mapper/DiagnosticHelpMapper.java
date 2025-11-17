package app.infrastructure.persistence.mapper;

import org.springframework.stereotype.Component;

import app.domain.model.DiagnosticHelp;
import app.infrastructure.persistence.entities.DiagnosticHelpEntity;

@Component
public class DiagnosticHelpMapper {

    public DiagnosticHelpEntity toEntity(DiagnosticHelp diagnosticHelp) {
        if (diagnosticHelp == null) return null;

        DiagnosticHelpEntity entity = new DiagnosticHelpEntity();
        entity.setIdDiagnosticHelp(diagnosticHelp.getIdDiagnosticHelp());
        entity.setOrderNumber(diagnosticHelp.getOrderNumber());
        entity.setAmount(diagnosticHelp.getAmount());
        entity.setSpecialistAssistance(diagnosticHelp.isSpecialistAssistance());
        entity.setIdTypeSpecialist(diagnosticHelp.getIdTypeSpecialist());
        entity.setItem(diagnosticHelp.getItem());
        return entity;
    }

    public DiagnosticHelp toDomain(DiagnosticHelpEntity entity) {
        if (entity == null) return null;

        DiagnosticHelp diagnosticHelp= new DiagnosticHelp();
        diagnosticHelp.setIdDiagnosticHelp(entity.getIdDiagnosticHelp());
        diagnosticHelp.setOrderNumber(entity.getOrderNumber());
        diagnosticHelp.setAmount(entity.getAmount());
        diagnosticHelp.setSpecialistAssistance(entity.isSpecialistAssistance());
        diagnosticHelp.setIdTypeSpecialist(entity.getIdTypeSpecialist());
        diagnosticHelp.setItem(entity.getItem());
        return diagnosticHelp;
    }
}