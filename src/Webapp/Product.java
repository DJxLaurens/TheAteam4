package Webapp;

public class Product {
    private int minVoorraad;
    private int voorraad;
    private String productNaam;
    private int productNummer;
    private Double prijs;
    private int type;

    public Product(int minVrd, int vrd, String pNm, double pr, int tp){
        minVoorraad = minVrd;
        voorraad = vrd;
        productNaam = pNm;
        prijs = pr;
        type = tp;
    }

    public int getType(){
    	return type;
    }
    
    public int getMinVoorraad(){
        return minVoorraad;
    }
    
    public void setMinVoorraad(int minVrd){
        minVoorraad = minVrd;
    }

    public String getProductNaam(){
        return productNaam;
    }
    public void setVoorraad(int vrd){
        voorraad = vrd;
    }

    public int getVoorraad(){
        return voorraad;
    }

    public int getProductNummer(){
        return productNummer;
    }
    public double getProductPrijs(){
        return prijs;
    }
    
    public String toString(){
        return productNaam;
    }
   
}
