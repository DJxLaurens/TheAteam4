package Webapp;

public class User {
	private String name, pass, email, address;
	
	public User(String nm, String adr, String ps, String em){
		name = nm;
		address = adr;
		pass = ps;
		email = em;
	}
	
	public void setName(String nm){
		name = nm;
	}
	public void setPass(String ps){
		pass = ps;
	}
	public String getName(){
		return name;
	}
	
	public String getAddress(){
		return address;
	}
	
	public String getEmail(){
		return email;
	}
	
	public String getPassword(){
		return pass;
	}
	
	public String getPass(){
		return pass;
	}
}
