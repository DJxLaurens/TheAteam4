package Webapp;

import java.util.Date;

public class Gebruiker {
	private int rol_id;
	private String naam;
	private String wachtwoord;
	private String adres;
	private String postcode;
	private String woonplaats;
	private String telefoonnummer;
	private String emailadres;
	private double korting;
	private boolean blokkade;
	private Date laatstgeweest;
	private Date openfactuur;

	
	public Gebruiker(int rl, String nm, String ww, String adr, String pc, String wp, String tn, String ea, double kt, boolean bk, Date lg, Date of){
		rol_id = rl;
		naam = nm;
		wachtwoord = ww;
		adres = adr;
		postcode = pc;
		woonplaats = wp;
		telefoonnummer = tn;
		emailadres = ea;
		korting = kt;
		blokkade = bk;
		laatstgeweest = lg;
		openfactuur = of;
	}
	
	public String getNaam(){
        return naam;
    }

    public void setNaam(String nm){
        naam = nm;
    }
    
    public String getWachtwoord(){
        return wachtwoord;
    }

    public void setWachtwoord(String ww){
        wachtwoord = ww;
    }
    
    public int getRol(){
        return rol_id;
    }

    public void setRol(int rl){
        rol_id = rl;
    }
    
    public Date getOpenFactuur(){
        return openfactuur;
    }
    
    public void setOpenFactuur(Date of){
        openfactuur = of;        
    }
    
    public void setBlokkade(){
        blokkade = true;
    }
    
    public boolean getBlokkade(){
        return blokkade;
    }

    public String getAdres(){
        return adres;
    }

    public void setAdres(String adr){
        adres = adr;
    }

    public String getPostcode(){
        return postcode;
    }

    public void setPostcode(String pc){
        postcode = pc;
    }

    public String getWoonplaats(){
        return woonplaats;
    }

    public void setWoonplaats(String wp){
        woonplaats = wp;
    }

    public String getTelefoonnummer(){
        return telefoonnummer;
    }

    public void setTelefoonnummer(String tn){
        telefoonnummer = tn;
    }

    public String getEmailadres(){
        return emailadres;
    }

    public void setEmailadres(String em){
        emailadres = em;
    }

    public Date getLaatstgeweest(){
        return laatstgeweest;
    }

    public void setLaatstgeweest(Date dt){
        laatstgeweest = dt;
    }
    
    public void setKorting(double kt){
        korting = kt;
    }
    
    public double getKorting(){
        return korting;
    }

    public String toString(){
        return naam;
    }
	
	
}
