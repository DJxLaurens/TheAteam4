<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inloggen</title>
<link href="style.css" rel="stylesheet">
</head>
<body>
	<div class="container">
		<div class="header">
			<img src="images/Logo-A-Team.png" />
		<form action="LoginServlet.do" method="post">					
			<h3>Login</h3>
			<% 
				Object msgs = request.getAttribute("msgs"); 
				if (msgs != null) { 	 
					out.println(msgs); 
					out.println(); 		
				}					
			%>	      
				<div>		
					<label>Naam:</label> 
					<input type="text" name="naam" />
				</div>
				<div>
					<label>Wachtwoord:</label>
					<input type="password" name="wachtwoord" />
				</div>
				<div>
				<input type="submit" value="Inloggen"/>
				<a href="registreer.jsp">Registreer</a>
				</div>			
		</form>	
			
		</div>
		<div class="menu">
			<ul>
				<li><a href="loginIndex.jsp">Home</a></li>
			</ul>
		</div>
