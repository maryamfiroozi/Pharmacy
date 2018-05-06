package Manager;

public class User {
	private String userName;
	private String Password;
	private String type;  //define the access level of people base on their job
	User(String userName, String Password){
		this.userName = userName;
		this.Password = Password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String gettype() {
		return type;
	}
	public void settype(String type) {
		this.type = type;
	}
}
