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

public class BestellingOphalenServlet extends HttpServlet {
	private ProductDAO producten = new ProductDAO();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			RequestDispatcher rd = null;
			try {
				producten.haalBestellingOp(Integer.parseInt(req.getParameter("pId")), Integer.parseInt(req.getParameter("inBestelling")), Integer.parseInt(req.getParameter("voorraad")));
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
