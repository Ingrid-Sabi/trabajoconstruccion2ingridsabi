package app.infrastructure.persistence.mapper;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.domain.model.ClinicalRecord;
import app.infrastructure.persistence.entities.ClinicalRecordEntity;

@Component
public class ClinicalRecordMapper {

	  @Autowired
	    private final EmployeeMapper employeeMapper;

	    @Autowired
	    private final PatientMapper patientMapper;

	    public ClinicalRecordMapper(EmployeeMapper employeeMapper, PatientMapper patientMapper) {
	        this.employeeMapper = employeeMapper;
	        this.patientMapper = patientMapper;
	    }

	    // === Domain → Entity ===
	    public ClinicalRecordEntity toEntity(ClinicalRecord clinicalRecord) {
	        if (clinicalRecord == null) return null;

	        ClinicalRecordEntity entity = new ClinicalRecordEntity();
	        entity.setDoctorDocument(clinicalRecord.getDoctorDocument());
	        entity.setSymptomatology(clinicalRecord.getSymptomatology());
	        entity.setReasonConsultation(clinicalRecord.getReasonConsultation());
	        entity.setDiagnosis(clinicalRecord.getDiagnosis());

	        if (clinicalRecord.getDate() != null)
	            entity.setDate(clinicalRecord.getDate().toLocalDate());

	        entity.setDoctor(employeeMapper.toEntity(clinicalRecord.getDoctor()));
	        entity.setPatient(patientMapper.toEntity(clinicalRecord.getPatient()));

	        return entity;
	    }

	    // === Entity → Domain ===
	    public ClinicalRecord toDomain(ClinicalRecordEntity entity) {
	        if (entity == null) return null;

	        ClinicalRecord record = new ClinicalRecord();
	        record.setDoctorDocument(entity.getDoctorDocument());
	        record.setSymptomatology(entity.getSymptomatology());
	        record.setReasonConsultation(entity.getReasonConsultation());
	        record.setDiagnosis(entity.getDiagnosis());

	        if (entity.getDate() != null)
	            record.setDate(java.sql.Date.valueOf(entity.getDate()));

	        record.setDoctor(employeeMapper.toDomain(entity.getDoctor()));
	        record.setPatient(patientMapper.toDomain(entity.getPatient()));

	        return record;
	    }
}

