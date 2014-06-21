package DomeinModel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Onderdelen.Auto;
import Onderdelen.Gebruiker;
import Onderdelen.Klus;
import Onderdelen.Gebruiker;
import Onderdelen.Product;
import DAO.AutosDAO;
import DAO.GebruikersDAO;
import DAO.KlussenDAO;
import DAO.ProductDAO;

public class AutoTotaalDienst {
    private ArrayList<Product> alleOnderdelen = new ArrayList<Product>();
    private ArrayList<Product> alleBrandstoffen = new ArrayList<Product>();
    private ArrayList<Gebruiker> alleKlanten = new ArrayList<Gebruiker>();
    private ArrayList<Gebruiker> alleKlantenJonger = new ArrayList<Gebruiker>();
    private ArrayList<Gebruiker> alleKlantenOuder = new ArrayList<Gebruiker>();
    private ArrayList<Gebruiker> alleKlantenLG = new ArrayList<Gebruiker>();
    private ArrayList<Gebruiker> alleKlantenBlok = new ArrayList<Gebruiker>();
    private ArrayList<Gebruiker> alleKlantenBrief = new ArrayList<Gebruiker>();
    private ArrayList<Auto> alleAutos = new ArrayList<Auto>();
    private ArrayList<Auto> jongerAutos = new ArrayList<Auto>();
    private ArrayList<Auto> ouderAutos = new ArrayList<Auto>();
    private ArrayList<Gebruiker> jongerdan = new ArrayList<Gebruiker>();
    private ArrayList<Gebruiker> ouderdan = new ArrayList<Gebruiker>();
    private ArrayList<Gebruiker> afwezig = new ArrayList<Gebruiker>();
    private ArrayList<Gebruiker> blokkade = new ArrayList<Gebruiker>();
    private ArrayList<Gebruiker> factuur = new ArrayList<Gebruiker>();
    private ArrayList<Gebruiker> brief = new ArrayList<Gebruiker>();
    private ArrayList<Klus> alleKlussen = new ArrayList<Klus>();
    private ArrayList<Klus> klussenStatus = new ArrayList<Klus>();
    private ArrayList<Gebruiker> alleMonteurs = new ArrayList<Gebruiker>();
    private double literPrijs, werkUurPrijs, maandPrijs, weekPrijs, dagPrijs;
   
    // checkt of ingevoerd gegeven een int getal is
    public static boolean isInteger(String s) {
                try {
            Integer.parseInt(s);
        }
        catch(NumberFormatException e) {
            return false;
        }
        return true;
    }
    public String getToday(){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }
    public void setLiterPrijs(double lp){
        literPrijs = lp;
    }
    public void setWerkUurPrijs(double wup){
        werkUurPrijs = wup;
    }
    public void setWeekPrijs(double wp){
        weekPrijs = wp;
    }
    public void setMaandPrijs(double mp){
        maandPrijs = mp;
    }
    public void setDagPrijs(double dp){
        dagPrijs = dp;
    }
    public double getLiterPrijs(){
        return literPrijs;
    }
    public double getWerkUurPrijs(){
        return werkUurPrijs;
    }
    public double getMaandPrijs(){
        return maandPrijs;
    }
    public double getDagPrijs(){
        return dagPrijs;
    }
    public double getWeekPrijs(){
        return weekPrijs;
    }
    public double klantenKorting (Gebruiker ka){
        double ko = ka.getKorting();
        return ko;
    }
    
    public ArrayList<Product> getAlleOnderdelen(){
    	alleOnderdelen = new ProductDAO().getAlleOnderdelenDB();
        return alleOnderdelen;
    }
    
    public Product getOnderdeelById(int id){
    	  Product onderdeel = new ProductDAO().getOnderdeelFromID(id);
    	   	
    	  return onderdeel;
    }

    public ArrayList<Product> getAlleBrandstoffen(){
		alleBrandstoffen = new ProductDAO().getAlleBrandstoffenDB();
	
    return alleBrandstoffen;
    }
    
    public boolean heeftKlant(String nm){
        boolean b = false;
        for (Gebruiker k: alleKlanten){
            if (k.getNaam().equals(nm)){
                b = true;
            }
        }
        return b;
    }
    
    public Gebruiker zoekGebruiker(String nm, ArrayList<Gebruiker> a){
    	Gebruiker antw = null;
    	for(Gebruiker g: a){
    		if(g.getNaam().equals(nm)){
    			antw = g;
    			break;
    		}
    	}
    	return antw;
    }

    public void verwijderKlant(Gebruiker exKlant, ArrayList a) {
        if (heeftKlant(exKlant.getNaam())) {
            a.remove(exKlant);
        }
    }
    
    public ArrayList<Gebruiker> getAlleKlanten(){
    	return alleKlanten = new GebruikersDAO().getAlleGebruikersDB();
    }
    
    //Hier worden alle Klanten met een auto jonger dan 2010 toegevoegd aan de ArrayList
    public ArrayList<Gebruiker> getAlleKlantenJongerDan2010(){
    	if(alleKlantenJonger.isEmpty() && jongerAutos.isEmpty()) {
	    	alleKlantenJonger = new GebruikersDAO().getAlleGebruikersDB();
	    	jongerAutos = new AutosDAO().getAlleAutosDB();
	    	int x = 0;
	    	for(Auto a: jongerAutos){
	    		if(a.getBouwjaar() < 2010){
	    			x = a.getEigenaarID();
	    			for(Gebruiker g: alleKlantenJonger){
	    				if(g.getGebruikerID() == x){
	    					jongerdan.add(g);
	    				}
	    			}
	    		}
	    	}
    	}
	   	return jongerdan;
    }
    
    //Hier worden alle Klanten met een auto ouder dan 2010 toegevoegd aan de ArrayList
    public ArrayList<Gebruiker> getAlleKlantenOuderDan2010(){
    	if(alleKlantenOuder.isEmpty() && ouderAutos.isEmpty()) {
	    	alleKlantenOuder = new GebruikersDAO().getAlleGebruikersDB();
	    	ouderAutos = new AutosDAO().getAlleAutosDB();
	    	int x = 0;
	    	for(Auto a: ouderAutos){
	    		if(a.getBouwjaar() > 2010){
	    			x = a.getEigenaarID();
	    			for(Gebruiker g: alleKlantenOuder){
	    				if(g.getGebruikerID() == x){
	    					ouderdan.add(g);
	    				}
	    			}
	    		}
	    	}
    	}
	    	return ouderdan;
    }
    
    public ArrayList<Auto> getJongerAutos(){
    	return jongerAutos = new AutosDAO().getAlleAutosDB();
    }
    
    public ArrayList<Gebruiker> getAlleMonteurs(){
    	alleKlanten = new GebruikersDAO().getAlleGebruikersDB();
    	for(Gebruiker g : alleKlanten){
    		if(g.getRol() == 7){
    			alleMonteurs.add(g);
    		}
    	}
    	return alleMonteurs;
    }
    
    public ArrayList<Gebruiker> getAlleKlantenLaatstgeweest(){
    	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    	Calendar test = Calendar.getInstance();
        test.add(Calendar.DATE, -60);
    	if(alleKlantenLG.isEmpty()) {
	    	alleKlantenLG = new GebruikersDAO().getAlleGebruikersDB();
	    	for(Gebruiker g: alleKlantenLG){
	    		String xx = "";
	        	Date date = null;
	    		xx = g.getLaatstgeweest();
	    		try {
	    			date = formatter.parse(xx);
	    			Calendar bezig = Calendar.getInstance();
	    			bezig.setTime(date);
	    			if(bezig.before(test)){
	    				afwezig.add(g);
	    			}	    	 
	    		} catch (ParseException e) {
	    			e.printStackTrace();
	    		}
	    	}
    	}
	    	return afwezig;
    }
    
  //Klanten combobox bij FactuurbetalingBlokkerenFrame
    public ArrayList<Gebruiker> getAlleKlantenBlok(){
    	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    	Calendar test = Calendar.getInstance();
        test.add(Calendar.DATE, -90);
        if(alleKlantenBlok.isEmpty()){
        	alleKlantenBlok = new GebruikersDAO().getAlleGebruikersDB();
        	for(Gebruiker g: alleKlantenBlok){
        		if(g.getOpenFactuur().equals(null)){
        			g.setOpenFactuur("06-06-2012");
        		}
        		String xx = "";
        		Date date = null;
        		xx = g.getOpenFactuur();
        		try {
	    			date = formatter.parse(xx);
	    			Calendar bezig = Calendar.getInstance();
	    			bezig.setTime(date);
	    			if(bezig.before(test)){
	    				blokkade.add(g);
	    			}	    	 
	    		} catch (ParseException e) {
	    			e.printStackTrace();
	    		}
        	}
        }
        return blokkade;
    }
    
    public ArrayList<Gebruiker> getblokkade(){
    	blokkade = new GebruikersDAO().getBlokkadeDB();
        return blokkade;
    }
    
    public void setBlokkade(int gId){
    	new GebruikersDAO().setBlokkade(gId);
    }
    
    public ArrayList<Gebruiker> getAlleKlantenOuder(){
        return alleKlantenOuder;
    }
    
    public ArrayList<Gebruiker> getAlleKlantenLG(){
    	return alleKlantenLG;
    }
    
    public ArrayList<Gebruiker> getAlleKlanten3(){
    	return alleKlantenBlok;
    }
    
    public ArrayList<Gebruiker> getAlleKlanten4(){
    	return alleKlantenBrief;
    }
    
    public ArrayList<Auto> getOuderAutos(){
        return ouderAutos;
    }
    
    // Arraylist van auto's jonger dan 2010
    public ArrayList<Gebruiker> getjongerdan(){
        return jongerdan;
    }
    // Arraylist van auto's ouder dan 2010
    public ArrayList<Gebruiker> getouderdan(){
        return ouderdan;
    }
    //ArrayList van klanten die meer 2 maanden niet zijn langsgeweest
    public ArrayList<Gebruiker> getafwezig(){
        return afwezig;
    }

    //vraagt ArrayList op met klanten die 2 maanden niet zijn langsgeweest
    public ArrayList<Gebruiker> getAlleKlantenAfwezig(){
        Calendar test = Calendar.getInstance();
        test.add(Calendar.DATE, -60);

        for (Gebruiker k : alleKlanten) {
            if(!afwezig.contains(k)){
                afwezig.add(k);
            }
        }
        return afwezig;
    }
    //Maak factuur als klanten langer dan 30 dagen niet hebben betaald
    public ArrayList<Gebruiker> getAlleKlantenBrieven(){
        factuur.removeAll(factuur);
        Calendar test = Calendar.getInstance();
        test.add(Calendar.DATE, -30);
        for (Gebruiker k : alleKlanten){
            if(k.getOpenFactuur() != null){
//                if(k.getOpenFactuur().before(test)){
                    if(!factuur.contains(k)){
                        factuur.add(k);
                    }
//                }
            }
        }
        return factuur;
    }
    //Maak factuur als klanten langer dan 90 dagen niet hebben betaald
    public ArrayList<Gebruiker> getAlleKlantenBrieven90(){
    	if(alleKlantenBrief.isEmpty()) {
    		alleKlantenBrief = new GebruikersDAO().getAlleGebruikersDB();
    		Calendar test = Calendar.getInstance();
    		test.add(Calendar.DATE, -90);
    		Date date1 = test.getTime();
    		for (Gebruiker k : alleKlantenBrief){
    			if(k.getOpenFactuur() != null){
    				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    				Date date2 = null;
    				try {
    					date2 = sdf.parse(k.getOpenFactuur());
    					if(date2.before(date1)==true){
    						if(!brief.contains(k)){
    							brief.add(k);
    						}
    					}
    				} catch (ParseException e) {
    					e.printStackTrace();
    				}
    			}
    		}
    	}
    	return brief;
    }
    
    public void blokkeer(Gebruiker k){
        k.setBlokkade();
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
    //klussen voor in de weekplanning
    public ArrayList<Klus> getAlleKlussen() {
		return alleKlussen = new KlussenDAO().getAlleKlussenDB();
	}
}
