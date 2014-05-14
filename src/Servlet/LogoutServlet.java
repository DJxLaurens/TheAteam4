package Servlet;

import java.io.*;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.*;

public class LogoutServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

			RequestDispatcher rd = null;
			req.getSession().removeAttribute("name");
			req.getSession().removeAttribute("pass");
			rd = req.getRequestDispatcher("login.jsp");
			rd.forward(req, resp);
		
	}
}
