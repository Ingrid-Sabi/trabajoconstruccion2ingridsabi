package app.adapter.out.persistence;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.DiagnosticHelp;
import app.domain.ports.DiagnosticHelpPort;
import app.infrastructure.persistence.entities.DiagnosticHelpEntity;
import app.infrastructure.persistence.mapper.DiagnosticHelpMapper;
import app.infrastructure.persistence.repository.DiagnosticHelpRepository;



@Service
public class DiagnosticHelpAdapter implements DiagnosticHelpPort {

    @Autowired
    private DiagnosticHelpRepository diagnosticHelpRepository;

    @Autowired
    private DiagnosticHelpMapper diagnosticHelpMapper;

    @Override
    public DiagnosticHelp findByOrderNumber(DiagnosticHelp diagnosticHelp) throws Exception {
        DiagnosticHelpEntity entity = diagnosticHelpRepository.findByOrderNumber(diagnosticHelp.getOrderNumber());
        return diagnosticHelpMapper.toDomain(entity);
    }

    @Override
    public void save(DiagnosticHelp diagnosticHelp) throws Exception {
        DiagnosticHelpEntity entity = diagnosticHelpMapper.toEntity(diagnosticHelp);
        entity.setIdDiagnosticHelp(null); 
        diagnosticHelpRepository.save(entity);
        System.out.println("Ayuda diagnóstica guardada correctamente con orden #" + diagnosticHelp.getOrderNumber());
    }
}