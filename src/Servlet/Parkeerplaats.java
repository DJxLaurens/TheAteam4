package Servlet;

import java.util.*;

public class Parkeerplaats {
    private int nummer;
    private boolean bezet;
    private String naam;
    private String kenteken;
    private String datum;
    private String dag;
    private ArrayList<String> alleDatums = new ArrayList<String>();
    
    public Parkeerplaats(int nm, boolean bzt){
        nummer = nm;
        bezet = bzt;
    }
    public void setNummer(int nm){
        nummer = nm;
    }
    public int getNummer(){
        return nummer;
    }
    
    public void setNaam(String nm){
        naam = nm;
    }
    
    public String getNaam(){
        return naam;
    }
    
    public void setKenteken(String k){
        kenteken = k;
    }
    
    public String getKenteken(){
        return kenteken;
    }
    
    public boolean voegDatumToe(String d){
        return alleDatums.add(d);
    }
    
    public ArrayList<String> getAlleDatums(){
        return alleDatums;
    }
    
    public void setDatum(String d){
        datum = d;
    }
    
    public String getDatum(){
        return datum;
    }
    
    public void setDag(String d){
        dag = d;
    }
    
    public String getDag(){
        return dag;
    }
    
    public void setBezet(boolean bzt){
        bezet = bzt;
    }
    
    public boolean getBezet (){
        return bezet;
    }
    
    public String toString(){
        return "Parkeerplaats " + nummer;
    }
}
