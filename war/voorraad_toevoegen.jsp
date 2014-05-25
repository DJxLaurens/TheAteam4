<jsp:include page="header.jsp" />

<div class="content">
	<h1>Voorraad toevoegen</h1>
	
	<%
		Object msgs = request.getAttribute("msgs");
		if (msgs != null) {
			out.println(msgs);
			out.println();
		}
	%>
	
	<form action="VoorraadToevoegenServlet.do" method="post">
		<table>
			<tr>
				<td>Naam:</td>
				<td><input type="text" name="voorraadNaam"></td>
			</tr>
			<tr>
				<td>Type:</td>
				<td><select>
				<option value="Brandstof" name="type">Brandstof</option>
				<option value="Onderdeel" name="type">Onderdeel</option>
				</select></td>
			</tr>
			<tr>
				<td>Minimale voorraad:</td>
				<td><input type="text" name="voorraadMin"></td>
			</tr>
			<tr>
				<td>Voorraad:</td>
				<td><input type="text" name="voorraad"></td>
			</tr>
			
			<tr>
				<td>Prijs per stuk/liter:</td>
				<td><input type="text" name="voorraadPrijs"></td>
			</tr>
		</table>
		<input type="submit" value="Toevoegen">
	</form>
</div>

<jsp:include page="footer.jsp" />
