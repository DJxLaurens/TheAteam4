package Onderdelen;

public class Product {
    private int minVoorraad;
    private int voorraad;
    private String productNaam;
    private Double prijs;
    private int type;
    private int productID;

    public Product(int pId, String pNm, int tp, int mV, int vrd){
        minVoorraad = mV;
        voorraad = vrd;
        productNaam = pNm;
        type = tp;
        productID = pId;
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
        return productID;
    }
    public double getProductPrijs(){
        return prijs;
    }
    
    public String toString(){
        return productNaam;
    }
   
}
