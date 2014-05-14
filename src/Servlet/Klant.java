package Servlet;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Klant{
    private String naam;
    private int klantnummer;
    private String adres;
    private String postcode;
    private String woonplaats;
    private int telefoonnummer;
    private String emailadres;
    private Calendar laatstgeweest;
    private double korting;
    private Calendar openFactuur;
    private boolean blokkade;

    public Klant(String nm, int kl, String adr, String pc, String wp, int tn, String em, Calendar lg, double kt){
        naam = nm;
        klantnummer = kl;
        adres = adr;
        postcode = pc;
        woonplaats = wp;
        telefoonnummer = tn;
        emailadres = em;
        laatstgeweest = lg;
        korting = kt;
        blokkade = false;
    }

    public String getNaam(){
        return naam;
    }

    public void setNaam(String nm){
        naam = nm;
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

    public int getKlantnummer(){
	return klantnummer;
    }

    public void setKlantnummer(int at){
        klantnummer = at;
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

    public int getTelefoonnummer(){
        return telefoonnummer;
    }

    public void setTelefoonnummer(int tn){
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