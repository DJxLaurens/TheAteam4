<jsp:include page="header.jsp" />

<div class="content">
	<h1>Planning</h1>
	<%@ page import="Onderdelen.Klus"%>
	<%@ page import="Onderdelen.Gebruiker"%>
	<%@ page import="Onderdelen.Weekplanning"%>
	<%@ page import="Onderdelen.Auto"%>
	<%@ page import="DomeinModel.AutoTotaalDienst"%>
	<form action="WeekplanningServlet.do" method="post">
		<% 
		Object msgs = request.getAttribute("msgs"); 
		if (msgs != null) { 	 
			out.println(msgs); 
			out.println(); 		
		}		
		%>
		<table>
			<tr>
				<th style="text-align: left;">Klusnummer:</th>
				<th style="text-align: left;">Datum:</th>
				<th style="text-align: left;">Klus:</th>
				<th style="text-align: left;">Monteur:</th>
				<th style="text-align: left;">Auto:</th>
			</tr>
			<% AutoTotaalDienst atd = (AutoTotaalDienst)application.getAttribute("atdRef"); 
			
			for(Weekplanning w : atd.getWeekplanning()) { %>
			<tr id="headRow">
				<td><%out.println(w.getId());%></td>
				<td><%out.println(w.getDatum());%></td>
				<td><%out.println(w.getKlusNaam());%></td>
				<td><%out.println(w.getMonteur());%></td>
				<td><%out.println(w.getAuto());%></td>
				<td><a href="verwijderWeekplanning.jsp?id=<%=w.getId()%>"><img src="images/deleteIcon.png"/></a></td>
			</tr>
			<%}%>
		</table>
		<table>
			<tr>
				<td>Selecteer klus:</td>
				<td><select>
						<%
				for(Klus k : atd.getAlleKlussen()) {
					if(k.getWerknemerId() == 0){ %>
						<option name="leeg" value="selecteer klus">selecteer klus</option>
						<option name=klus value="<%=k.getKlusNaam()%>"><%=k.getKlusNaam()%></option>
						<input type="hidden" name="klusNaam" value="<%=k.getKlusNaam()%>"/>
						<input type="hidden" name="klusID" value="<%=k.getKlusNummer()%>"/>
						<input type="hidden" name="autoId" value="<%=k.getAutoId()%>"/>
						<input type="hidden" name="datum" value="<%=k.getDatum() %>"/>
						<%
					}
				}%>
				</select></td>
			</tr>
			<tr>
				<td>Selecteer Monteur:</td>
				<td><select>
					<%
					for(Gebruiker g : atd.getAlleMonteurs()) {
						if(g.getRol() == 4){
						%><option value=<%= g.getNaam() %>><%= g.getNaam() %>
						<input type="hidden" name="monteurNaam" value="<%=g.getNaam()%>"/>
					<%}
					}%></option>
				</select></td>
			</tr>
			
			

		</table>
		<input type="submit" value="Toevoegen">
	</form>
</div>

<jsp:include page="footer.jsp" />
