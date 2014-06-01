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

public class KlantenbindingServlet extends HttpServlet{
	private int brieven = 1;
	private int onderhoud = 1;
	private int afwezig = 1;
	private AutoTotaalDienst atd;
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		RequestDispatcher rd = null;
		
		String press = req.getParameter("press");

		String v1=(String)req.getParameter("veld1");
		String v2=(String)req.getParameter("veld2");
		String v3=(String)req.getParameter("veld3");
		String x = "";
		System.out.println(v1);
		int check = 1;
		
		if(!v1.equals("leeg") && v2.equals("leeg") && v3.equals("leeg")){
			x = v1;
			ArrayList<Gebruiker> klanten = atd.getjongerdan();
			Gebruiker klant = atd.zoekGebruiker(x, klanten);
			atd.verwijderKlant(klant, klanten);
		}

		if(v1.equals("leeg") && !v2.equals("leeg") && v3.equals("leeg")){
			x = v2;
			ArrayList<Gebruiker> klanten = atd.getouderdan();
			Gebruiker klant = atd.zoekGebruiker(x, klanten);
			atd.verwijderKlant(klant, klanten);
		}

		if(v1.equals("leeg") && v2.equals("leeg") && !v3.equals("leeg")){
			x = v3;
			check = 2;
			ArrayList<Gebruiker> klanten = atd.getafwezig();
			Gebruiker klant = atd.zoekGebruiker(x, klanten);
			atd.verwijderKlant(klant, klanten);
		}

		if (press.equals("Brieven aanmaken")){
			req.setAttribute("msgs", brieven);
			if(!x.equals("") && check != 2){
				req.setAttribute("msgs1", onderhoud);
				brieven++;
				onderhoud++;
				FileWriter fw = new FileWriter("C:/testbrieven/Herrinering voor " + x +  " voor een onderhoudsbeurt (+1 jaar) " + ".txt", true); 
				PrintWriter pw = new PrintWriter(fw);			
				pw.println("Geachte " + x + ",");
				pw.println("");
				pw.println("U bent al meer dan 1 jaar geleden voor het laatst langsgeweest voor een onderhoudsbeurt.");
				pw.println("Het is belangrijk dat u zo spoedig mogelijk een nieuwe onderhoudsbeurt inpland.");
				pw.println("");
				pw.println("Met vriendelijke groet,");
				pw.println("");
				pw.println("Henk Paladijn");
				pw.close(); 
				JOptionPane.showMessageDialog(null, "Aanmaken gelukt", "Brief is aangemaakt", JOptionPane.PLAIN_MESSAGE);
				rd = req.getRequestDispatcher("klantenbinding.jsp");
				rd.forward(req, resp);
			}
			else if(check != 2){
				JOptionPane.showMessageDialog(null, "Aanmaken mislukt, Selecteer 1 klant", "Brief is niet aangemaakt", JOptionPane.PLAIN_MESSAGE);
				rd = req.getRequestDispatcher("klantenbinding.jsp");
				rd.forward(req, resp);
			}
			
			if(!x.equals("") && check == 2){
				req.setAttribute("msgs2", afwezig);
				brieven++;
				afwezig++;
				FileWriter fw = new FileWriter("C:/testbrieven/Herinnering voor " + x + " voor een onderhoudsbeurt (+2 maanden) " + ".txt", true); 
				PrintWriter pw = new PrintWriter(fw);			
				pw.println("Geachte " + x + ",");
				pw.println("");
				pw.println("U bent al 2 maanden niet langsgeweest.");
				pw.println("Het is belangrijk om binnenkort weer eens langs te komen.");
				pw.println("");
				pw.println("Met vriendelijke groet,");
				pw.println("");
				pw.println("Henk Paladijn");
				pw.close(); 
				JOptionPane.showMessageDialog(null, "Aanmaken gelukt", "Brief is aangemaakt", JOptionPane.PLAIN_MESSAGE);
				rd = req.getRequestDispatcher("klantenbinding.jsp");
				rd.forward(req, resp);
			}
			else if(check == 2){
				JOptionPane.showMessageDialog(null, "Aanmaken mislukt, Selecteer 1 klant", "Brief is niet aangemaakt", JOptionPane.PLAIN_MESSAGE);
				rd = req.getRequestDispatcher("klantenbinding.jsp");
				rd.forward(req, resp);
			}
		}
	}
}
