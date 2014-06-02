package Servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import Webapp.AutoTotaalDienst;
import Webapp.Gebruiker;

public class LoginServlet extends HttpServlet {	
	public int rol_id = 0;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		AutoTotaalDienst atd = (AutoTotaalDienst) getServletContext().getAttribute("atdRef");
		boolean loginSuccess = false;
		String naam = req.getParameter("naam");
		String wachtwoord = req.getParameter("wachtwoord");
		if ("".equals(naam) || "".equals(wachtwoord)) {
			req.setAttribute("msgs", "Vul AUB uw e-mailadres en wachtwoord in");
		} else {
			for (Gebruiker g : atd.getAlleKlanten()) {
				String dbNaam = g.getEmailadres();
				String dbWachtwoord = g.getWachtwoord();
				rol_id = g.getRol();
				if (dbNaam.equals(naam) && dbWachtwoord.equals(wachtwoord)) {
					loginSuccess = true;
					break;
				}
				else{
					req.setAttribute("msgs", g.getEmailadres() + " " + g.getWachtwoord());
				}
			}		
		}

		RequestDispatcher rd = null;
		if (loginSuccess) {
			rd = req.getRequestDispatcher("index.jsp");	
			req.getSession().setAttribute("rol", rol_id);
			req.getSession().setAttribute("naam", naam);
			

		} else {
			rd = req.getRequestDispatcher("loginIndex.jsp");		
			
		}
		rd.forward(req, resp);
	}
}
