package app.adapter.rest.response;

public class AppoinmentResponse {
	 private String id;
	    private String document;
	    private String date;
	    private String time;
	    private String reason;
	    private String patientName;
	    private String phoneNumber;
	    private String email;

	    public String getId() { return id; }

	    public void setId(String id) { this.id = id; }

	    public String getDocument() { return document; }

	    public void setDocument(String document) { this.document = document; }

	    public String getDate() { return date; }

	    public void setDate(String date) { this.date = date; }

	    public String getTime() { return time; }

	    public void setTime(String time) { this.time = time; }

	    public String getReason() { return reason; }

	    public void setReason(String reason) { this.reason = reason; }

	    public String getPatientName() { return patientName; }

	    public void setPatientName(String patientName) { this.patientName = patientName; }

	    public String getPhoneNumber() { return phoneNumber; }

	    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

	    public String getEmail() { return email; }

	    public void setEmail(String email) { this.email = email; }

}
