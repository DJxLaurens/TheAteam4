package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.ProductDAO;
import Webapp.Product;

public class VoorraadToevoegenServlet extends HttpServlet {
	private ProductDAO producten = new ProductDAO();
	private String voorraadNaam;
	private int voorraadType;
	private int voorraadMin;
	private int voorraad;
	//private int voorraadId;
	private String s;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		voorraadNaam = req.getParameter("voorraadNaam");
		voorraadMin = Integer.parseInt(req.getParameter("voorraadMin"));
		voorraad = Integer.parseInt(req.getParameter("voorraad"));
		//voorraadPrijs = Double.parseDouble(req.getParameter("voorraadPrijs"));

		if(req.getParameter("type").equals("Brandstof")){
			voorraadType = 1;
		}else{
			voorraadType = 2;
		}

		req.setAttribute("msgs", s);
		//RequestDispatcher rd = null;
		//Product p = new Product(null, voorraadNaam, voorraadType, voorraadMin, voorraad);
		try {
			System.out.println(voorraadNaam + " " + voorraadType + " " + voorraadMin + " " + voorraad);
			producten.saveVoorraad(voorraadNaam, voorraadType, voorraadMin, voorraad);
			s += "Toevoegen is gelukt";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//s += "Toevoegen is gelukt";
		rd = req.getRequestDispatcher("voorraad_toevoegen.jsp");
		rd.forward(req, resp);

	}
}
