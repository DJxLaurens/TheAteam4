package Onderdelen;

public class Weekplanning {
	int weekplanningId;
	String klusNaam;
	String monteur;
	String auto;
	
	public Weekplanning(int id, String kNm, String m, String a){
			weekplanningId = id;
			klusNaam = kNm;
	        monteur = m;
	        auto = a;
	    }
	
	public int getId(){
		return weekplanningId;
	}
	
	public String getKlusNaam(){
		return klusNaam;
	}
	
	public String getMonteur(){
		return monteur;
	}
	
	public String getAuto(){
		return auto;
	}
	
}
