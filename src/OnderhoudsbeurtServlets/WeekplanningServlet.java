package OnderhoudsbeurtServlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.KlussenDAO;

public class WeekplanningServlet {
	private KlussenDAO klus = new KlussenDAO();
	private String datumIngevoerd, datumVandaag;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String dag = req.getParameter("dag");
		String maand = req.getParameter("maand");
		String jaar = req.getParameter("jaar");
		datumIngevoerd = dag + maand + jaar;
		datumVandaag = getDay() + getMonth() + getYear();
		String monteur = req.getParameter("monteur");
	}

	public String getDay() {
		DateFormat dateFormat = new SimpleDateFormat("dd");
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}

	public String getMonth() {
		DateFormat dateFormat = new SimpleDateFormat("MM");
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}

	public String getYear() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy");
		Calendar cal = Calendar.getInstance();
		return dateFormat.format(cal.getTime());
	}

}
