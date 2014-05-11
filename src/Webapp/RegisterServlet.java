package Webapp;

import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import Webapp.Dbconnection;

public class RegisterServlet extends HttpServlet {
	private String name, pass;
	private String registerdUsers = "";

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		boolean loginSuccess = false;		
		name = req.getParameter("username");
		String address = req.getParameter("address");
		pass = req.getParameter("password");
		String pass2 = req.getParameter("password2");
		String email = req.getParameter("email");
		String email2 = req.getParameter("email2");
		String s = "";

		ServletContext context = req.getSession().getServletContext();
		Object o = getServletContext().getAttribute("name");
		if (o != null) {
			registerdUsers = o.toString();
		}
		if (!"".equals(name) && !"".equals(address) && !"".equals(pass)
				&& !"".equals(email)) {
			boolean loginSuccessMail = email.equals(email2);
			boolean loginSuccessPass = pass.equals(pass2);
			if(loginSuccessMail && loginSuccessPass){
				loginSuccess = true;
			}
			
			if (registerdUsers.equals(name)) {
				s += "User already exsists";
				loginSuccess = false;
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
			context.setAttribute("name", name);
			context.setAttribute("pass", pass);
			rd = req.getRequestDispatcher("login.jsp");
		} else
			rd = req.getRequestDispatcher("signup.jsp");
		rd.forward(req, resp);
	}
	
//	public void sqlAction(String sql) throws Exception {
//		con = getConnection();
//
//        Statement stmt = con.createStatement();
//        stmt.executeUpdate(sql);
//    }
//	
//	public void create(String sql) throws Exception {
//        sqlAction(sql);
//        System.out.println("Een student aangemaakt");
//    }
}