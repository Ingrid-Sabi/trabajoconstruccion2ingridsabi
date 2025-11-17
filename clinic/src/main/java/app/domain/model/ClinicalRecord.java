package app.domain.model;

import java.sql.Date;

public class ClinicalRecord {
	private long id;
	private Employee doctor;
	private long doctorDocument;
	private String symptomatology;
	private String reasonConsultation;
	private String diagnosis;
	private Date date;
	private Patient patient;
	
	public long getDoctorDocument() {
		return doctorDocument;
	}
	public void setDoctorDocument(long doctorDocument) {
		this.doctorDocument = doctorDocument;
	}
	public String getSymptomatology() {
		return symptomatology;
	}
	public void setSymptomatology(String symptomatology) {
		this.symptomatology = symptomatology;
	}
	public String getReasonConsultation() {
		return reasonConsultation;
	}
	public void setReasonConsultation(String reasonConsultation) {
		this.reasonConsultation = reasonConsultation;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Employee getDoctor() {
		return doctor;
	}
	public void setDoctor(Employee doctor) {
		this.doctor = doctor;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
    public void save(ClinicalRecord clinicalRecord) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }
	
	

}
