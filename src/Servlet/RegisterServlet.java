package Servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import Webapp.Dbconnectie;
import Webapp.Medewerker;

import java.sql.SQLException;

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

		if (!"".equals(naam) && !"".equals(wachtwoord)) {			
			rol_id = Integer.parseInt(tempRol);
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
			Medewerker m = new Medewerker(naam, rol_id, wachtwoord);
			try {
				db.saveMedewerker(m);
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