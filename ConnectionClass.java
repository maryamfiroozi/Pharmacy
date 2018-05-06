package Manager;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionClass {
	Connection dbConnection ;

	public Connection GetConnection() {
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			dbConnection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/drugstordb", "root", "");
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return dbConnection;

	}

	public void CloseConnect() {
		try {
			dbConnection.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}

