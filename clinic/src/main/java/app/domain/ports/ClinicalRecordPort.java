package app.domain.ports;



import app.domain.model.ClinicalRecord;



public interface ClinicalRecordPort {
	public void save(ClinicalRecord medicalRecord) throws Exception;
	public void update(ClinicalRecord medicalRecord) throws Exception;


}
