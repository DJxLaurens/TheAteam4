<jsp:include page="header.jsp" />

<div class="content">
<form action="PrijsAanpassen.do" method="get">
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
	
	<p>- Literprijs is momenteel:<p>
	<p>- Gewerkte manurenprijs is momenteel:<p>
	<p>- Dagprijs is momenteel:</p>
	<p>- Weekprijs is momenteel:<p>
	<p>- Maandprijs is momenteel:<p>

</form>

</div>
</div>

<jsp:include page="footer.jsp" />