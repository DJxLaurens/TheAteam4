package Servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Connection.ProductDAO;

public class MinimaleVoorraadWijzigenServlet extends HttpServlet {
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
			
			System.out.println("Onderdeel id: " + req.getParameter("onderdeelId"));
			System.out.println("Nieuwe minimale voorraad"  + req.getParameter("minVoorraad"));
		
			try {
				producten.changeMinVoorraad(Integer.parseInt(req.getParameter("onderdeelId")), Integer.parseInt(req.getParameter("minVoorraad")));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(Integer.parseInt(req.getParameter("type")) == 2){
				rd = req.getRequestDispatcher("onderdelen_bestellen.jsp");
			}else{
				rd = req.getRequestDispatcher("brandstof_bestellen.jsp");
			}
			
			
			rd.forward(req, resp);
	}
}
