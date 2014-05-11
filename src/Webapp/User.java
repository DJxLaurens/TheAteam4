package Webapp;

public class User {
	private static String name, pass;
	
	public User(String nm, String ps){
		name = nm;
		pass = ps;
	}
	public void setName(String nm){
		name = nm;
	}
	public void setPass(String ps){
		pass = ps;
	}
	public static String getName(){
		return name;
	}
	
	public String getPass(){
		return pass;
	}
}
