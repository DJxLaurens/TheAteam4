package MyServletContextListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import DAO.AutoTotaalDienstenDAO;
import DomeinModel.AutoTotaalDienst;

public class MyServletContextListener implements ServletContextListener  {
	// zorgt ervoor dat klasse AutoTotaalDiensten in een context wordt gezet
	public void contextInitialized(ServletContextEvent sce) {
		AutoTotaalDienst atd = new AutoTotaalDienstenDAO().getATD();
		sce.getServletContext().setAttribute("atdRef", atd);
	}
	
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
