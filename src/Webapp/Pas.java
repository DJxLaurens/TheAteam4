package Webapp;


public class Pas{
    private String naamrekeninghouder;
    private int pasnummer;
    private String verloopdatum;
    private double tebetalenbedrag;
    private Gebruiker klant;
    
    public Pas(String nrh, int pn, String vd, double tbb, Gebruiker kl){
            naamrekeninghouder = nrh;
            pasnummer = pn;
            verloopdatum = vd;
            tebetalenbedrag = tbb;
            klant = kl;
    }
    
    public void setNaamrekeninghouder(String nrh){
        naamrekeninghouder = nrh;
    }
    
    public String getNaamrekeninghouder(){
        return naamrekeninghouder;
    }
    
    public void setPasNummer(int pn){
        pasnummer = pn;
    }
    
    public int getPasnummer(){
        return pasnummer;
    }
    
    public void setVerloopdatum(String vd){
        verloopdatum = vd;
    }
    
    public String getVerloopdatum(){
        return verloopdatum;
    }
    
    public void setTebetalenbedrag(double tbb){
        tebetalenbedrag = tbb;
    }
    
    public double getTebetalenbedrag(){
        return tebetalenbedrag;
    }
    
    public void setKlant(Gebruiker kl){
        klant = kl;
    }
    
    public Gebruiker getKlant(){
        return klant;
    }
    
    public String toString(){
        String s = "";
        s = s + "Naam rekeninghouder: " + naamrekeninghouder + "\nPasnummer: " + pasnummer + "\nVerloopdatum: " + verloopdatum + "\nTe betalen bedrag: " + tebetalenbedrag + "\n";
        return s;
    }
}
    
    
    
    