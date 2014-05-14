package Webapp;

public class User {
	private String name, pass, email, address, rol;
	
	public User(String nm, String adr, String ps, String em, String rl){
		name = nm;
		address = adr;
		pass = ps;
		email = em;
		rol = rl;
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
	
	public String getPass(){
		return pass;
	}
	public String getRol(){
		return rol;
	}
}
