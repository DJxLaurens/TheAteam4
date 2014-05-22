package Servlet;

import Webapp.Klant;

public class Auto{
    private String kenteken;
    private String merk;
    private int bouwjaar;
    private String type;
    private Klant eigenaar;
    private String brandstoftype;

    public Auto(String kt, String mk, int bj, String tp, Klant eig, String bt){
        kenteken = kt;
        merk = mk;
        bouwjaar = bj;
        type = tp;
        eigenaar = eig;
        brandstoftype = bt;
    }

    public String getKenteken(){
        return kenteken;
    }

    public void setKenteken(String kt){
        kenteken = kt;
    }

    public String getMerk(){
        return merk;
    }

    public void setMerk(String mk){
        merk = mk;
    }

    public int getBouwjaar(){
        return bouwjaar;
    }

    public void setBouwjaar(int bj){
        bouwjaar = bj;
    }

    public String getType(){
        return type;
    }

    public void setType(String tp){
        type = tp;
    }

    public Klant getEigenaar(){
        return eigenaar;
    }

    public void setEigenaar(Klant eig){
        eigenaar = eig;
    }

    public String getBrandstoftype(){
        return brandstoftype;
    }

    public void setBrandstoftype(String tp){
        brandstoftype = tp;
    }
    
    public String toString(){
        return merk + " " + type;
    }
}