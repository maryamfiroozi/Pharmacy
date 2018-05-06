package Manager;


public class Drug {
	private int drugID;
	private String name;
	private int price;
	
	public Drug(int drugID, String name, int Price ) {
		this.drugID = drugID;
		this.name = name;
		this.price = price;
	}
	public Drug() {
		// TODO Auto-generated constructor stub
	}
	public int getDrugID() {
		return drugID;
	}
	public void setDrugID(int drugID) {
		this.drugID = drugID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
