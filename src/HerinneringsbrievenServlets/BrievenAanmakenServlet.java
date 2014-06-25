package HerinneringsbrievenServlets;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DomeinModel.AutoTotaalDienst;
import Onderdelen.Gebruiker;

public class BrievenAanmakenServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException, FileNotFoundException {

		AutoTotaalDienst atd = (AutoTotaalDienst) getServletContext()
				.getAttribute("atdRef");

		String press = req.getParameter("press");
		String v1 = (String) req.getParameter("veld1");
		String x = "";
		int check = 1;

		if (!v1.equals("leeg")) {
			x = v1;
			ArrayList<Gebruiker> klanten = atd.getAlleKlantenBrieven90();
			Gebruiker klant = atd.zoekGebruiker(x, klanten);
			atd.verwijderKlant(klant, klanten);
		}

		if (press.equals("Brieven aanmaken")) {
			if (!x.equals("") && check != 2) {
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HHmm");
				Date datum = new Date();
				try {
					FileWriter fw = new FileWriter("[" + sdf.format(datum)
							+ "] " + x + " - Betaalherinnering +90 dagen.txt",
							false);
					PrintWriter pw = new PrintWriter(fw);
					pw.println("Geachte " + x + ",");
					pw.println("");
					pw.println("U heeft al langer dan 90 dagen gewacht met het betalen van uw factuur.");
					pw.println("Het is belangrijk dat u zo spoedig mogelijk deze factuur betaalt.");
					pw.println("");
					pw.println("Met vriendelijke groet,");
					pw.println("");
					pw.println("Henk Paladijn");

					PrintWriter out = resp.getWriter();
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Brief van " + x + " is aangemaakt!');");
					out.println("window.location = 'herinneringsbrieven-brievenaanmaken.jsp'");
					out.println("</script>");
					out.close();
					pw.close();
				} catch (FileNotFoundException fnfe) {
					fnfe.printStackTrace();
				}
			} else if (check != 2) {

				PrintWriter out = resp.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Aanmaken mislukt, selecteer een klant!');");
				out.println("window.location = 'herinneringsbrieven-brievenaanmaken.jsp'");
				out.println("</script>");
				out.close();
			}
		}
	}
}
