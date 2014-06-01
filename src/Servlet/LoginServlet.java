package Servlet;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class LoginServlet extends HttpServlet {
	String userName = "1", userPass = "1", id = "";
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		boolean loginSuccess = false;
		String name = req.getParameter("username");
		String pass = req.getParameter("password");
		
		if ("".equals(name) || "".equals(pass)) {
			req.setAttribute("msgs", "Vul A.U.B. uw naam en/of wachtwoord in!");
		} else {
			if (!userName.equals(name) && userPass.equals(pass)) {
				req.setAttribute("msgs", "Naam en/of wachtwoord is onjuist!");
			} else {
				loginSuccess = true;
				req.getSession().setAttribute("name", name);
				req.getSession().setAttribute("pass", pass);
				
			}
		}

		RequestDispatcher rd = null;
		if (loginSuccess) {		
			rd = req.getRequestDispatcher("index.jsp");

		} else {
			rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		}
	}
}
