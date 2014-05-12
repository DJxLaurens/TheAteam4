<jsp:include page="header.jsp" />

<div class="content">

<form action="RapportagesAanmaken.do" method="get">
	<h1>Rapportages aanmaken</h1> 

	<table>
		<tr>
			<td>Vul hoogste hoeveelheid BTW per product in:</td>
			<td><input type="text" name="hoogsteBTWPerProduct"></td>
		</tr>
		<tr>
			<td>Vul gemiddelde BTW per product in:</td>
			<td><input type="text" name="gemiddeldeBTWPerProduct"></td>
		</tr>
		<tr>
			<td>Vul hoogste hoeveelheid BTW per transactie in:</td>
			<td><input type="text" name="hoogsteBTWPerProduct"></td>
		</tr>
		<tr>
			<td>Vul gemiddelde BTW per transactie in:</td>
			<td><input type="text" name="gemiddeldeBTWPerProduct"></td>
		</tr>
		<tr>
			<td>Vul omzet in:</td>
			<td><input type="text" name="gemiddeldeBTWPerProduct"></td>
		</tr>
		<tr>
			<td>Vul winst in:</td>
			<td><input type="text" name="gemiddeldeBTWPerProduct"></td>
		</tr>
	</table>

	<input type="submit" value="Maak rapportages" name="press" /> 
	
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