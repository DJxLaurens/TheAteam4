package Webapp;

public class Pas{
    private String naamrekeninghouder;
    private int pasnummer;
    private String verloopdatum;
    private double tebetalenbedrag;
    private Klant klant;
    
    public Pas(String nrh, int pn, String vd, double tbb, Klant kl){
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
    
    public void setKlant(Klant kl){
        klant = kl;
    }
    
    public Klant getKlant(){
        return klant;
    }
    
    public String toString(){
        String s = "";
        s = s + "Naam rekeninghouder: " + naamrekeninghouder + "\nPasnummer: " + pasnummer + "\nVerloopdatum: " + verloopdatum + "\nTe betalen bedrag: " + tebetalenbedrag + "\n";
        return s;
    }
}
    
    
    
    