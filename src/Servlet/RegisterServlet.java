package Servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import Webapp.Dbconnection;
import Webapp.User;

import java.sql.SQLException;

public class RegisterServlet extends HttpServlet {
	private Dbconnection db = new Dbconnection();
	private String pass = "", name = "", s = "";;
	private boolean loginSuccess = false;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {		
		name = req.getParameter("username");
		String address = req.getParameter("address");
		pass = req.getParameter("password");
		String pass2 = req.getParameter("password2");
		String email = req.getParameter("email");
		String email2 = req.getParameter("email2");
		String tempRol = req.getParameter("rol");
		int rol = 0;		

		if (!"".equals(name) && !"".equals(address) && !"".equals(pass)
				&& !"".equals(email)) {			
			rol = Integer.parseInt(tempRol);
			boolean loginSuccessMail = email.equals(email2);
			boolean loginSuccessPass = pass.equals(pass2);
			if (loginSuccessMail && loginSuccessPass) {
				loginSuccess = true;
			}
			if (!loginSuccessMail) {
				s += "E-mail doesn't match\n";

			}
			if (!loginSuccessPass) {
				s += "Password doesn't match\n";
			}
			
		} else {
			s += "Something is missing!\n";
		}

		req.setAttribute("msgs", s);
		RequestDispatcher rd = null;
		if (loginSuccess) {
			User u = new User(name, address, pass, email, rol);
			try {
				db.saveUser(u);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			s += "Toevoegen is gelukt";
			rd = req.getRequestDispatcher("login.jsp");
		} else
			rd = req.getRequestDispatcher("register.jsp");
		rd.forward(req, resp);
	}
}