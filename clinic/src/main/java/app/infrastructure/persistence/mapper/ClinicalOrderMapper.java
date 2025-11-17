package app.infrastructure.persistence.mapper;



import org.springframework.stereotype.Component;

import app.domain.model.ClinicalOrder;
import app.infrastructure.persistence.entities.ClinicalOrderEntity;


@Component
public class ClinicalOrderMapper {

	 public ClinicalOrderEntity toEntity(ClinicalOrder clinicalOrder) {
	        if (clinicalOrder == null) return null;
	        ClinicalOrderEntity entity = new ClinicalOrderEntity();
	        if (clinicalOrder.getOrderId() > 0) {
	            entity.setId(clinicalOrder.getOrderId());
	        }
	        entity.setMedications(clinicalOrder.getMedications());
	        entity.setProcedure(clinicalOrder.getProcedure());
	        entity.setDiagnosticAid(clinicalOrder.getDiagnosticAid());
	        return entity;
	    }

	    public ClinicalOrder toDomain(ClinicalOrderEntity entity) {
	        if (entity == null) return null;

	        ClinicalOrder clinicalOrder = new ClinicalOrder();
	        clinicalOrder.setOrderId(entity.getId());
	        clinicalOrder.setMedications(entity.getMedications());
	        clinicalOrder.setProcedure(entity.getProcedure());
	        clinicalOrder.setDiagnosticAid(entity.getDiagnosticAid());
	        clinicalOrder.setPatient(PatientMapper.toDomain(entity.getPatient()));

	        return clinicalOrder;
	    }
}
