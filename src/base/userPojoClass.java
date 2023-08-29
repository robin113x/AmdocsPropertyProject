package base;

public class userPojoClass {
	private String userName , password;

	public userPojoClass(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "userPojoClass [userName=" + userName + ", password=" + password + "]";
	}
	
	
}
