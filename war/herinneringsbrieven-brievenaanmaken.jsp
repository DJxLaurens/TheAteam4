
<jsp:include page="header.jsp" />

<div class="content">
	<%@ page import="Onderdelen.Gebruiker"%>
	<%@ page import="Onderdelen.Auto"%>
	<%@ page import="DomeinModel.AutoTotaalDienst"%>
	<%@ page import="KlantenbindingServlets.KlantenbindingServlet" %>
<form action="BrievenAanmakenServlet.do" method="get">
	<% AutoTotaalDienst atd = (AutoTotaalDienst)application.getAttribute("atdRef"); %>
	<div class="left">
	<h1>Herinneringsbrieven</h1>
	
	<h2>Brieven aanmaken</h2>

	<h4>Klanten die nog niet betaald hebben binnen 90 dagen:</h4>

	<div>
		<select name="veld1">
			<option value="leeg">Kies een klant</option>
			
			<% for(Gebruiker g : atd.getAlleKlantenBrieven90()) { %>
			<option value="<%= g.getNaam() %>"><%= g.getNaam() %></option>
			<% }%>
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
		<p>- Er moeten nog <%= atd.getAlleKlantenBrieven90().size() %> brieven aangemaakt worden<p>
	</div>

</form>
</div>

</div>

<jsp:include page="footer.jsp" />