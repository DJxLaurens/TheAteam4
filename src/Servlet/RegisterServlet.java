package Servlet;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import Webapp.Dbconnection;
import Webapp.User;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.sql.ResultSet;
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
		String tempRol = req.getParameter("rol");
		int rol = 0;
		String s = "";

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
//			ResultSet rs = Dbconnection.resultset();
//			if (rs != null) {
//				try {
//					while (rs.next()) {
//						String dbNaam = rs.getString("name");
//						String dbPass = rs.getString("password");
//						if (!dbNaam.equals(name)&& !dbPass.equals(name)) {
//							loginSuccess = true;
//						} else {
//							loginSuccess = false;
//							s += "Er bestaat al een user met deze gegevens\n";
//						}
//					}
//				} catch (SQLException e1) {
//					e1.printStackTrace();
//				}
//			} else {
//				loginSuccess = false;
//				s += "rs is leegs";
//			}
		} else {
			s += "Something is missing!\n";
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