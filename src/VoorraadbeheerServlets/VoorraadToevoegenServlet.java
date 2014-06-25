package VoorraadbeheerServlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDAO;
import Onderdelen.Product;

public class VoorraadToevoegenServlet extends HttpServlet {
	private ProductDAO producten = new ProductDAO();
	private String voorraadNaam;
	private int voorraadType;
	private int voorraadMin;
	private int voorraad;
	private String s;
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		voorraadNaam = req.getParameter("voorraadNaam");
		voorraadMin = Integer.parseInt(req.getParameter("voorraadMin"));
		voorraad = Integer.parseInt(req.getParameter("voorraad"));

		if(req.getParameter("type").equals("Brandstof")){
			voorraadType = 1;
		}else{
			voorraadType = 2;
		}

		req.setAttribute("msgs", s);
		try {
			producten.saveVoorraad(voorraadNaam, voorraadType, voorraadMin, voorraad);
			s += "Toevoegen is gelukt";
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(voorraadType == 2){
			rd = req.getRequestDispatcher("onderdelen_bestellen.jsp");
		}else{
			rd = req.getRequestDispatcher("brandstof_bestellen.jsp");
		}
		rd.forward(req, resp);

	}
}
