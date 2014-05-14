package Servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import Webapp.Dbconnection;
import Webapp.User;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.sql.SQLException;

public class RegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		boolean loginSuccess = false;		
		String name = req.getParameter("username");
		String address = req.getParameter("address");
		String pass = req.getParameter("password");
		String pass2 = req.getParameter("password2");
		String email = req.getParameter("email");
		String email2 = req.getParameter("email2");
		String rol = req.getParameter("rol");
		String s = "";
		
		if (!"".equals(name) && !"".equals(address) && !"".equals(pass)
				&& !"".equals(email)) {
			boolean loginSuccessMail = email.equals(email2);
			boolean loginSuccessPass = pass.equals(pass2);
			if(loginSuccessMail && loginSuccessPass){
				loginSuccess = true;
			}
			if (!loginSuccessMail) {
				s += "E-mail doesn't match\n";

			}
			if (!loginSuccessPass) {
				s += "Password doesn't match\n\n";
			}
		} else {
			s += "Something is missing!\n\n";
		}

		req.setAttribute("msgs", s);
		RequestDispatcher rd = null;
		if (loginSuccess) {				
			User u = new User(name, address, pass, email, rol);
			
			try {
				Dbconnection.saveUser(u);
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			s += "Toevoegen is gelukt";
			rd = req.getRequestDispatcher("login.jsp");
		} else
			rd = req.getRequestDispatcher("register.jsp");
		rd.forward(req, resp);
	}
}