package Onderdelen;

public class Weekplanning {
	int weekplanningId;
	String klusNaam;
	String monteur;
	String auto;
	String datum;
	
	public Weekplanning(int id, String kNm, String m, String a, String dtm){
			weekplanningId = id;
			klusNaam = kNm;
	        monteur = m;
	        auto = a;
	        datum = dtm;
	    }
	
	public int getId(){
		return weekplanningId;
	}
	
	public String getDatum(){
		return datum;
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
