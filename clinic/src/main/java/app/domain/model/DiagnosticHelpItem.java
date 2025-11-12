package app.domain.model;

public class DiagnosticHelpItem extends Item {
	private String details;
	private String amount;
	private double cost;
	private boolean specialist;

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public boolean isSpecialist() {
		return specialist;
	}

	public void setSpecialist(boolean specialist) {
		this.specialist = specialist;
	}

}
