<jsp:include page="header.jsp" />
<div class="content">
	<h1>Registreer</h1>
	<form action="RegistreerServlet.do" method="post">
		<table>
			<%
					Object msgs = request.getAttribute("msgs");
					if (msgs != null) {
						out.println(msgs);
						out.println();
					}
				%>

			<tr>
				<td>Naam:</td>
				<td><input type="text" name="naam" /></td>
			</tr>

			<tr>
				<td>Wachtwoord:</td>
				<td><input type="password" name="wachtwoord" /></td>
			</tr>

			<tr>
				<td>Bevestig wachtwoord:</td>
				<td><input type="password" name="wachtwoord2" /></td>
			</tr>

			<tr>
				<td>Adres:</td>
				<td><input type="text" name="adres" /></td>
			</tr>

			<tr>
				<td>Postcode:</td>
				<td><input type="text" name="postcode" /></td>
			</tr>

			<tr>
				<td>Woonplaats:</td>
				<td><input type="text" name="woonplaats" /></td>
			</tr>

			<tr>
				<td>Telefoonnummer:</td>
				<td><input type="text" name="telefoonnummer" /></td>
			</tr>

			<tr>
				<td>Emailadres:</td>
				<td><input type="text" name="emailadres" /></td>
			</tr>

			<tr>
				<td>Bevestig emailadres:</td>
				<td><input type="text" name="emailadres2" /></td>
			</tr>
			<tr>
				<td><select name="rol_id">
						<option value="9">Administrateur</option>
						<option value="2">Bedrijfsleider</option>
						<option value="3">Kassamedewerker</option>
						<option value="4">Klant</option>
						<option value="5">Magazijnmedewerker</option>
						<option value="6">Planner</option>
						<option value="7">Monteur</option>
						<option value="8">Garagemedewerker</option>
				</select></td>
			</tr>
		</table>
		<div>
			<input type="submit" value="Registreer" /> <a href="loginIndex.jsp">Login</a>
		</div>
	</form>
</div>
<jsp:include page="footer.jsp" />