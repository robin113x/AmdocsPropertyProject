package allproperty;

public class user_ {
	String name;
	String email_id;
	String pswd;
	
	
	
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail_id() {
		return email_id;
	}



	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}



	public String getPswd() {
		return pswd;
	}



	public void setPswd(String pswd) {
		this.pswd = pswd;
	}



	public user_(String name, String email_id, String pswd) {
		super();
		this.name = name;
		this.email_id = email_id;
		this.pswd = pswd;
	}



	public user_(String email_id, String pswd) {
		super();
		this.email_id = email_id;
		this.pswd = pswd;
	}
	
	
}

