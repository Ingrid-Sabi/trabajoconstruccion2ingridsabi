package app.domain.model;



public class Patient {
	private long patientId;
	  private long document;
	    private String patientName;
	    private int age;
	    private String gender;
	    private String address;
	    private String phoneNumber;
	    private String email;
	    
	    
	    
		public long getPatientId() {
			return patientId;
		}
		public void setPatientId(long patientId) {
			this.patientId = patientId;
		}
		public long getDocument() {
			return document;
		}
		public void setDocument(long document) {
			this.document = document;
		}
		public String getPatientName() {
			return patientName;
		}
		public void setPatientName(String patientName) {
			this.patientName = patientName;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getPhoneNumber() {
			return phoneNumber;
		}
		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
	    
	    

}
