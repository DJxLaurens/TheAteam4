<jsp:include page="header.jsp" />

<div class="content">
<div class="left">
	<%@ page import="Webapp.Gebruiker"%>
	<%@ page import="Webapp.Auto"%>
	<%@ page import="Webapp.AutoTotaalDienst"%>
<form action="KlantenbindingServlet.do" method="get">
	<% AutoTotaalDienst atd = (AutoTotaalDienst)application.getAttribute("atdRef"); %>
	<h1>Herinneringsbrieven</h1>
	
	<h2>Klantenbinding</h2>

	<h4>Klanten met auto's jonger dan 2010 die een onderhoudsbeurt
		nodig hebben:</h4>
    
	<div>
		<select name="veld1">
			<% for(Gebruiker g : atd.getAlleKlanten()) { %>
			<option value="naam"><%= g.getNaam() %></option>
			<% }%>
		</select>
	</div>



	<h4>Klanten met auto's ouder dan 2010 die een onderhoudsbeurt
		nodig hebben:</h4>

	<div>
		<select name="veld2">
			<option value="leeg"></option>
			<option value="henk">Henk</option>
		</select>
	</div>

	<h4>Klanten die langer dan 2 maanden niet aanwezig zijn geweest:</h4>

	<div>
		<select name="veld3">
			<option value="leeg"></option>
			<option value="jan">Jan</option>
		</select>
	</div>

	</br>

	<input type="submit" value="Brieven aanmaken" name="press" /> 

</div>

<div class="right">
	<%@ page import="java.util.Calendar"%>
	<%! Calendar now = Calendar.getInstance(); %>
	<%
		int day = now.get(Calendar.DATE);
		int month = now.get(Calendar.MONTH) + 1;
		int year = now.get(Calendar.YEAR);
		String s = day + "-" + month + "-" + year;
		%>
	</br> </br>
	<%= s %>

	<h1>Brievenoverzicht</h1>
	<div class="box">
		<p>- Er moeten nog aantal brieven aangemaakt worden<p>
	</div>
</form>

</div>
</div>

<jsp:include page="footer.jsp" />