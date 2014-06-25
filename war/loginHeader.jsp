<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inloggen</title>
<link href="style/style.css" rel="stylesheet">
<link rel="icon" type="image/x-icon" href="images/favicon.ico" />
</head>
<body>
	<div class="headStroke">
	<div class="loginBox">
			<form action="LoginServlet.do" method="post">					
				<h3 style="margin-top: 35px; line-height: 20px;"><img src="images/login_icon.png" style="height: 20px; float: left; margin-right: 8px;">Account</h3>
				<% 
					Object msgs = request.getAttribute("msgs"); 
					if (msgs != null) { 	 
						out.println(msgs); 
						out.println(); 		
					}		
					Object naam = request.getAttribute("email"); 
				%>
					<div>
						<input type="text" class="small" style="margin-right: 10px;" name="naam" placeholder="E-mail adres" value="<%if(naam !=null){ out.println(naam); }%>" />
	
					</div>
					<div>
						<input type="password" class="small" name="wachtwoord" placeholder="Wachtwoord" />
					</div>
					<div>
					<input type="submit" value="Inloggen"/>
					</div>			
			</form>	
		</div>
		</div>
	
	<div class="container">

		<!-- <div class="header"> -->
			<img src="images/Logo-A-Team.png" class="logo"/>
		
			
		<!-- </div> -->
		<div class="menu">
			<ul>
				<li><a href="loginIndex.jsp">Home</a></li>
			</ul>
		</div>
