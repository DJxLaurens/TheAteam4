package Webapp;

public class User {
	private String name, pass, email, address;
	private int rol = 0;
	
	public User(String nm, String adr, String ps, String em, int rl){
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
	public int getRol(){
		return rol;
	}
}
