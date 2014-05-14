package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class KlantenbindingServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		RequestDispatcher rd = null;
		
		String press = req.getParameter("press");

		if (press.equals("Brieven aanmaken")){		
			FileWriter fw = new FileWriter("C:/Users/Jacky/Dropbox/Themaopdracht 4/test.txt", true); 
			PrintWriter pw = new PrintWriter(fw);			
			pw.println("test");
			pw.close(); 
			rd = req.getRequestDispatcher("klantenbinding.jsp");
			rd.forward(req, resp);
		}
	}
}