<jsp:include page="header.jsp" />

<div class="content">
	<h1>Klus toevoegen</h1>
	<form>
		<table>
			<tr>
				<td>Klus omschrijving:</td>
				<td><input type="text" name="klusnaam"></td>
			</tr>
			<tr>
				<td>Klus nummer:</td>
				<td>4</td>
			</tr>
			<tr>
				<td>Kies Auto:</td>
				<td><select><option value="BMW M3 GTR">BMW M3 GTR</option>
				</select></td>
			</tr>
		</table>
		<input type="submit" value="Toevoegen">
	</form>
</div>

<jsp:include page="footer.jsp" />
