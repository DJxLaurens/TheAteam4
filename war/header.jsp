<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	if (session.getAttribute("rol") == null) {
%>
<jsp:forward page="loginIndex.jsp" />
<%
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Autototaaldiensten</title>
<link href="style/style.css" rel="stylesheet">
<link rel="icon" type="image/x-icon" href="images/favicon.ico" />
</head>
<body>	

<div class="headStroke">
	<div class="accountBox">
		
		<form action="LogoutServlet.do" method="get">
			<table style="margin-top: 35px;">
			<tr>
				<td>
					<h3 style="margin: 0px; line-height: 20px; float: left;"><img src="images/my_account.png" style="height: 20px; float: left; margin-right: 8px;">Account</h3>
				</td>
			</tr>
				<tr>
					<td><b>Naam:</b></td>
					<td><%=session.getAttribute("naam")%></td>
				</tr>
				<tr>
					<td><b>Email-adres:</b></td>
					<td><%=session.getAttribute("email")%></td>
				</tr>
				<tr>
					<td><b>laatstGeweest:</b></td>
					<td><%=session.getAttribute("laatstgeweest")%></td>
				</tr>
				<tr>
					<td><b>openFactuur:</b></td>
					<td><%=session.getAttribute("openFactuur")%></td>
				</tr>
			</table>
			<input type="submit" value="Uitloggen" />
		</form>
	</div>
	</div>
	<div class="container">
			<img src="images/Logo-A-Team.png" class="logo" />

		<div class="menu">
			<ul>
				<li><a href="index.jsp">Home</a></li>
				<% int rol = Integer.parseInt(session.getAttribute("rol").toString());
				if(rol == 5 || rol == 9){ %>
				<li id="voorraadbeheer">Voorraadbeheer
					<ul>
						<li id ="onderdelen bestellen"><a href="onderdelen_bestellen.jsp">Onderdelen</a></li>
						<li id ="brandstof bestellen"><a href="brandstof_bestellen.jsp">Brandstof</a></li>
					</ul></li>
				<%} %>
				<%if(rol == 6 || rol == 9 || rol == 4){ %>
				<li id="onderhoudsbeurt">Onderhoudsbeurt
					<ul>
						<%if(rol == 6 || rol == 9 || rol == 4){ %>
						<li id="klus toevoegen"><a href="klus_toevoegen.jsp">Klus toevoegen</a></li>
						<%}
						if(rol == 6 || rol == 9 || rol == 4){ %>
						<li id="weekplanning"><a href="weekplanning.jsp">Planning</a></li>
						<%} %>
					</ul></li>
				<%} %>
				<!--  
				<%if(rol == 2 || rol == 4 || rol == 8 || rol == 9){ %>
				<li>Parkeergarage				
					<ul>
						<%if(rol == 2 || rol == 9){ %>
						<li><a href="parkeerplaats_reserveren.jsp">Parkeerplaats reserveren</a></li>
						<%} %>
						<%if(rol == 2 || rol == 4 || rol == 9){ %>
						<li><a href="parkeerplaats_terugboeken.jsp">Parkeerplaats terugboeken</a></li>
						<%} %>
						<%if(rol == 2 || rol == 8 || rol == 9){ %>
						<li><a href="overzicht_bezetting.jsp">Overzicht vorige maand</a></li>
						<%} %>
					</ul></li>	
				<%} %>		
				-->	
				<%if(rol == 1 || rol == 9){ %>
					<li id="herinneringsbrieven">Herinneringsbrieven			
						<ul>
							<li id="brieven aanmaken"><a href="herinneringsbrieven-brievenaanmaken.jsp">Brieven aanmaken</a></li>
							<li id="factuurbetaling blokkeren"><a href="herinneringsbrieven-factuurbetalingblokkeren.jsp">Factuurbetaling blokkeren</a></li>						
							<li id="klantenbinding"><a href="klantenbinding.jsp">Klantenbinding</a></li>						
						</ul>
					</li>

				<%} %>
				<%if(rol == 1 || rol == 3 || rol == 9){ %>
				<li id = "betalingen/facturatie">Betalingen/Facturatie
					<ul>
						<li id="prijs aanpassen"><a href="prijsaanpassen.jsp">Prijs aanpassen</a></li>
						<!--<li><a href="prijsberekenen.jsp">Prijs berekenen</a></li>-->
						<li id="rapportages aanmaken"><a href="rapportagesaanmaken.jsp">Rapportages
								aanmaken</a></li>
					</ul></li>
				<%} %>
				<%if(rol == 3 || rol == 9){ %>
				<li id="registreren"><a href="registreer.jsp">Registreren</a>
				<%} %>
			</ul>
		</div>
