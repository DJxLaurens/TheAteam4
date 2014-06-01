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
import javax.swing.JOptionPane;

import Webapp.AutoTotaalDienst;

public class FactuurbetalingBlokkerenServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		AutoTotaalDienst atd = (AutoTotaalDienst) getServletContext().getAttribute("atdRef");
		
		RequestDispatcher rd = null;
		
		String press = req.getParameter("press");
		String klant=(String)req.getParameter("klantveld");
		
		if (press.equals("Betaling blokkeren")){
			
		}
	}
}
