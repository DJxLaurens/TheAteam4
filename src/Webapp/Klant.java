package Webapp;

import java.util.Date;

public class Klant {
	private String naam;
	private String wachtwoord;
	private String adres;
	private String postcode;
	private String woonplaats;
	private String telefoonnummer;
	private String emailadres;
	private double korting;
	private String laatstgeweest;
	private String openFactuur;
	private boolean blokkade;
	
	public Klant(String nm, String ww, String adr, String pc, String wp, String tn, String ea, String laatstgeweest2, double kt, String openFactuur2, boolean bk){
		naam = nm;
		wachtwoord = ww;
		adres = adr;
		postcode = pc;
		woonplaats = wp;
		telefoonnummer = tn;
		emailadres = ea;
		laatstgeweest = laatstgeweest2;
		korting = kt;
		openFactuur = openFactuur2;
		blokkade = bk;
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
    
    public String getOpenFactuur(){
        return openFactuur;
    }
    
    public void setOpenFactuur(String of){
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

    public String getLaatstgeweest(){
        return laatstgeweest;
    }

    public void setLaatstgeweest(String dt){
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
