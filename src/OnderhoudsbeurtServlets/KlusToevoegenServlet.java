package OnderhoudsbeurtServlets;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AutosDAO;
import DAO.KlussenDAO;
import DomeinModel.AutoTotaalDienst;
import Onderdelen.Auto;
import Onderdelen.Klus;

public class KlusToevoegenServlet extends HttpServlet {
	private KlussenDAO klus = new KlussenDAO();
	private String klusNaam;
	private String klusOmschrijving;
	private int autoId;
	private int werknemerId;
	private String s;
	private String datum, datumDB;
	private int datumIngevuld, datumVandaag;
	public String getToday() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		AutoTotaalDienst atd = (AutoTotaalDienst) getServletContext().getAttribute("atdRef");
		klusNaam = req.getParameter("klusNaam");
		klusOmschrijving = req.getParameter("klusOmschrijving");
		String string = (String) req.getParameter("auto");
		autoId = Integer.parseInt(string);
		werknemerId = 0;
		
String dag = req.getParameter("dag");
String maand = req.getParameter("maand");
String jaar = req.getParameter("jaar");

if (!"".equals(klusNaam) && !"".equals(klusOmschrijving)
		&& !"".equals(dag) && !"".equals(maand) && !"".equals(jaar)) {
	datum = jaar + maand + dag;
	datumIngevuld = Integer.parseInt(datum);
	datumVandaag = Integer.parseInt(getToday());
	datumDB = dag + "-" + maand + "-" + jaar;
	if (datumIngevuld > datumVandaag) {
		Klus k = new Klus(0, klusNaam, klusOmschrijving, autoId,
				werknemerId, datumDB, 0);		
			try {
				klus.saveKlus(k);
				for(Auto a : atd.getAlleAutos()){
					if(a.getAutoID() == autoId){
						k.voegAutoToe(a);
						k.voegDatumToe(datum);
						}
					}
					s = "Toevoegen is gelukt";
				} catch (SQLException e) {
					e.printStackTrace();
					s = "Toevoegen is mislukt";
				}
			} else {
				s = "datum moet in de toekomst liggen";
			}
		} else {
			s = "Vul een klusnaam, klusomschrijving en een datum in";
		}
		req.setAttribute("msgs", s);
		RequestDispatcher rd = null;
		rd = req.getRequestDispatcher("klus_toevoegen.jsp");
		rd.forward(req, resp);
	}
}
