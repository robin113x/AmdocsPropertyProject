package Base;

import java.util.Properties;


public class SendEmail {
	public boolean UsersInfo(String to,String from, String sub,String txt) {
		boolean flag= false;
		Properties prop=new Properties();
		prop.put("mail.smtp.auth",true);
		prop.put("mail.smtp.starttls.enable",true);
		prop.put("mail.smtp.port","587");
		prop.put("mail.smtp.host","smtp.gmail.com");
		
			
		
		return flag;
	}
}
