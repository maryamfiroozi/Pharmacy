
public class Prescription {
	private int prescriptionId;
	public int getPrescriptionId() {
		return prescriptionId;
	}
	public void setPrescriptionId(int prescriptionId) {
		this.prescriptionId = prescriptionId;
	}
	private String sellDate;
	private boolean state;    //Whether the patient has an insurance or not
	private int totalPrice;  //summation of the price of each drug
	public String getSellDate() {
		return sellDate;
	}
	public void setSellDate(String sellDate) {
		this.sellDate = sellDate;
	}
	public boolean isState() {
		return state;
	}
	public void setState(boolean state) {
		this.state = state;
	}
	public void settotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public double gettotalPrice() {
		return totalPrice;
	}

}
