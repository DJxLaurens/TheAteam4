<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	if (session.getAttribute("rol") == null) {
%>
<jsp:forward page="loginIndex.jsp" />
<%
	}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Autototaaldiensten</title>
<link href="style/style.css" rel="stylesheet">
</head>
<body>	
	<div class="container">
		<div class="headerUser">
			<img src="images/Logo-A-Team.png" class="logo" />
			<div class="uitloggen">
				<form action="LogoutServlet.do" method="get">
					<table>
						<tr>
							<td>Naam:</td>
							<td><%=session.getAttribute("naam")%></td>
						</tr>
						<tr>
							<td>Email-adres:</td>
							<td><%=session.getAttribute("email")%></td>
						</tr>
						<tr>
							<td>laatstGeweest:</td>
							<td><%=session.getAttribute("laatstgeweest")%></td>
						</tr>
						<tr>
							<td>openFactuur:</td>
							<td><%=session.getAttribute("openFactuur")%></td>
						</tr>
						<tr>
							<td><input type="submit" value="Uitloggen" /></td>
						</tr>
					</table>
				</form>
			</div>
		</div>

		<div class="menu">
			<ul>
				<li><a href="index.jsp">Home</a></li>
				<% int rol = Integer.parseInt(session.getAttribute("rol").toString());
				if(rol == 5 || rol == 9){ %>
				<li>Voorraadbeheer
					<ul>
						<li><a href="onderdelen_bestellen.jsp">Onderdelen</a></li>
						<li><a href="brandstof_bestellen.jsp">Brandstof</a></li>
					</ul></li>
				<%} %>
				<%if(rol == 6 || rol == 9){ %>
				<li>Onderhoudsbeurt
					<ul>
						<li><a href="klus_toevoegen.jsp">Klus toevoegen</a></li>
						<li><a href="weekplanning.jsp">Weekplanning</a></li>
						<li><a href="status.jsp">Status</a></li>
					</ul></li>
				<%} %>
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
				<%if(rol == 1 || rol == 9){ %>
<<<<<<< HEAD
				<li>Herinneringsbrieven		
					<ul>
						<li><a href="herinneringsbrieven-brievenaanmaken.jsp">Brieven aanmaken</a></li>
						<li><a href="herinneringsbrieven-factuurbetalingblokkeren.jsp">Factuurbetaling blokkeren</a></li>						
						<li><a href="klantenbinding.jsp" title="Klantenbinding">Klantenbinding</a></li>						
					</ul></li>
=======
				<div class = "herinneringsbrieven">
					<li>Herinneringsbrieven			
						<ul>
							<li><a href="herinneringsbrieven-brievenaanmaken.jsp">Brieven aanmaken</a></li>
							<li><a href="herinneringsbrieven-factuurbetalingblokkeren.jsp">Factuurbetaling blokkeren</a></li>						
							<li><a href="klantenbinding.jsp">Klantenbinding</a></li>						
						</ul>
					</li>
				</div>
>>>>>>> branch 'master' of https://github.com/DJxLaurens/TheAteam4.git
				<%} %>
				<%if(rol == 1 || rol == 3 || rol == 9){ %>
				<li>Betalingen/Facturatie
					<ul>
						<li><a href="prijsaanpassen.jsp">Prijs aanpassen</a></li>
						<li><a href="prijsberekenen.jsp">Prijs berekenen</a></li>
						<li><a href="rapportagesaanmaken.jsp">Rapportages
								aanmaken</a></li>
					</ul></li>
				<%} %>
				<%if(rol == 3 || rol == 9){ %>
				<li><a href="registreer.jsp">Registreren</a>
				<%} %>
			</ul>
		</div>
