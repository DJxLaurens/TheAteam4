package VoorraadbeheerServlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DomeinModel.AutoTotaalDienst;

public class PrijsAanpassenServlet extends HttpServlet{

	public boolean isDouble(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		AutoTotaalDienst atd = (AutoTotaalDienst) getServletContext().getAttribute("atdRef");

		RequestDispatcher rd = null;

		String press = req.getParameter("press");

		if (press.equals("Aanpassen")){

			String v1=(String)req.getParameter("literprijs");
			String v2=(String)req.getParameter("manurenprijs");
			String v3=(String)req.getParameter("dagprijs");
			String v4=(String)req.getParameter("weekprijs");
			String v5=(String)req.getParameter("maandprijs");

			double lp = 0;
			double mup = 0;
			double dp = 0;
			double wp = 0;
			double mp = 0;

			if(isDouble(v1)){
				lp = Double.parseDouble(v1);
			} else{
				lp = atd.getLiterPrijs();
			}

			if(isDouble(v2)){
				mup = Double.parseDouble(v2);
			} else{
				mup = atd.getWerkUurPrijs();
			}

			if(isDouble(v3)){
				dp = Double.parseDouble(v3);
			} else{
				dp = atd.getDagPrijs();
			}

			if(isDouble(v4)){
				wp = Double.parseDouble(v4);
			} else{
				wp = atd.getWeekPrijs();
			}

			if(isDouble(v5)){
				mp = Double.parseDouble(v5);
			} else{
				mp = atd.getMaandPrijs();
			}

			if(lp > 0){
				atd.setLiterPrijs(lp);
			}
			if(mup > 0){
				atd.setWerkUurPrijs(mup);
			}
			if(dp > 0){
				atd.setDagPrijs(dp);
			}
			if(wp > 0){
				atd.setWeekPrijs(wp);
			}
			if(mp > 0){
				atd.setMaandPrijs(mp);
			}

			rd = req.getRequestDispatcher("prijsaanpassen.jsp");
			rd.forward(req, resp);
		}
	}

}
