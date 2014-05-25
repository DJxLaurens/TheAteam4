package Webapp;

import java.util.Calendar;

public class Gebruiker {
	private int id;
	private String naam;
	private String wachtwoord;
	private String adres;
	private String postcode;
	private String woonplaats;
	private String telefoonnummer;
	private String emailadres;
	private Calendar laatstgeweest;
	private double korting;
	private Calendar openFactuur;
	private boolean blokkade;
	
	public Gebruiker(int i, String nm, String ww, String adr, String pc, String wp, String tn, String ea, int kt, boolean bk, Calendar lg, Calendar of){
		id = i;
		naam = nm;
		wachtwoord = ww;
		adres = adr;
		postcode = pc;
		woonplaats = wp;
		telefoonnummer = tn;
		emailadres = ea;
		laatstgeweest = lg;
		korting = kt;
		openFactuur = of;
		blokkade = bk;
	}
	
	public int getID(){
		return id;
	}
	
	public void setID(int i){
		id = i;
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
    public Calendar getOpenFactuur(){
        return openFactuur;
    }
    
    public void setOpenFactuur(Calendar of){
        openFactuur = of;        
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

    public Calendar getLaatstgeweest(){
        return laatstgeweest;
    }

    public void setLaatstgeweest(Calendar dt){
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
