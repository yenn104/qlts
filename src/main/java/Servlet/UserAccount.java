package Servlet;

public class UserAccount {

	 
	 private String userName;
	 private String sdt;
	 private String mail;
	 private String password;
	 private int admin;
	 
	 public UserAccount(){ 
	 }
	 
	 public UserAccount(String username, String sdt, String mail, String password, int admin){
		 this.userName=username;
		 this.sdt=sdt;
		 this.mail=mail;
		 this.password=password;
		 this.admin = admin;
	 }
	 
	 
	 public UserAccount(String username, String sdt, String mail, String password){
		 this.userName=username;
		 this.sdt=sdt;
		 this.mail=mail;
		 this.password=password;
	 }
	 
	 
	 public UserAccount(String username, String password){
		 this.userName=username; 
		 this.password=password;
	 }
	 
	 public UserAccount(UserAccount us){
		 this.userName=us.userName;
		 this.sdt=us.sdt;
		 this.mail=us.mail;
		 this.password=us.password;
		 this.admin = us.admin;
	 }

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}
	 
}
