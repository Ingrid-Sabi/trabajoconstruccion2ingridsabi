package app.adapter.out.persistence;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.ClinicalRecord;
import app.domain.model.Patient;
import app.domain.ports.ShearchClinicalRecordPort;
import app.infrastructure.persistence.entities.ClinicalRecordEntity;
import app.infrastructure.persistence.mapper.ClinicalRecordMapper;
import app.infrastructure.persistence.repository.ClinicalRecordRepository;


@Service
public class ShearchClinicalRecordAdapter implements ShearchClinicalRecordPort {

    @Autowired
    private ClinicalRecordRepository clinicalRecordRepository;

    @Autowired
    private ClinicalRecordMapper clinicalRecordMapper;

    @Override
    public List<ClinicalRecord> findByPatient(Patient patient) throws Exception {
        List<ClinicalRecordEntity> entities = clinicalRecordRepository.findByPatient_Document(patient.getDocument());

        if (entities == null || entities.isEmpty()) {
            throw new Exception("No se encontraron historias clínicas para el paciente con documento: " + patient.getDocument());
        }

        return entities.stream()
                .map(clinicalRecordMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public ShearchClinicalRecordPort findById(Patient patient) throws Exception {
        throw new UnsupportedOperationException("Búsqueda por ID no implementada todavía");
    }

}
