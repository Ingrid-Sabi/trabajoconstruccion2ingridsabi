package app.adapter.out.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.ClinicalRecord;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.ports.ClinicalRecordPort;
import app.infrastructure.persistence.entities.ClinicalRecordEntity;
import app.infrastructure.persistence.entities.UserEntity;
import app.infrastructure.persistence.mapper.ClinicalRecordMapper;
import app.infrastructure.persistence.mapper.UserMapper;
import app.infrastructure.persistence.repository.UserRepository;

@Service
public class ClinicalRecordAdapter implements ClinicalRecordPort {

	@Override
	public void save(ClinicalRecord clinicalRecord) throws Exception {
		ClinicalRecordEntity ClinicalRecordEntity = ClinicalRecordMapper.toEntity(clinicalRecord);
		ClinicalRecordEntity.setId(null);
		clinicalRecordRepository.save(ClinicalRecordEntity);
		System.out.println("Se guardado correctamente");
		
	}		
	
	
	@Override
	public List<ClinicalRecord> findByPatient(Patient patient) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Patient findByPatient(ClinicalRecord clinicalRecord) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

	

}



