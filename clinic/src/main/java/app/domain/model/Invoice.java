package app.domain.model;



public class Invoice {
	private long id;
	private Patient patientName;
    private int patientAge;
    private long document;
    private User doctorName;
    private String insuranceCompany;
    private String policyNumber;
    private String policyValidity;
    private String policyEndingDate;
    private boolean medicine;
    private ClinicalOrder order;
    private String productName;

    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Patient getPatientName() {
        return patientName;
    }
    public void setPatientName(Patient patientName) {
        this.patientName = patientName;
    }
    public int getPatientAge() {
        return patientAge;
    }
    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }
    public long getDocument() {
        return document;
    }
    public void setDocument(long document) {
        this.document = document;
    }
    public User getDoctorName() {
        return doctorName;
    }
    public void setDoctorName(User doctorName) {
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
    public ClinicalOrder getOrder() {
        return order;
    }
    public void setOrder(ClinicalOrder order) {
        this.order = order;
    }
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
    
	

}
