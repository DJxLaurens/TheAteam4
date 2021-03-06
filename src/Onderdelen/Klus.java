package Onderdelen;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Klus {
    private String klusNaam;
    private String klusOmschrijving;
    private int autoId;
    private int werknemerId;
    private int klusNummer;
	private String datumKlus;
    private int ingepland;
    private int id;
    private ArrayList<Auto>alleAutos = new ArrayList<Auto>();
    private ArrayList<Gebruiker>alleMonteurs = new ArrayList<Gebruiker>();
    private ArrayList<String> datum = new ArrayList<String>();
    public Klus(int id, String kNm, String kO, int aI, int wI, String dat, int ig){
    	klusNummer = id;
    	klusNaam = kNm;
        klusOmschrijving = kO;
        autoId = aI;
        werknemerId = wI;
        ingepland = ig;
		datumKlus = dat;
    }

    public Klus(){
    	
    }
    public String getToday(){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }
    public void setKlusNaam(String kNm){
        klusNaam = kNm;
    }
    public String getKlusNaam(){
        return klusNaam;
    }
    
    public int getIngepland(){
    	return ingepland;
    }
    
    public String getKlusOmschrijving(){
        return klusOmschrijving;
    }
    
    public int getAutoId(){
        return autoId;
    }
    
    public void setDatum(String dat){
    	datumKlus = dat;
    }
    public String getDatum(){
    	return datumKlus;
    }
    public int getWerknemerId(){
        return werknemerId;
    }
    
    public void setKlusNummer(int kNr){
        klusNummer = kNr;
    }
    public int getKlusNummer(){
        return klusNummer;
    }
    public boolean voegAutoToe(Auto nweAuto){
        boolean b = false;
        if(!heeftAuto(nweAuto.getKenteken())){
            alleAutos.add(nweAuto);
            b = true;
        }
        return b;
    }
    public Auto zoekAuto(String kt){
        Auto antw = null;
        for(Auto a: alleAutos){
            if(a.getKenteken().equals(kt)){
                antw = a;
                break;
            }
        }
        return antw;
    }
    
    public boolean heeftAuto(String kt){
        boolean b = false;
        for (Auto a: alleAutos){
            if (a.getKenteken().equals(kt)){
                b = true;
            }
        }
        return b;
    }
    
    public boolean heeftMonteur(String kt){
        boolean b = false;
        for (Gebruiker m: alleMonteurs){
            if (m.getNaam().equals(kt)){
                b = true;
            }
        }
        return b;
    }
    public boolean voegMonteurToe(Gebruiker m){
        boolean b = false;
        if(!heeftMonteur(m.getNaam())){
            alleMonteurs.add(m);
            b = true;
        } 
        return b;
    }
	public void voegDatumToe(String d) {
		datum.add(d);		
	}
    public ArrayList<String> getAlleData(){
        return datum;
    }
    public ArrayList<Auto> getAlleAutos(){
        return alleAutos;
    }
    public ArrayList<Gebruiker> getAlleMonteurs(){
        return alleMonteurs;
    }    
    public String toString(){
        return klusNaam;
    }   
    public String toStringTest(){
        return klusNaam+id+autoId+klusOmschrijving;
    }
}
