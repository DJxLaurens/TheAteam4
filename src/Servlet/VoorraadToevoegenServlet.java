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
	private int voorraadId;
	private String s;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		if(req.getParameter("voorraadType").equals("Brandstof")){
			voorraadType = 1;
		}else{
			voorraadType = 2;
		}
		
			Enumeration<String> enumeratie = req.getParameterNames();
			RequestDispatcher rd = null;
			while(enumeratie.hasMoreElements()) {
				voorraadNaam = req.getParameter("voorraadNaam");
				voorraadMin = Integer.parseInt(req.getParameter("voorraadMin"));
				voorraad = Integer.parseInt(req.getParameter("voorraad"));
				
				System.out.println("Per while krijg ik: " + voorraadNaam + " " + voorraadMin + " " + voorraad);
				
				String name = enumeratie.nextElement();
				int aantal = 0;
				
				if (name.startsWith("prod_" )) {
					//System.out.println("Ik kom Boven: " + name);
					
					int id = Integer.parseInt(name.substring(name.indexOf('_')+1));
					//System.out.println("Ik kom Voor: " + id);
					
					//System.out.println("Paramater: " + req.getParameter(name));
					
					if (!req.getParameter(name).isEmpty()){
						aantal = Integer.parseInt(req.getParameter(name));
						//System.out.println("Ik zit er toch in!");
					}
					
					req.setAttribute("msgs", s);
					Product p = new Product(id, voorraadNaam, voorraadType, voorraadMin, voorraad+aantal);
					
					try {
						producten.changeVoorraad(p);
						s += "Toevoegen is gelukt";
						//System.out.println("Ik voeg wat toe: " + p.getProductNaam());
					} catch (SQLException e) {
						e.printStackTrace();
					}
					rd = req.getRequestDispatcher("onderdelen_bestellen.jsp");
					
					//System.out.println("Ik ben bij Hoi");
				}
				
			}
			rd.forward(req, resp);
	}
}
