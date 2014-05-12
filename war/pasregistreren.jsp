<jsp:include page="header.jsp" />

<div class="content">

<form action="PasRegistreren.do" method="get">
	<h1>Pas registreren</h1> 

	<table>
		<tr>
			<td>Naam rekeninghouder:</td>
			<td><input type="text" name="naamrekeninghouder"></td>
		</tr>
		<tr>
			<td>Pasnummer:</td>
			<td><input type="text" name="pasnummer"></td>
		</tr>
		<tr>
			<td>Verloopdatum(Alleen bij creditcards):</td>
			<td><input type="text" name="dagverloop"> - <input type="text"
					name="maandverloop"> - <input type="text" name="jaarverloop"></td>
		</tr>
		<tr>
			<td>Te betalen bedrag:</td>
			<td><input type="text" name="tebetalenbedrag"></td>
		</tr>
	</table>

	<input type="submit" value="Registreer pas" name="press" /> 
	<input type="submit" value="Toon passen" name="press" /> 
	
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

</form>

</div>

<jsp:include page="footer.jsp" />