package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Webapp.Dbconnectie;
import Webapp.Gebruiker;
import Webapp.Klus;

public class KlusToevoegenServlet extends HttpServlet {
	private Dbconnectie db = new Dbconnectie();
	private String klusNaam;
	private String klusOmschrijving;
	private int autoId;
	private int werknemerId;
	private String s;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
			klusNaam = req.getParameter("klusNaam");
			klusOmschrijving = req.getParameter("klusOmschrijving");
			autoId = 0;
			werknemerId = 0;
			
			req.setAttribute("msgs", s);
			RequestDispatcher rd = null;
			Klus k = new Klus(klusNaam, klusOmschrijving, autoId, werknemerId);
			try {
				db.saveKlus(k);
				s += "Toevoegen is gelukt";
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//s += "Toevoegen is gelukt";
			rd = req.getRequestDispatcher("klus_toevoegen.jsp");
			rd.forward(req, resp);
	}
}
