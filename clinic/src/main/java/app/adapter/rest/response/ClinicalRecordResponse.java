package app.adapter.rest.response;

public class ClinicalRecordResponse {
	private String document;
	private String patientId;
	private String orderId;

    public String getDocument() { return document; }

    public void setDocument(String document) { this.document = document; }

    public String getpatientId() { return patientId; }

    public void setpatientId(String patientId) { this.patientId = patientId; }

    public String getOrderId() { return orderId; }

    public void setOrderId(String orderId) { this.orderId = orderId; }


}
