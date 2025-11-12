package app.domain.model;

public class ProcedureItem {
	private String procedureDetails;
	private boolean specialist;
	private String frecuency;
	private int count;
	private double cost;

	public String getProcedureDetails() {
		return procedureDetails;
	}

	public void setProcedureDetails(String procedureDetails) {
		this.procedureDetails = procedureDetails;
	}

	public boolean isSpecialist() {
		return specialist;
	}

	public void setSpecialist(boolean specialist) {
		this.specialist = specialist;
	}

	public String getFrecuency() {
		return frecuency;
	}

	public void setFrecuency(String frecuency) {
		this.frecuency = frecuency;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

}
