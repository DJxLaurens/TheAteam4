package Webapp;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class LoginServlet extends HttpServlet {
	String userName = "1", userPass = "1", id = "";
	final static String DB_DRIV = "com.mysql.jdbc.Driver";

	private Connection con = null;
	private Statement statement = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		boolean loginSuccess = false;
		String name = req.getParameter("username");
		String pass = req.getParameter("password");

		Object o = getServletContext().getAttribute("name");
		if (o != null) {
			userName = o.toString();
		}
		Object ob = getServletContext().getAttribute("pass");
		if (ob != null) {
			userPass = ob.toString();
		}

		if ("".equals(name) || "".equals(pass)) {
			req.setAttribute("msgs", "Vul A.U.B. uw naam en/of wachtwoord in!");
		} else {
			if (!userName.equals(name) && userPass.equals(pass)) {
				req.setAttribute("msgs", "Naam en/of wachtwoord is onjuist!");
			} else {
				loginSuccess = true;
				req.getSession().setAttribute("name", name);
				req.getSession().setAttribute("pass", pass);
				req.getSession().setAttribute("userId", userName);
				if (userName.equals("administrateur")) {
					req.getSession().setAttribute("userId", userName);
				} else if (userName.equals("planner")) {
					req.getSession().setAttribute("userId", userName);
				} else if (userName.equals("planner")) {
					req.getSession().setAttribute("userId", userName);
				} else if (userName.equals("kassa")) {
					req.getSession().setAttribute("userId", userName);
				} else if (userName.equals("medewerker")) {
					req.getSession().setAttribute("userId", userName);
				} else if (userName.equals("bedrijfsleider")) {
					req.getSession().setAttribute("userId", userName);
				} else if (userName.equals("magazijn")) {
					req.getSession().setAttribute("userId", userName);
				} else if (userName.equals("hoofd")) {
					req.getSession().setAttribute("userId", userName);
				} else {
					req.getSession().setAttribute("userId", "klant");
				}
			}
		}

		RequestDispatcher rd = null;
		if (loginSuccess) {			
			Object ob1 = getServletContext().getAttribute("id");
			if (ob1 != null) {
				id = ob1.toString();

				if (id.equals("klant")) {
					RequestDispatcher rd1 = null;
					rd1 = req.getRequestDispatcher("");
					rd1.forward(req, resp);
				}
				if (id.equals("administrateur")) {
					RequestDispatcher rd1 = null;
					rd1 = req.getRequestDispatcher("klantenbinding.jsp");
					rd1.forward(req, resp);
				}
				if (id.equals("planner")) {
					RequestDispatcher rd1 = null;
					rd1 = req.getRequestDispatcher("");
					rd1.forward(req, resp);
				}
				if (id.equals("kassa")) {
					RequestDispatcher rd1 = null;
					rd1 = req.getRequestDispatcher("");
					rd1.forward(req, resp);
				}
				if (id.equals("medewerker")) {
					RequestDispatcher rd1 = null;
					rd1 = req.getRequestDispatcher("");
					rd1.forward(req, resp);
				}
				if (id.equals("bedrijfsleider")) {
					RequestDispatcher rd1 = null;
					rd1 = req.getRequestDispatcher("menu_werkplaats.jsp");
					rd1.forward(req, resp);
				}
				if (id.equals("magazijn")) {
					RequestDispatcher rd1 = null;
					rd1 = req.getRequestDispatcher("");
					rd1.forward(req, resp);
				}
				if (id.equals("hoofd")) {
					RequestDispatcher rd1 = null;
					rd1 = req.getRequestDispatcher("hoofdmenu.jsp");
					rd1.forward(req, resp);
				}
			}

		} else 
			rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		
	}
	public void readDataBase() throws Exception {
		try {
			// this will load the MySQL driver, each DB has its own driver
			Class.forName(DB_DRIV).newInstance();
			// setup the connection with the DB.
			String databaseURL = "jdbc:mysql://localhost";
			con = DriverManager.getConnection(databaseURL, "root", "");

			// statements allow to issue SQL queries to the database
			statement = con.createStatement();
			// resultSet gets the result of the SQL query
			resultSet = statement.executeQuery("select * from autototaaldiensten.Klant");
			writeResultSet(resultSet);
			
		} catch (Exception e) {
			throw e;
		} finally {
			statement.close();
			resultSet.close();
			con.close();
		}
	}
	private void writeResultSet(ResultSet resultSet) throws SQLException {
		while (resultSet.next()) {
			String id = resultSet.getString("id");
			String naam = resultSet.getString("naam");
			String adres = resultSet.getString("adres");
			String postcode = resultSet.getString("postcode");
			Date date = resultSet.getDate("geboren");
		}
	}

}
