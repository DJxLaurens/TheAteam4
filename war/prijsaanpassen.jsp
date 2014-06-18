<jsp:include page="header.jsp" />
<%@ page import="DomeinModel.AutoTotaalDienst"%>
<div class="content">
<form action="PrijsAanpassenServlet.do" method="get">
<% AutoTotaalDienst atd = (AutoTotaalDienst)application.getAttribute("atdRef"); %>
	<div class="left">
	<h1>Prijs aanpassen</h1>

	<table>
		<tr>
			<td><b>Brandstofprijs</b></td>
		</tr>
		<tr>
			<td>Literprijs:</td>
			<td><input type="text" name="literprijs"></td>
		</tr>
		<tr>
			<td><b>Onderhoudsprijs</b></td>
		</tr>
		<tr>
			<td>Gewerkte manurenprijs:</td>
			<td><input type="text" name="manurenprijs"></td>
		</tr>
		<tr>
			<td><b>Parkeerprijs</b></td>
		</tr>
		<tr>
			<td>Dagprijs:</td>
			<td><input type="text" name="dagprijs"></td>
		</tr>
		<tr>
			<td>Weekprijs:</td>
			<td><input type="text" name="weekprijs"></td>
		</tr>
		<tr>
			<td>Maandprijs:</td>
			<td><input type="text" name="maandprijs"></td>
		</tr>
	</table>

	<input type="submit" value="Aanpassen" name="press" /> 

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

	<h1>Prijzenoverzicht</h1>
	<div class="box">
		<p>- Literprijs is momenteel: <% out.print(atd.getLiterPrijs()); %><p>
		<p>- Gewerkte manurenprijs is momenteel: <% out.print(atd.getWerkUurPrijs()); %><p>
		<p>- Dagprijs is momenteel: <% out.print(atd.getDagPrijs()); %></p>
		<p>- Weekprijs is momenteel: <% out.print(atd.getWeekPrijs()); %><p>
		<p>- Maandprijs is momenteel: <% out.print(atd.getMaandPrijs()); %><p>
	</div>
</form>

</div>
</div>

<jsp:include page="footer.jsp" />