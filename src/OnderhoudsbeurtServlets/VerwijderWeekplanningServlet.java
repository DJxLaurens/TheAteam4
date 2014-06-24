package OnderhoudsbeurtServlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.KlussenDAO;
import DAO.ProductDAO;

public class VerwijderWeekplanningServlet extends HttpServlet {
	private KlussenDAO klus = new KlussenDAO();
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
			RequestDispatcher rd = null;
		
			klus.verwijderWeekplanning(Integer.parseInt(req.getParameter("wId")));
			
			rd = req.getRequestDispatcher("weekplanning.jsp");
			rd.forward(req, resp);
	}
}
