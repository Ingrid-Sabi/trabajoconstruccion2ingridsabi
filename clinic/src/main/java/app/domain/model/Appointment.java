package app.domain.model;

import java.sql.Date;

public class Appointment {
	private long id;
	private Patient patient;
	private User doctorName;
	private Date date;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public User getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(User doctorName) {
		this.doctorName = doctorName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	

}
