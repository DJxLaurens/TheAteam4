package Servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import Webapp.Dbconnectie;
import Webapp.Medewerker;
import Webapp.Klant;

import java.sql.SQLException;
import java.util.Date;

public class RegisterServlet extends HttpServlet {
	private Dbconnectie db = new Dbconnectie();
	private String wachtwoord = "", naam = "", s = "";;
	private boolean loginSuccess = false;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		
		naam = req.getParameter("naam");
		wachtwoord = req.getParameter("wachtwoord");
		String wachtwoord2 = req.getParameter("wachtwoord2");
		String tempRol = req.getParameter("rol_id");
		int rol_id = 0;
		String adres = req.getParameter("adres");
		String postcode = req.getParameter("postcode");
		String woonplaats = req.getParameter("woonplaats");
		String telefoonnummer = req.getParameter("telefoonnummer");
		String emailadres = req.getParameter("emailadres");
		String emailadres2 = req.getParameter("emailadres2");
		String laatstgeweest = null;
		System.out.println(req.getParameter("laatstgeweest"));
//		try{
//		if(req.getParameter("laatstgeweest").equals(null)){
//			laatstgeweest = "00-00-00";
//		}else{
//			laatstgeweest = req.getParameter("laatstgeweest");
//		}
//		}catch (NullPointerException np){
//			np.printStackTrace();
//		}
		
		laatstgeweest = "00-00-00";
		
		String tempKorting = req.getParameter("korting");
		double korting = 0;	
		String openFactuur = null;
		System.out.println(req.getParameter("openFactuur"));
//		try{
//		if(req.getParameter("openFactuur").equals(null)){
//			openFactuur = "00-00-00";
//		}else{
//			openFactuur = req.getParameter("openFactuur");
//		}
//		}catch(NullPointerException np){
//			np.printStackTrace();
//		}
		
		openFactuur = "00-00-00";
		
		String tempBlokkade = req.getParameter("blokkade");
		boolean blokkade = false;

		if (!"".equals(naam) && !"".equals(wachtwoord)) {			
			rol_id = Integer.parseInt(tempRol);
			korting = Double.parseDouble(tempRol);

			boolean loginSuccessPass = wachtwoord.equals(wachtwoord2);
			if (loginSuccessPass) {
				loginSuccess = true;
			}

			if (!loginSuccessPass) {
				s += "Wachtwoord is niet hetzelfde!\n";
			}
			
		} else {
			s += "Niet alle velden zijn ingevuld!\n";
		}

		req.setAttribute("msgs", s);
		RequestDispatcher rd = null;
		if (loginSuccess) {
//			Medewerker m = new Medewerker(naam, rol_id, wachtwoord);
			Klant k = new Klant(naam, wachtwoord, adres, postcode, woonplaats, telefoonnummer, emailadres, laatstgeweest, korting, openFactuur, blokkade);
			try {
//				db.saveMedewerker(m);
				db.saveKlant(k);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			s += "Toevoegen is gelukt";
			rd = req.getRequestDispatcher("login.jsp");
		} else
			rd = req.getRequestDispatcher("register.jsp");
		rd.forward(req, resp);
	}
}