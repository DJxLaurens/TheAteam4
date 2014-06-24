package InloggenServlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import DAO.GebruikersDAO;
import DomeinModel.AutoTotaalDienst;
import Onderdelen.Gebruiker;

import java.sql.SQLException;
import java.util.Date;

public class RegistreerServlet extends HttpServlet {
	private GebruikersDAO gebruiker = new GebruikersDAO();
	private String s = "";
	private boolean loginSucces, loginSuccesWachtwoord, loginSuccesEmail = false;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		AutoTotaalDienst atd = (AutoTotaalDienst) getServletContext().getAttribute("atdRef");
		String naam = req.getParameter("naam");
		String wachtwoord = req.getParameter("wachtwoord");
		String wachtwoord2 = req.getParameter("wachtwoord2");
		String tempRol = req.getParameter("rol_id");
		int rol_id = 0;
		String adres = req.getParameter("adres");
		String postcode = req.getParameter("postcode");
		String woonplaats = req.getParameter("woonplaats");
		String telefoonnummer = req.getParameter("telefoonnummer");
		String emailadres = req.getParameter("emailadres");
		String emailadres2 = req.getParameter("emailadres2");
		String tempLaatstgeweest = req.getParameter("laatstgeweest"); 
		String laatstgeweest = "00-00-0000"; // DateFormat moet voor vergelijken verschil datums auto	
		String tempKorting = req.getParameter("korting");
		double korting = 0;	
		String tempOpenFactuur = req.getParameter("openFactuur");
		String openFactuur = "00-00-0000" ; // DateFormat moet voor vergelijken verschil datums auto
		String tempBlokkade = req.getParameter("blokkade");
		boolean blokkade = false;
		
		if (!"".equals(naam) && !"".equals(wachtwoord) && !"".equals(adres) && !"".equals(postcode) 
				&& !"".equals(woonplaats) && !"".equals(telefoonnummer) && !"".equals(emailadres)) {			
			rol_id = Integer.parseInt(tempRol);
			korting = Double.parseDouble(tempRol);
			

			loginSuccesWachtwoord = wachtwoord.equals(wachtwoord2);
			loginSuccesEmail = emailadres.equals(emailadres2);
			
			if (loginSuccesWachtwoord && loginSuccesEmail) {
				loginSucces = true;
			}

			if (!loginSuccesWachtwoord) {
				s = "Wachtwoord is niet hetzelfde!\n";
			}
			
			if (!loginSuccesEmail) {
				s = "Emailadres is niet hetzelfde!\n";
			}
			
			for (Gebruiker g : atd.getAlleKlanten()) {
				if(g.getEmailadres().equals(emailadres)){
					s = "Emailadres is al in gebruik";
					loginSucces = false;
					break;
				}
			}
			
		} else {
			s = "Niet alle velden zijn ingevuld!\n";
		}

		req.setAttribute("msgs", s);
		RequestDispatcher rd = null;
		if (loginSucces) {
			Gebruiker g = new Gebruiker(rol_id, naam, wachtwoord, adres, postcode, woonplaats, telefoonnummer, emailadres, laatstgeweest, korting, openFactuur, blokkade);
			try {
				
				gebruiker.saveGebruiker(g);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			s = "Toevoegen is gelukt";
			rd = req.getRequestDispatcher("registreer.jsp");
		} else
			rd = req.getRequestDispatcher("registreer.jsp");
			rd.forward(req, resp);
		}	
}
