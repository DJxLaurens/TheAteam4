package Webapp;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PrijsBerekenenServlet extends HttpServlet{
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		RequestDispatcher rd = null;
		
		String press = req.getParameter("press");

		if (press.equals("Pas registreren")){		
			rd = req.getRequestDispatcher("pasregistreren.jsp");
			rd.forward(req, resp);
		}
	}
}
