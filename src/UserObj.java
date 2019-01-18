
public class UserObj {
	
	private String first_name;
	private String last_name;
	private String email;
	private String phone;
	private String company;
	private String password;
	
	public UserObj(String fname,String lname,String email,String phone,String company,String pass){
		this.first_name=fname;
		this.last_name=lname;
		this.email=email;
		this.phone=phone;
		this.company=company;
		this.password=pass;
	}

	public UserObj() {

	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
