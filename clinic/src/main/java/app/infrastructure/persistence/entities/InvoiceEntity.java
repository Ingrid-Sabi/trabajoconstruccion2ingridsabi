package app.infrastructure.persistence.entities;



import jakarta.persistence.*;

@Entity
@Table(name = "invoices")
public class InvoiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long document;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private PatientEntity patientName;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private UserEntity doctorName;

    private String insuranceCompany;
    private String policyNumber;
    private String policyValidity;
    private String policyEndingDate;
    private boolean medicine;
    private String productName;

    @OneToOne
    @JoinColumn(name = "order_id")
    private ClinicalOrderEntity order;

    // --- Getters y Setters ---
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

    public PatientEntity getPatientName() {
        return patientName;
    }
    public void setPatientName(PatientEntity patientName) {
        this.patientName = patientName;
    }

    public UserEntity getDoctorName() {
        return doctorName;
    }
    public void setDoctorName(UserEntity doctorName) {
        this.doctorName = doctorName;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }
    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }

    public String getPolicyNumber() {
        return policyNumber;
    }
    public void setPolicyNumber(String policyNumber) {
        this.policyNumber = policyNumber;
    }

    public String getPolicyValidity() {
        return policyValidity;
    }
    public void setPolicyValidity(String policyValidity) {
        this.policyValidity = policyValidity;
    }

    public String getPolicyEndingDate() {
        return policyEndingDate;
    }
    public void setPolicyEndingDate(String policyEndingDate) {
        this.policyEndingDate = policyEndingDate;
    }

    public boolean isMedicine() {
        return medicine;
    }
    public void setMedicine(boolean medicine) {
        this.medicine = medicine;
    }

    public ClinicalOrderEntity getOrder() {
        return order;
    }
    public void setOrder(ClinicalOrderEntity order) {
        this.order = order;
    }

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
}
