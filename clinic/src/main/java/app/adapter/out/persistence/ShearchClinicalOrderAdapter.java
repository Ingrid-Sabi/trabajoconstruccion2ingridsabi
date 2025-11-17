package app.adapter.out.persistence;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.ClinicalOrder;

import app.domain.ports.ShearchClinicalOrderPort;

import app.infrastructure.persistence.entities.ClinicalOrderEntity;

import app.infrastructure.persistence.mapper.ClinicalOrderMapper;

import app.infrastructure.persistence.repository.ClinicalOrderRepository;

@Service
public class ShearchClinicalOrderAdapter  implements ShearchClinicalOrderPort {

    @Autowired
    private ClinicalOrderRepository clinicalOrderRepository;

    @Autowired
    private ClinicalOrderMapper clinicalOrderMapper;

    @Override
    public List<ClinicalOrder> findByOrder(ClinicalOrder clinicalOrder) throws Exception {
        List<ClinicalOrderEntity> entities = clinicalOrderRepository.findByPatient_Document(clinicalOrder.getPatient().getDocument());

        if (entities == null || entities.isEmpty()) {
            throw new Exception("No se encontraron órdenes médicas para el paciente con documento: " 
                    + clinicalOrder.getPatient().getDocument());
        }

        return entities.stream()
                .map(clinicalOrderMapper::toDomain)
                .collect(Collectors.toList());
    }

}
