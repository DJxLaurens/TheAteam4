package Webapp;

public class Medewerker {
	private String naam, wachtwoord;
	private int rol_id = 0;
	
	public Medewerker(String nm, int rl, String ps){
		naam = nm;
		rol_id = rl;
		wachtwoord = ps;
	}
	public String getNaam(){
		return naam;
	}
	
	public int getRol(){
		return rol_id;
	}
	
	public String getWw(){
		return wachtwoord;
	}
}