package OnderhoudsbeurtServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.KlussenDAO;
import DomeinModel.AutoTotaalDienst;

public class WeekplanningServlet extends HttpServlet {
	private KlussenDAO klus = new KlussenDAO();
	private String datumIngevoerd, datumVandaag, klusNaam, monteurNaam, autoId;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		AutoTotaalDienst atd = (AutoTotaalDienst) getServletContext().getAttribute("atdRef");
		
		String dag = req.getParameter("dag");
		String maand = req.getParameter("maand");
		String jaar = req.getParameter("jaar");
		datumIngevoerd = dag + "-" + maand + "-" + jaar;
		autoId = req.getParameter("autoId");
		monteurNaam = req.getParameter("monteurNaam");
		klusNaam = req.getParameter("klusNaam");
		
		
		RequestDispatcher rd = null;
		
		if(atd.getAlleKlussen().size()!=0){
			int id = Integer.parseInt(req.getParameter("klusID"));
		try {
			klus.saveWeekplanning(klusNaam, monteurNaam, autoId);
			klus.setIngepland(id);
			atd.verwijderKlusById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}else{
			PrintWriter out = resp.getWriter();
		    out.println("<script type=\"text/javascript\">");
		    out.println("alert('Selecteer a.u.b. een klus!');");  
		    out.println("window.location = 'weekplanning.jsp'");
		    out.println("</script>");
		    out.close();
		}
		rd = req.getRequestDispatcher("weekplanning.jsp");
		rd.forward(req, resp);
		
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
