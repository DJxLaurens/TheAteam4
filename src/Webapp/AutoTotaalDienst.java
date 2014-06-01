package Webapp;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Connection.AutosDAO;
import Connection.KlussenDAO;
import Connection.ProductDAO;
import Connection.GebruikersDAO;

public class AutoTotaalDienst {
    private ArrayList<Product> alleOnderdelen = new ArrayList<Product>();
    private ArrayList<Product> alleOnderdelen2 = new ArrayList<Product>();
    private ArrayList<Product> alleBrandstoffen = new ArrayList<Product>();
    private ArrayList<Gebruiker> alleKlanten = new ArrayList<Gebruiker>();
    private ArrayList<Gebruiker> alleKlanten1 = new ArrayList<Gebruiker>();
    private ArrayList<Gebruiker> alleKlanten2 = new ArrayList<Gebruiker>();
    private ArrayList<Auto> alleAutos = new ArrayList<Auto>();
    private ArrayList<Auto> alleAutos1 = new ArrayList<Auto>();
    private ArrayList<Gebruiker> jongerdan = new ArrayList<Gebruiker>();
    private ArrayList<Gebruiker> ouderdan = new ArrayList<Gebruiker>();
    private ArrayList<Gebruiker> afwezig = new ArrayList<Gebruiker>();
    private ArrayList<Gebruiker> blokkade = new ArrayList<Gebruiker>();
    private ArrayList<Gebruiker> factuur = new ArrayList<Gebruiker>();
    private ArrayList<Klus> alleKlussen = new ArrayList<Klus>();
    private ArrayList<Klus> alleKlussenCombo = new ArrayList<Klus>();
    private ArrayList<Klus> klussenStatus = new ArrayList<Klus>();
    private ArrayList<Monteur> alleMonteurs = new ArrayList<Monteur>();
    private ArrayList<Parkeerplaats> alleParkeerplaatsen = new ArrayList<Parkeerplaats>();
    private ArrayList<Parkeerplaats> alleVrijeParkeerplaatsen = new ArrayList<Parkeerplaats>();
    private ArrayList<Parkeerplaats> alleBezetteParkeerplaatsen = new ArrayList<Parkeerplaats>();
    private ArrayList<Parkeerplaats> alleReserveringen = new ArrayList<Parkeerplaats>();
    private ArrayList<Pas> allePassen = new ArrayList<Pas>();
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

    public boolean heeftOnderdeel(int artNr){
//    	if (alleOnderdelen == null) {
//    		alleOnderdelen = new Dbconnectie().getAlleProducten();
//    	}
    	
        boolean b = false;
        for (Product p: alleOnderdelen){
            if (p.getProductNummer() == (artNr)){
                    b = true;
            }
        }
        return b;
    }
    public boolean voegOnderdeelToe(Product nwOnderdeel){
        boolean b = false;
        if(!heeftOnderdeel(nwOnderdeel.getProductNummer())){
            alleOnderdelen.add(nwOnderdeel);
            //new Dbconnectie().saveOnderdeel(nwOnderdeel);
            b = true;
        }
        return b;
    }

    public void verwijderOnderdeel(Product exOnderdeel) {
        if (heeftOnderdeel(exOnderdeel.getProductNummer())) {
            alleOnderdelen.remove(exOnderdeel);
        }
    }
    public ArrayList<Product> getAlleOnderdelen(){
//    	if (alleOnderdelen.isEmpty()) {
//    		System.out.println("Hoi");
    		alleOnderdelen = new ProductDAO().getAlleOnderdelenDB();
    	//}
    	
    	System.out.println("Test: " + alleOnderdelen);
        return alleOnderdelen;

    }
    //Onderdelen combobox bij PrijsBerekenenFrame
    public boolean heeftOnderdeel2(int artNr){
        boolean b = false;
        for (Product p: alleOnderdelen2){
            if (p.getProductNummer() == (artNr)){
                    b = true;
            }
        }
        return b;
    }
    public boolean voegOnderdeelToe2(Product nwOnderdeel){
        boolean b = false;
        if(!heeftOnderdeel2(nwOnderdeel.getProductNummer())){
            alleOnderdelen2.add(nwOnderdeel);
            b = true;
        }
        return b;
    }
    public void verwijderOnderdeel2(Product exOnderdeel) {
        if (heeftOnderdeel(exOnderdeel.getProductNummer())) {
            alleOnderdelen2.remove(exOnderdeel);
        }
    }
    public ArrayList<Product> getAlleOnderdelen2(){
        return alleOnderdelen2;

    }
    public boolean heeftBrandstof(int artNr){
        boolean b = false;
        for (Product p: alleBrandstoffen){
            if (p.getProductNummer() == (artNr)){
                    b = true;
            }
        }
        return b;
    }
    public boolean voegBrandstofToe(Product nwBrandstof){
        boolean b = false;
        if(!heeftBrandstof(nwBrandstof.getProductNummer())){
            alleBrandstoffen.add(nwBrandstof);
            b = true;
        }
        return b;
    }
    public ArrayList<Product> getAlleBrandstoffen(){
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
    
    public Gebruiker zoekKlant(String nm){
    	Gebruiker antw = null;
        for(Gebruiker k: alleKlanten){
            if(k.getNaam().equals(nm)){
                antw = k;
                break;
            }
        }
        return antw;
    }
    public boolean voegKlantToe(Gebruiker nweKlant){
        boolean b = false;
        if(!heeftKlant(nweKlant.getNaam())){
            alleKlanten.add(nweKlant);
            b = true;
        }
        return b;
    }
    public void verwijderKlant(Gebruiker exKlant, ArrayList a) {
        if (heeftKlant(exKlant.getNaam())) {
            a.remove(exKlant);
        }
    }
    
    public ArrayList<Gebruiker> getAlleKlanten(){
        return alleKlanten;
    }
    
    //Hier worden alle Klanten met een auto jonger dan 2010 toegevoegd aan de ArrayList
    public ArrayList<Gebruiker> getAlleKlantenJongerDan2010(){
    	if(alleKlanten.isEmpty() && alleAutos.isEmpty()) {
	    	alleKlanten = new GebruikersDAO().getAlleGebruikersDB();
	    	alleAutos = new AutosDAO().getAlleAutosDB();
	    	int x = 0;
	    	for(Auto a: alleAutos){
	    		if(a.getBouwjaar() < 2010){
	    			x = a.getEigenaarID();
	    			for(Gebruiker g: alleKlanten){
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
    	if(alleKlanten1.isEmpty() && alleAutos1.isEmpty()) {
	    	alleKlanten1 = new GebruikersDAO().getAlleGebruikersDB();
	    	alleAutos1 = new AutosDAO().getAlleAutosDB();
	    	int x = 0;
	    	for(Auto a: alleAutos1){
	    		if(a.getBouwjaar() > 2010){
	    			x = a.getEigenaarID();
	    			for(Gebruiker g: alleKlanten1){
	    				if(g.getGebruikerID() == x){
	    					ouderdan.add(g);
	    				}
	    			}
	    		}
	    	}
    	}
	    	return ouderdan;
    }
    
    public ArrayList<Gebruiker> getAlleKlantenLaatstgeweest(){
    	SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    	Calendar test = Calendar.getInstance();
        test.add(Calendar.DATE, -60);
    	if(alleKlanten2.isEmpty()) {
	    	alleKlanten2 = new GebruikersDAO().getAlleGebruikersDB();
	    	for(Gebruiker g: alleKlanten2){
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
    
    public ArrayList<Gebruiker> getAlleKlanten1(){
        return alleKlanten1;
    }
    
    public ArrayList<Gebruiker> getAlleKlanten2(){
    	return alleKlanten2;
    }
    
    public ArrayList<Auto> getAlleAutos1(){
        return alleAutos1;
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
//            if (k.getLaatstgeweest().before(test)) {
                if(!afwezig.contains(k)){
                    afwezig.add(k);
                }
//            }
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
    	if(alleKlanten.isEmpty() && alleAutos.isEmpty()) {
    		alleKlanten = new GebruikersDAO().getAlleGebruikersDB();
    		alleAutos = new AutosDAO().getAlleAutosDB();
    		factuur.removeAll(factuur);
    		Calendar test = Calendar.getInstance();
    		test.add(Calendar.DATE, -90);
    		Date date1 = test.getTime();
    		for (Gebruiker k : alleKlanten){
    			if(k.getOpenFactuur() != null){
    				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    				Date date2 = null;
    				try {
    					date2 = sdf.parse(k.getOpenFactuur());
    					if(date2.before(date1)==true){
    						if(!factuur.contains(k)){
    							factuur.add(k);
    						}
    					}
    				} catch (ParseException e) {
    					e.printStackTrace();
    				}
    			}
    		}
    	}
		return factuur;
    }
    //Klanten combobox bij FactuurbetalingBlokkerenFrame
    public ArrayList<Gebruiker> getAlleKlantenBlok(){
        blokkade.removeAll(blokkade);
        Calendar test = Calendar.getInstance();
        test.add(Calendar.DATE, -90);
        //klanten die langer dan 90 dagen niet hebben betaald
        for (Gebruiker k : alleKlanten){
            if(k.getBlokkade() == false){
                if(k.getOpenFactuur() != null){
//                    if(k.getOpenFactuur().before(test)){
                        if(!blokkade.contains(k)){
                            blokkade.add(k);
//                        }
                    }
                }
            }
        }
        return blokkade;
    }
    public void blokkeer(Gebruiker k){
        k.setBlokkade();
    }
    public boolean voegVrijeParkeerplaatsToe(Parkeerplaats nP){
        boolean b = false;
        if(nP.getBezet() == false){
            alleVrijeParkeerplaatsen.add(nP);
            b = true;
        }
        return b;
    }
    public ArrayList<Parkeerplaats> getAlleVrijeParkeerplaatsen(){
        return alleVrijeParkeerplaatsen;
    }
    public boolean heeftParkeerplaats(int pNr){
        boolean b = false;
        for (Parkeerplaats p: alleVrijeParkeerplaatsen){
            if (p.getNummer() == pNr){
                b = true;
            }
        }
        return b;
    }
    public boolean voegParkeerplaatsToe(Parkeerplaats p){
        return alleParkeerplaatsen.add(p);
    }
    public void verwijderParkeerplaats(Parkeerplaats exPar) {
        if (heeftParkeerplaats(exPar.getNummer())) {
            alleVrijeParkeerplaatsen.remove(exPar);
        }
    }
    public ArrayList<Parkeerplaats> getAlleParkeerplaatsen(){
        return alleParkeerplaatsen;
    }
    public boolean heeftBezetteParkeerplaats(int pNr){
        boolean b = false;
        for (Parkeerplaats p: alleBezetteParkeerplaatsen){
            if (p.getNummer() == pNr){
                b = true;
            }
        }
        return b;
    }
    public boolean voegBezetteParkeerplaatsToe(Parkeerplaats nP){
        boolean b = false;
        if(nP.getBezet() == true){
            alleBezetteParkeerplaatsen.add(nP);
            b = true;
        }
        return b;
    }
    public void verwijderBezetteParkeerplaats(Parkeerplaats exPar) {
        if (heeftBezetteParkeerplaats(exPar.getNummer())) {
            alleBezetteParkeerplaatsen.remove(exPar);
        }
    }
    public ArrayList<Parkeerplaats> getAlleBezetteParkeerplaatsen(){
        return alleBezetteParkeerplaatsen;
    }
    public boolean heeftAuto(String kt){
        boolean b = false;
        for (Auto a: alleAutos){
            if (a.getKenteken().equals(kt)){
                b = true;
            }
        }
        return b;
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
    public boolean voegAutoToe(Auto nweAuto){
        boolean b = false;
        if(!heeftAuto(nweAuto.getKenteken())){
            alleAutos.add(nweAuto);
            b = true;
        }
        return b;
    }
    public void verwijderAuto(Auto exAuto) {
        if (heeftAuto(exAuto.getKenteken())) {
            alleAutos.remove(exAuto);
        }
    }
    public ArrayList<Auto> getAlleAutos(){
        return alleAutos;
    }
    public boolean heeftKlus(int kNr){
        boolean b = false;
        for (Klus k: alleKlussen){
            if (k.getKlusNummer() == kNr){
                b = true;
            }
        }
        return b;
    }
    public boolean voegKlusToe(Klus nK) throws SQLException{
    	System.out.println("Ik vraag deze klus op: " + nK.getKlusNaam());
        boolean b = false;
            if(!heeftKlus(nK.getKlusNummer())){
                alleKlussen.add(nK);
                new KlussenDAO().saveKlus(nK);
                b = true;
            }
        return b;
    }
    public void verwijderKlus(Klus exKlus) {
       if (heeftKlus(exKlus.getKlusNummer())) {
           alleKlussen.remove(exKlus);
       }
    }
    
	public ArrayList<Klus> getAlleKlussen() {
		if (alleKlussen.isEmpty()) {
			alleKlussen = new KlussenDAO().getAlleKlussenDB();
		}
		return alleKlussen;
	}
    //ArrayList met Onderdelen voor PrijsBerekenenFrame
    public boolean heeftKlusCombo(int kNr){
        boolean b = false;
        for (Klus k: alleKlussenCombo){
            if (k.getKlusNummer() == kNr){
                b = true;
            }
        }
        return b;
    }
    public boolean voegKlusToeCombo(Klus nK){
        boolean b = false;
        if(!heeftKlusCombo(nK.getKlusNummer())){
            alleKlussenCombo.add(nK);
            b = true;
        }
        return b;
    }
    public void verwijderKlusCombo(Klus exKlus) {
       if (heeftKlusCombo(exKlus.getKlusNummer())) {
           alleKlussenCombo.remove(exKlus);
       }
    }
    public ArrayList<Klus> getAlleKlussenCombo(){
        return alleKlussenCombo;
	}

	// ArrayList met Klussen die de datum van vandaag hebben
	public boolean heeftKlusVandaag(int kNr) {
		boolean b = false;
		for (Klus k : klussenStatus) {
			if (k.getKlusNummer() == kNr) {
				b = true;
			}
		}
		return b;
	}

	public boolean voegKlusVandaagToe(Klus nK) {
		boolean b = false;
		if (!heeftKlusVandaag(nK.getKlusNummer())) {
			if ((getToday().equals(nK.getAlleData().get(0)))) {
				klussenStatus.add(nK);
				b = true;
			}
		}
		return b;
	}

	public void verwijderKlusVandaag(Klus exKlus) {
       if (heeftKlusVandaag(exKlus.getKlusNummer())) {
           klussenStatus.remove(exKlus);
       }
    }
    public ArrayList<Klus> getAlleKlussenVandaag(){
        return klussenStatus;
    }
    public boolean heeftReservering(int pNr){
        boolean b = false;
        for (Parkeerplaats p: alleReserveringen){
            if (p.getNummer() == pNr){
                b = true;
            }
        }
        return b;
    }
    public boolean voegReserveringToe(Parkeerplaats nR){
        boolean b = false;
                alleReserveringen.add(nR);
                b = true;
        return b;
    }
    public void verwijderReservering(Parkeerplaats nR) {
        if (heeftReservering(nR.getNummer())) {
            alleReserveringen.remove(nR);
        }
    }

    public ArrayList<Parkeerplaats> getAlleReseveringen(){
        return alleReserveringen;
    }

    public boolean voegMonteurToe(Monteur m){
        return alleMonteurs.add(m);
    }
    public ArrayList<Monteur> getAlleMonteurs(){
        return alleMonteurs;
    }
    public boolean heeftPas(int pn){
        boolean b = false;
        for (Pas ps: allePassen){
            if (ps.getPasnummer() == pn){
                b = true;
            }
        }
        return b;
    }
    public boolean voegPasToe(Pas nwePas){
        boolean b = false;
        if(!heeftPas(nwePas.getPasnummer())){
            allePassen.add(nwePas);
            b = true;
        }
        return b;
    }
    //Alle gegevens van de pas van de klant
    public String toString(){
        String s = "";
        s = s + "De volgende passen zijn er: \n";
        for (Pas ps : allePassen){
           s = s + "\n" + ps.toString();
        }
        return s;
    }
}
