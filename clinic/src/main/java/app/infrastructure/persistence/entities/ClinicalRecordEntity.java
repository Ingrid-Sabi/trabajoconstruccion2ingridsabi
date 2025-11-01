package app.infrastructure.persistence.entities;

import java.sql.Date;
import jakarta.persistence.*;

@Entity
@Table(name = "clinical_records")
public class ClinicalRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long document;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patient_id", nullable = false)
    private PatientEntity patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doctor_id", nullable = false)
    private UserEntity doctor;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false, length = 200)
    private String motive;

    @Column(length = 200)
    private String diagnosis;

    @Column(length = 150)
    private String medicine;

    @Column(length = 150)
    private String medicalProcedure;

    @Column(length = 50)
    private String doce;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "clinical_order_id")
    private ClinicalOrderEntity clinicalOrder;

    @Column(length = 200)
    private String vaccinationRecord;

    @Column(length = 200)
    private String allergies;

    @Column(length = 200)
    private String proceddureDetail;

    @Column(length = 200)
    private String symptoms;

    @Column(nullable = false)
    private boolean status;

    // ===== Getters y Setters =====
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDocument() {
        return document;
    }

    public void setDocument(Long document) {
        this.document = document;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }

    public UserEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(UserEntity doctor) {
        this.doctor = doctor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getMotive() {
        return motive;
    }

    public void setMotive(String motive) {
        this.motive = motive;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getMedicine() {
        return medicine;
    }

    public void setMedicine(String medicine) {
        this.medicine = medicine;
    }

    public String getMedicalProcedure() {
        return medicalProcedure;
    }

    public void setMedicalProcedure(String medicalProcedure) {
        this.medicalProcedure = medicalProcedure;
    }

    public String getDoce() {
        return doce;
    }

    public void setDoce(String doce) {
        this.doce = doce;
    }

    public ClinicalOrderEntity getClinicalOrder() {
        return clinicalOrder;
    }

    public void setClinicalOrder(ClinicalOrderEntity clinicalOrder) {
        this.clinicalOrder = clinicalOrder;
    }

    public String getVaccinationRecord() {
        return vaccinationRecord;
    }

    public void setVaccinationRecord(String vaccinationRecord) {
        this.vaccinationRecord = vaccinationRecord;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getProceddureDetail() {
        return proceddureDetail;
    }

    public void setProceddureDetail(String proceddureDetail) {
        this.proceddureDetail = proceddureDetail;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
