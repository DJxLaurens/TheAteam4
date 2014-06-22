package BetalingFacturatieServlets;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

public class RapportagesMakenServlet extends HttpServlet{
	
	public boolean isDouble(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		RequestDispatcher rd = null;
		
		String v1 = (String)req.getParameter("hoogsteBTWPerProduct");
		String v2 = (String)req.getParameter("gemiddeldeBTWPerProduct");
		String v3 = (String)req.getParameter("hoogsteBTWPerTransactie");
		String v4 = (String)req.getParameter("gemiddeldeBTWPerTransactie");
		String v5 = (String)req.getParameter("omzet");
		String v6 = (String)req.getParameter("winst");
		
		double hoogsteProduct = 0;
		double gemiddeldProduct = 0;
		double hoogsteTransactie = 0;
		double gemiddeldTransactie = 0;
		double omzet = 0;
		double winst = 0;
		double foutmelding = 1;
		
		if(isDouble(v1)){
			hoogsteProduct = Double.parseDouble(v1);
		} else{
			foutmelding = 2;
		}

		if(isDouble(v2)){
			gemiddeldProduct = Double.parseDouble(v2);
		} else{
			foutmelding = 2;
		}

		if(isDouble(v3)){
			hoogsteTransactie = Double.parseDouble(v3);
		} else{
			foutmelding = 2;
		}

		if(isDouble(v4)){
			gemiddeldTransactie = Double.parseDouble(v4);
		} else{
			foutmelding = 2;
		}

		if(isDouble(v5)){
			omzet = Double.parseDouble(v5);
		} else{
			foutmelding = 2;
		}
		
		if(isDouble(v6)){
			winst = Double.parseDouble(v6);
		} else{
			foutmelding = 2;
		}
		
		if(hoogsteProduct < 0){
			foutmelding = 2;
		}
		if(gemiddeldProduct < 0){
			foutmelding = 2;
		}
		if(hoogsteTransactie < 0){
			foutmelding = 2;
		}
		if(gemiddeldTransactie < 0){
			foutmelding = 2;
		}
		if(omzet < 0){
			foutmelding = 2;
		}
		if(winst < 0){
			foutmelding = 2;
		}
		
		if(foutmelding == 2){
			PrintWriter out = resp.getWriter();
		    out.println("<script type=\"text/javascript\">");
		    out.println("alert('Aanmaken mislukt, vul alle invulvelden in met getallen boven 0!');");  
		    out.println("window.location = 'rapportagesaanmaken.jsp'");
		    out.println("</script>");
		    out.close();
		}
		else{
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HHmm");
			Date datum = new Date();
			FileWriter fw1 = new FileWriter("["+sdf.format(datum)+"] - BTWperProduct.txt");
			PrintWriter pw1 = new PrintWriter(fw1);
			FileWriter fw2 = new FileWriter("["+sdf.format(datum)+"] - BTWperTransactie.txt");
			PrintWriter pw2 = new PrintWriter(fw2);
			FileWriter fw3 = new FileWriter("["+sdf.format(datum)+"] - Financiele status.txt");
			PrintWriter pw3 = new PrintWriter(fw3);
			
			pw1.println("Rapport BTW per artikel:");
	        pw1.println("");
	        pw1.println("Geachte heer/mevrouw,");
	        pw1.println("");
	        pw1.println("Bij deze ontvangt u het rapport van de BTW per artikel van het bedrijf ATD.");
	        pw1.println("De hoogste hoeveelheid BTW per artikel was " + hoogsteProduct + " euro.");
	        pw1.println("De gemiddelde hoeveelheid BTW per artikel was " + gemiddeldProduct + " euro.");
	        pw1.println("");
	        pw1.println("Met vriendelijke groet,");
	        pw1.println("");
	        pw1.println("Henk Paladijn");
	        
	        pw2.println("Rapport BTW per transactie");
	        pw2.println("");
	        pw2.println("Geachte heer/mevrouw,");
	        pw2.println("");
	        pw2.println("Bij deze ontvangt u het rapport van de BTW per transactie van het bedrijf ATD.");
	        pw2.println("De hoogste hoeveelheid BTW per transactie was " + hoogsteTransactie + " euro.");
	        pw2.println("De gemiddelde hoeveelheid BTW per transactie was " + gemiddeldTransactie + " euro.");
	        pw2.println("");
	        pw2.println("Met vriendelijke groet,");
	        pw2.println("");
	        pw2.println("Henk Paladijn");
	        
	        pw3.println("Rapport Financiële status:");
	        pw3.println("");
	        pw3.println("Geachte heer/mevrouw,");
	        pw3.println("");
	        pw3.println("Bij deze ontvangt u het rapport van de financiele status van het bedrijf ATD.");
	        pw3.println("De omzet van deze maand was " + omzet + " euro.");
	        pw3.println("De winst deze maand was " + winst + " euro.");
	        pw3.println("");
	        pw3.println("Met vriendelijke groet,");
	        pw3.println("");
	        pw3.println("Henk Paladijn");
	        
	        pw1.close();
	        pw2.close();
	        pw3.close();
	        
			PrintWriter out = resp.getWriter();
		    out.println("<script type=\"text/javascript\">");
		    out.println("alert('Aanmaken gelukt, rapportages (BTW per artikel, BTW per transactie en Financiële status) zijn aangemaakt!');");  
		    out.println("window.location = 'rapportagesaanmaken.jsp'");
		    out.println("</script>");
		    out.close();
		}
		
	}
}
