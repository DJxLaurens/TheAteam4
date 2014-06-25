package InloggenServlets;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import DomeinModel.AutoTotaalDienst;
import Onderdelen.Gebruiker;

public class LoginServlet extends HttpServlet {	
	public int rol_id = 0;
	public String dbNaam, laatstGeweest, openFactuur, dbEmail, dbWachtwoord;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		AutoTotaalDienst atd = (AutoTotaalDienst) getServletContext().getAttribute("atdRef");
		boolean loginSuccess = false;
		String loginEmail = req.getParameter("naam");
		String loginWachtwoord = req.getParameter("wachtwoord");
		//checkt of velden zijn ingevuld
		if ("".equals(loginEmail) || "".equals(loginWachtwoord)) {
			req.setAttribute("msgs", "Vul AUB uw e-mailadres en wachtwoord in");
			req.setAttribute("email", loginEmail );
			
		} else {
			for (Gebruiker g : atd.getAlleKlanten()) {
				dbNaam = g.getNaam();
				dbEmail = g.getEmailadres();
				dbWachtwoord = g.getWachtwoord();
				laatstGeweest = g.getLaatstgeweest();
				openFactuur = g.getOpenFactuur();
				rol_id = g.getRol();
				// check of email/wachtwoord bij bevestig email/wachtwoord hetzelfde zijn
				if (dbEmail.equals(loginEmail) && dbWachtwoord.equals(loginWachtwoord)) {
					loginSuccess = true;
					break;
				}
				else{
					req.setAttribute("msgs", "Email en/of wachtwoord is onjuist!");
					req.setAttribute("email", loginEmail );
				}
			}		
		}

		RequestDispatcher rd = null;
		if (loginSuccess) {
			rd = req.getRequestDispatcher("index.jsp");	
			req.getSession().setAttribute("rol", rol_id);
			req.getSession().setAttribute("naam", dbNaam);
			req.getSession().setAttribute("email", dbEmail);
			if(laatstGeweest != null){
			req.getSession().setAttribute("laatstgeweest", laatstGeweest);
			}
			else{
				req.getSession().setAttribute("laatstgeweest", "Nog niet langsgeweest");
			}
			if(openFactuur != null){
				req.getSession().setAttribute("openFactuur", openFactuur);
			}
			else{
				req.getSession().setAttribute("openFactuur", "Geen open factuur");
			}
		} else {
			rd = req.getRequestDispatcher("loginIndex.jsp");		
			
		}
		rd.forward(req, resp);
	}
}
