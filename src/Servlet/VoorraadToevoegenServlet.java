package Servlet;

import java.io.*;
import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.*;

import Webapp.Dbconnectie;
import Webapp.Product;

public class VoorraadToevoegenServlet extends HttpServlet {
	private Dbconnectie db = new Dbconnectie();
	private String voorraadNaam;
	private int voorraadType;
	private int voorraadMin;
	private int voorraad;
	private double voorraadPrijs;
	private String s;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {	
			voorraadNaam = req.getParameter("voorraadNaam");
			voorraadMin = Integer.parseInt(req.getParameter("voorraadMin"));
			voorraad = Integer.parseInt(req.getParameter("voorraad"));
			voorraadPrijs = Double.parseDouble(req.getParameter("voorraadPrijs"));
			
			if(req.getParameter("type").equals("Brandstof")){
				voorraadType = 1;
			}else{
				voorraadType = 2;
			}
			
			req.setAttribute("msgs", s);
			RequestDispatcher rd = null;
			Product p = new Product(voorraadMin, voorraad, voorraadNaam, voorraadPrijs, voorraadType);
			try {
				db.saveVoorraad(p);
				s += "Toevoegen is gelukt";
			} catch (SQLException e) {
				e.printStackTrace();
			}
			//s += "Toevoegen is gelukt";
			rd = req.getRequestDispatcher("klus_toevoegen.jsp");
			rd.forward(req, resp);
	}
}
