package Webapp;

import java.util.*;

public class Klus {
    private String klusNaam;
    private int klusNummer;
    private ArrayList<Auto>alleAutos = new ArrayList<Auto>();
    private ArrayList<Monteur>alleMonteurs = new ArrayList<Monteur>();
    private ArrayList<String> datum = new ArrayList<String>();
    public Klus(String kNm, int kNr ){
        klusNaam = kNm;
        klusNummer = kNr;
    }
    public void setKlusNaam(String kNm){
        klusNaam = kNm;
    }
    public String getKlusNaam(){
        return klusNaam;
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
        for (Monteur m: alleMonteurs){
            if (m.getNaam().equals(kt)){
                b = true;
            }
        }
        return b;
    }
    public boolean voegMonteurToe(Monteur m){
        boolean b = false;
        if(!heeftMonteur(m.getNaam())){
            alleMonteurs.add(m);
            b = true;
        } 
        return b;
    }
    public boolean voegDatumToe(String d){
        return datum.add(d);
    }
    public ArrayList<String> getAlleData(){
        return datum;
    }
    public ArrayList<Auto> getAlleAutos(){
        return alleAutos;
    }
    public ArrayList<Monteur> getAlleMonteurs(){
        return alleMonteurs;
    }
    
    public String toString(){
        return klusNaam;
    }
}
