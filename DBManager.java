package Manager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBManager {
	ConnectionClass _connectionObj = new ConnectionClass();
	Connection _connectionString = _connectionObj.GetConnection();

	ArrayList<Drug> _drugList = new ArrayList<>();
	Drug drug;
	int x = 0;

	public int checkLogin(String username, String pass) {
		try {
			Statement stm = _connectionString.createStatement();

			String checkLogin = "select * from UserTable";
			ResultSet result = stm.executeQuery(checkLogin);
			while (result.next()) {
				if (result.getString("userName").equals(username) && result.getString("password").equals(pass)) {
					String userType = result.getString("userType");
					if (userType.equals("Admin")) {
						x = 1;
						break;
					} else if (userType.equals("Seller")) {
						x = 2;
						break;
					}
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return x;
	}

	// show drug list from DrugTable in database
	public ArrayList<Drug> showDrug() {
		try {
			Statement stmShowDrug = _connectionString.createStatement();
			String query = "select * from DrugTable";
			ResultSet result = stmShowDrug.executeQuery(query);
			while (result.next()) {
				String name = result.getString("name");
				int price = Integer.parseInt(result.getString("price"));
				int id = Integer.parseInt(result.getString("drugId"));

				Drug _drug = new Drug();

				_drug.setDrugID(id);
				_drug.setName(name);
				_drug.setPrice(price);

				_drugList.add(_drug);
			}
			return _drugList;

		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	public Drug showSpecialDrug(int drugId) {
		try {
			Statement stmDrug = _connectionString.createStatement();
			String query = "select * from DrugTable where drugId='" + drugId + "'";
			ResultSet result = stmDrug.executeQuery(query);
			while (result.next()) {
				String name = result.getString("name");
				int price = result.getInt("price");

				drug = new Drug();
				drug.setDrugID(drugId);
				drug.setName(name);
				drug.setPrice(price);

			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return drug;
	}

	// update drug information by get druugId
	public boolean updateDrugInfo(int _drugId, Drug drug) throws SQLException {
		Statement stmUpdate = _connectionString.createStatement();
		String query = "update DrugTable set name ='" + drug.getName() + "' , price ='" + drug.getPrice()
				+ "'  where drugId='" + _drugId + "'  ";
		stmUpdate.executeUpdate(query);
		return true;
	}

	public boolean deleteDrug(int drugId) {
		_connectionObj = new ConnectionClass();
		try {
			Statement stmDeleteDrug = _connectionString.createStatement();
			String deleteQuery = "delete from DrugTable where drugId='" + drugId + "'";
			stmDeleteDrug.execute(deleteQuery);
			_connectionObj.CloseConnect();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	/*
	 * public boolean deletePatient(int _drugId) { try { Statement
	 * stmDelete=_connectionString.createStatement(); String
	 * deleteQuery="delete from DrugTable where drugId='"+_drugId+"'";
	 * stmDelete.execute(deleteQuery); _connectionObj.CloseConnect(); return
	 * true; } catch (Exception e) { e.printStackTrace(); } return false; }
	 */

	public boolean insertPatient(Patient _patient) {
		try {
			Statement stmAdd = _connectionString.createStatement();
			String query = "insert into PatientTable (name,lastName,insuranceName,prescriptionId) values ('"
					+ _patient.getName() + "' , '" + _patient.getLastname() + "'" + " , '"
					+ _patient.getInsurance().getInsuranceName() + "' , '"
					+ _patient.getPrescription().getPrescriptionId() + "')";

			stmAdd.executeUpdate(query);
			_connectionObj.CloseConnect();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Drug showInfoForUpdate(int _drugId) {
		try {
			Statement stmShowInfo = _connectionString.createStatement();
			String query = "select * from DrugTable where drugId='" + _drugId + "'  ";
			ResultSet result = stmShowInfo.executeQuery(query);
			while (result.next()) {
				String name = result.getString("name");
				int price = Integer.parseInt(result.getString("price"));
				drug.setName(name);
				drug.setPrice(price);
				drug.setDrugID(_drugId);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return drug;
	}

	public Store showStoreInfo(Drug drug) {
		try {
			Statement stmt = _connectionString.createStatement();
			String query = "select drugstordb.stortable.drugCount from stortable where stortable.drugId = '"
					+ drug.getDrugID() + "'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Store store = new Store();
				store.setNewDrug(drug);
				store.setdrugCount(Integer.parseInt(rs.getString("drugCount")));
				return store;
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return null;

	}

	public boolean UpdateStore(Store store, int newNumber) {
		int existDrug = store.getdrugCount()-newNumber;
		if (existDrug >= 0) {
			try {
				Statement stmt = _connectionString.createStatement();
				String query = "update stortable set drugCount = " + existDrug + "  where drugId = "
						+ store.getNewDrug().getDrugID() + ";";
				stmt.executeUpdate(query);
				return true;
			} catch (Exception e) {
				e.getMessage();
			}
		} else {
			return false;
		}
		return false;

	}

	public boolean InsertPrescriptionToDB(Prescription pr) {
		try {
			Statement stmt = _connectionString.createStatement();
			String query = "Insert into drugstordb.prescriptiontable (sellDate, state) values (" + pr.getSellDate()
					+ "," + pr.getState() + ")";
			stmt.executeUpdate(query);
			return true;
		} catch (Exception e) {
			e.getMessage();
		}
		return false;
	}

	public Drug findDrug(String drugName) {
		int drugId = 0;
		int drugPrice = 0;
		try {
			Statement stmt = _connectionString.createStatement();
			String query = "select * from drugstordb.drugtable where drugstordb.drugtable.name = '" + drugName + "';";
			ResultSet result = stmt.executeQuery(query);
			while (result.next()) {
				drugId = Integer.parseInt(result.getString("drugId"));
				drugName = result.getString("name");
				drugPrice = Integer.parseInt(result.getString("price"));
			}
			Drug drug = new Drug(drugId, drugName, drugPrice);
			return drug;
		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}

	public boolean InsertDrug_Prescription(Prescription pr, Store store, int number) {
		try {
			int price = (number)*(store.getNewDrug().getPrice());
			Statement stmt = _connectionString.createStatement();
			 String query = "Insert into drugstordb.drug_prescriptiontable (drugId, prescriptionId, price) values ("+store.getNewDrug().getDrugID()+","+pr.getPrescriptionId()+","+price+")"; 
			 stmt.executeUpdate(query);
			 return true;
		} catch (Exception e) {
			e.getMessage();
		}
		return false;

	}
	public Prescription findingLastAddedPrescription(){
		int prescriptionId = 0;
		String sellDate = "";
		int state = 0;
		Prescription pr = null;
		try{
		Statement stmt = _connectionString.createStatement();
		String query = "SELECT * FROM drugstordb.prescriptiontable ORDER BY prescriptionId DESC LIMIT 1";
		ResultSet result = stmt.executeQuery(query);
		while (result.next()) {
			prescriptionId = Integer.parseInt(result.getString("prescriptionId"));
			sellDate = result.getString("sellDate");
			state = Integer.parseInt(result.getString("state"));
			pr.setPrescriptionId(prescriptionId);
			pr.setSellDate(sellDate);
			pr.setState(state);
		}
		}
		catch(Exception e){
			e.getMessage();
		}
		return pr;
		
	}
	

}
