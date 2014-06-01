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

import Webapp.AutoTotaalDienst;
import Webapp.Gebruiker;

public class BrievenAanmakenServlet extends HttpServlet{
	private AutoTotaalDienst atdRef;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		RequestDispatcher rd = null;
		
		String press = req.getParameter("press");

		String v1=(String)req.getParameter("veld1");
		String x = "";
		System.out.println("v1 =" + v1);
		System.out.println("dit is een string");
		int check = 1;
		
		if(!v1.equals("leeg")){
			x = v1;
//			ArrayList<Gebruiker> klanten = atdRef.getAlleKlantenBrieven90();
//			Gebruiker klant = atdRef.zoekGebruiker(x, klanten);
//			atdRef.verwijderKlant(klant, klanten);
		}

		if (press.equals("Brieven aanmaken")){
			if(!x.equals("") && check != 2){
				FileWriter fw = new FileWriter("C:/testbrieven/Herrinering voor " + x +  " wegens +90 dagen niet betalen " + ".txt", false); 
				PrintWriter pw = new PrintWriter(fw);			
				pw.println("Geachte " + x + ",");
				pw.println("");
				pw.println("U heeft al langer dan 90 dagen gewacht met het betalen van uw factuur.");
				pw.println("Het is belangrijk dat u zo spoedig mogelijk deze factuur betaalt.");
				pw.println("");
				pw.println("Met vriendelijke groet,");
				pw.println("");
				pw.println("Henk Paladijn");
				pw.close(); 
				JOptionPane.showMessageDialog(null, "Aanmaken gelukt", "Brief is aangemaakt", JOptionPane.PLAIN_MESSAGE);
				rd = req.getRequestDispatcher("herinneringsbrieven-brievenaanmaken.jsp");
				rd.forward(req, resp);
			}
			else if(check != 2){
				JOptionPane.showMessageDialog(null, "Aanmaken mislukt, Selecteer 1 klant", "Brief is niet aangemaakt", JOptionPane.PLAIN_MESSAGE);
				rd = req.getRequestDispatcher("herinneringsbrieven-brievenaanmaken.jsp");
				rd.forward(req, resp);
			}
		}
	}
}
