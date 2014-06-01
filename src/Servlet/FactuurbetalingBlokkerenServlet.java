package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import Connection.GebruikersDAO;
import Connection.ProductDAO;
import Webapp.AutoTotaalDienst;
import Webapp.Gebruiker;

public class FactuurbetalingBlokkerenServlet extends HttpServlet{
		private GebruikersDAO gebruikers = new GebruikersDAO();
	
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
		
			//AutoTotaalDienst atd = (AutoTotaalDienst) getServletContext().getAttribute("atdRef");
		
			RequestDispatcher rd = null;
			int klantId = Integer.parseInt(req.getParameter("klantveld"));
			
			gebruikers.setBlokkade(klantId);
			System.out.println("Klant ID: " + klantId);

			rd = req.getRequestDispatcher("herinneringsbrieven-factuurbetalingblokkeren.jsp");
			rd.forward(req, resp);
		}
	}
