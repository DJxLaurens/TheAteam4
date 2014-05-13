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
	
	public String getPass(){
		return pass;
	}
}
