package MyServletContextListener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import DomeinModel.AutoTotaalDienst;

public class MyServletContextListener implements ServletContextListener  {

	public void contextInitialized(ServletContextEvent sce) {
		AutoTotaalDienst atd = new AutoTotaalDienst();
		sce.getServletContext().setAttribute("atdRef", atd);
	}
	
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
