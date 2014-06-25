package HerinneringsbrievenServlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.GebruikersDAO;

public class FactuurbetalingBlokkerenServlet extends HttpServlet{
		private GebruikersDAO gebruikers = new GebruikersDAO();
	
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
				
			if(req.getParameter("klantveld").equals("leeg")){
				PrintWriter out = resp.getWriter();
			    out.println("<script type=\"text/javascript\">");
			    out.println("alert('Blokkeren mislukt, selecteer een klant!');");  
			    out.println("window.location = 'herinneringsbrieven-factuurbetalingblokkeren.jsp'");
			    out.println("</script>");
			    out.close();
				
			}else{			
				int klantId = Integer.parseInt(req.getParameter("klantveld"));

				gebruikers.setBlokkade(klantId);

				PrintWriter out = resp.getWriter();
			    out.println("<script type=\"text/javascript\">");
			    out.println("alert('Klant is geblokkeerd!');");  
			    out.println("window.location = 'herinneringsbrieven-factuurbetalingblokkeren.jsp'");
			    out.println("</script>");
			    out.close();
			}
		}
	}
