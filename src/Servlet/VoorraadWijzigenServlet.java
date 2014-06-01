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

public class VoorraadWijzigenServlet extends HttpServlet {
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
		Enumeration<String> enumeratie = req.getParameterNames();
		
		while(enumeratie.hasMoreElements()) {
							String name = enumeratie.nextElement();
							if (name.startsWith("prod_" )) {
								int id = Integer.parseInt(name.substring(name.indexOf('_')+1));
								int aantal = 0;
								if(!req.getParameter(name).equals("")){
									aantal = Integer.parseInt(req.getParameter(name));
								}
			 					//String huidigeVoorraad = req.getParameter("voorraad");
			 					System.out.println("Nieuwe uitkomst: " + id + " " + aantal + " " + producten.getVoorraadById(id));
			 					try {
									producten.changeVoorraad(id, aantal, producten.getVoorraadById(id));
								} catch (SQLException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
			 				}
		}
			rd = req.getRequestDispatcher("voorraad_toevoegen.jsp");
			rd.forward(req, resp);
	}
}
