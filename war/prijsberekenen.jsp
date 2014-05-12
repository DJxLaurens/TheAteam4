<jsp:include page="header.jsp" />

<div class="content">
<div class="left">
<form action="PrijsBerekenen.do" method="get">
	<h1>Prijs Berekenen</h1>
	<table>
		<tr>
			<td><b>Bepaal type dienst:</b></td>
		</tr>
	</table>
	<select>
		<option value="Tanken">Tanken</option>
		<option value="Onderhoudsbeurt">Onderhoudsbeurt</option>
		<option value="Parkeren">Parkeren</option>
	</select>
	<table>
		<tr>
			<td><b>Tanken</b></td>
		</tr>
		<tr>
			<td>Hoeveelheid liters:</td>
			<td><input type="text" name="aantal"></td>
		</tr>
		<tr>
			<td><b>Onderhoudsbeurt</b></td>
		</tr>
		<tr>
			<td>Klussen:</td>
		</tr>
	</table>
	<select>
		<option value="leeg"></option>
		<option value="Nieuwe banden">Nieuwe banden</option>
		<option value="Bougie vervangen">Bougie vervangen</option>
	</select>
	<table>
		<tr>
			<td>Gewerkte manuren:</td>
			<td><input type="text" name="aantal"></td>
		</tr>
		<tr>
			<td>Gebruikt onderdeel:</td>
		</tr>
		</table>
			<select>
				<option value="leeg"></option>
				<option value="Uitlaat">Uitlaat</option>
				<option value="Voorlamp">Voorlamp</option>
			</select>
		<table>
		<tr>
			<td>Hoeveelheid onderdelen:</td>
			<td><input type="text" name="aantal"></td>
		</tr>
		<tr>
			<td><b>Parkeren</b></td>
		</tr>
		<tr>
			<td>Aantal dagen:</td>
			<td><input type="text" name="aantal"></td>
		</tr>
		<tr>
			<td>Aantal weken:</td>
			<td><input type="text" name="aantal"></td>
		</tr>
		<tr>
			<td>Aantal maanden:</td>
			<td><input type="text" name="aantal"></td>
		</tr>
		<tr>
			<td><b>Kies klant:</b></td>
		</tr>
	</table>
	<select>
		<option value="leeg"></option>
		<option value="Jan">Jan</option>
		<option value="Klaas">Klaas</option>
	</select>
	<div>
	<input type="submit" value="Pas registreren" name="press" />
	<input type="submit" value="Direct betalen" name="press" /> 
	<input type="submit" value="Factuur aanmaken" name="press" /> 
	<input type="submit" value="Terug" name="press" />  
	</div>
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
	<p>- Weekprijs is momenteel:<p>
	<p>- Maandprijs is momenteel:<p>

</form>

</div>
</div>

<jsp:include page="footer.jsp" />