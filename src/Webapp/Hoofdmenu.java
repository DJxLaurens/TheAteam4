package Webapp;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hoofdmenu extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String pressed = req.getParameter("press");
		RequestDispatcher rd = null;
		if (pressed.equals("Klantenbinding")){
			rd = req.getRequestDispatcher("klantenbinding.jsp");
			rd.forward(req, resp);
			
		}
		if(pressed.equals("Werkplaats")){
			rd = req.getRequestDispatcher("menu_werkplaats.jsp");
		}
		
	}
}