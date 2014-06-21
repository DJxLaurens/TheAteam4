package OnderhoudsbeurtServlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AutosDAO;
import DAO.KlussenDAO;
import Onderdelen.Klus;

public class KlusToevoegenServlet extends HttpServlet {
	private KlussenDAO klus = new KlussenDAO();
	private String klusNaam;
	private String klusOmschrijving;
	private int autoId;
	private int werknemerId;
	private int klusNummer;
	private String s;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
			klusNaam = req.getParameter("klusNaam");
			klusOmschrijving = req.getParameter("klusOmschrijving");
			String string = (String)req.getParameter("autos");
			autoId = Integer.parseInt(string);
			werknemerId = 0;
			
			req.setAttribute("msgs", s);
			RequestDispatcher rd = null;
			Klus k = new Klus(klusNaam, klusOmschrijving, autoId, werknemerId);			
			try {
				klus.saveKlus(k);
				s = "Toevoegen is gelukt";
			} catch (SQLException e) {
				e.printStackTrace();
				s = "Toevoegen is mislukt";
			}
			
			rd = req.getRequestDispatcher("klus_toevoegen.jsp");
			rd.forward(req, resp);
	}
}
