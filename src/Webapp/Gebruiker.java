package Webapp;

import java.util.Date;

public class Gebruiker {
	private int rol_id = 0;
	private String naam;
	private String wachtwoord;
	private String adres;
	private String postcode;
	private String woonplaats;
	private String telefoonnummer;
	private String emailadres;
	private double korting;
	private Date laatstgeweest;
	private Date openFactuur;
	private boolean blokkade;
	
	public Gebruiker(int rl, String nm, String ww, String adr, String pc, String wp, String tn, String ea, Date laatstgeweest2, double kt, Date openFactuur2, boolean bk){
		rol_id = rl;
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
	public int getRol(){
		return rol_id;
	}
    public void setRol(int rl){
        rol_id = rl;
        
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
    
    public Date getOpenFactuur(){
        return openFactuur;
    }
    
    public void setOpenFactuur(Date of){
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
