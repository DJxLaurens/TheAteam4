package BetalingFacturatieServlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AutoTotaalDienstenDAO;
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

//			if(isDouble(v1) && v2.equals("") && v3.equals("") && v4.equals("") && v5.equals("")){
//				lp = Double.parseDouble(v1);
//				if(lp > 0){
//					atd.setLiterPrijs(lp);
//					PrintWriter out = resp.getWriter();
//					out.println("<script type=\"text/javascript\">");
//					out.println("alert('Literprijs is aangepast!');");  
//					out.println("window.location = 'prijsaanpassen.jsp'");
//					out.println("</script>");
//					out.close();
//				}else{
//					lp = atd.getLiterPrijs();
//					PrintWriter out = resp.getWriter();
//				    out.println("<script type=\"text/javascript\">");
//				    out.println("alert('Vul bij literprijs een getal boven de 0 in!');");  
//				    out.println("window.location = 'prijsaanpassen.jsp'");
//				    out.println("</script>");
//				    out.close();
//				}
//			} 
//			
//			if(v1.equals("") && isDouble && v3.equals("") && v4.equals("") && v5.equals("")){
//				lp = Double.parseDouble(v1);
//				if(lp > 0){
//					atd.setLiterPrijs(lp);
//					PrintWriter out = resp.getWriter();
//					out.println("<script type=\"text/javascript\">");
//					out.println("alert('Literprijs is aangepast!');");  
//					out.println("window.location = 'prijsaanpassen.jsp'");
//					out.println("</script>");
//					out.close();
//				}else{
//					lp = atd.getLiterPrijs();
//					PrintWriter out = resp.getWriter();
//				    out.println("<script type=\"text/javascript\">");
//				    out.println("alert('Vul bij literprijs een getal boven de 0 in!');");  
//				    out.println("window.location = 'prijsaanpassen.jsp'");
//				    out.println("</script>");
//				    out.close();
//				}
//			} 
			
			if(isDouble(v1)){
				lp = atd.getLiterPrijs();
				PrintWriter out = resp.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert(Prijs is aangepast!');");  
				out.println("window.location = 'prijsaanpassen.jsp'");
				out.println("</script>");
				out.close();
			} else {
				lp = atd.getLiterPrijs();
			}

			if(isDouble(v2)){
				mup = Double.parseDouble(v2);
				PrintWriter out = resp.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert(Prijs is aangepast!');");  
				out.println("window.location = 'prijsaanpassen.jsp'");
				out.println("</script>");
				out.close();
			} else{
				mup = atd.getWerkUurPrijs();
			}

			if(isDouble(v3)){
				dp = Double.parseDouble(v3);
				PrintWriter out = resp.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert(Prijs is aangepast!');");  
				out.println("window.location = 'prijsaanpassen.jsp'");
				out.println("</script>");
				out.close();
			} else{
				dp = atd.getDagPrijs();
			}

			if(isDouble(v4)){
				wp = Double.parseDouble(v4);
				PrintWriter out = resp.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert(Prijs is aangepast!');");  
				out.println("window.location = 'prijsaanpassen.jsp'");
				out.println("</script>");
				out.close();
			} else{
				wp = atd.getWeekPrijs();
			}

			if(isDouble(v5)){
				mp = Double.parseDouble(v5);
				PrintWriter out = resp.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert(Prijs is aangepast!');");  
				out.println("window.location = 'prijsaanpassen.jsp'");
				out.println("</script>");
				out.close();
			} else{
				mp = atd.getMaandPrijs();
			}
			
//			if(isDouble(v1) || isDouble(v2) || isDouble(v3) || isDouble(v4) || isDouble(v5)){
//				PrintWriter out = resp.getWriter();
//				out.println("<script type=\"text/javascript\">");
//				out.println("alert(Prijs is aangepast!');");  
//				out.println("window.location = 'prijsaanpassen.jsp'");
//				out.println("</script>");
//				out.close();
//			} else {
//				PrintWriter out = resp.getWriter();
//				out.println("<script type=\"text/javascript\">");
//				out.println("alert(Vul een getal boven de 0 in!');");  
//				out.println("window.location = 'prijsaanpassen.jsp'");
//				out.println("</script>");
//				out.close();
//			}

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
			
			try {
				new AutoTotaalDienstenDAO().deleteAutoTotaalDienst(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				new AutoTotaalDienstenDAO().saveAutoTotaalDienst(atd);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			rd = req.getRequestDispatcher("prijsaanpassen.jsp");
			rd.forward(req, resp);
		}
	}

}
