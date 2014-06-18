package Onderdelen;

public class Product {
	private int productID;
    private String productNaam;
    private int type;
    private int minVoorraad;
    private int voorraad;
    private double prijs;
    private int inBestelling;

    public Product(int pId, String pNm, int tp, int mV, int vrd, int iB){
    	productID = pId;
    	productNaam = pNm;
    	type = tp;
        minVoorraad = mV;
        voorraad = vrd;
        inBestelling = iB;
    }
    
    public Product() {
	}

	public int getProductID(){
    	return productID;
    }
    
    public void setProductID(int pi){
    	productID = pi;
    }
    
    public String getProductNaam(){
        return productNaam;
    }
    
    public void setProductNaam(String pn){
    	productNaam = pn;
    }
    
    public int getType(){
    	return type;
    }
    
    public void setType(int t){
    	type = t;
    }
    
    public int getMinVoorraad(){
        return minVoorraad;
    }
    
    public void setMinVoorraad(int minVrd){
        minVoorraad = minVrd;
    }

    public int getVoorraad(){
        return voorraad;
    }
    
    public void setVoorraad(int vrd){
        voorraad = vrd;
    }

    public int getInBestelling(){
        return inBestelling;
    }
    
    public int getProductNummer(){
        return productID;
    }
    
    public void setProductNummer(int pn){
        productID = pn;
    }
    
    public double getProductPrijs(){
        return prijs;
    }
    
    public void setProductPrijs(double pp){
        prijs = pp;
    }
    
    public String toString(){
        return productNaam;
    }
   
}
