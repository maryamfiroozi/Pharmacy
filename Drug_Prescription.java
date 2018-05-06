package Manager;

import java.util.ArrayList;

public class Drug_Prescription {
	ArrayList<Drug> drugs = new ArrayList<>();
	private Prescription prescription;
	private int price;
	
	public ArrayList<Drug> getDrugs() {
		return drugs;
	}
	public void setDrugs(ArrayList<Drug> drugs) {
		this.drugs = drugs;
	}
	public Prescription getPrescription() {
		return prescription;
	}
	public void setPrescription(Prescription prescription) {
		this.prescription = prescription;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
