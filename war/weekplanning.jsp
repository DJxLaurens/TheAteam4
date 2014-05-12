<jsp:include page="header.jsp" />

<div class="content">
	<h1>Weekplanning</h1>
	<form>
		<table>
			<tr>
				<td>Klus:</td>
				<td>Monteur:</td>
				<td>Auto:</td>
				<td>Datum:</td>
			</tr>
			<tr>
				<td>Bougie vervangen</td>
				<td>Sjaak langsma:</td>
				<td>BMW M3:</td>
				<td>12-05-14</td>
			</tr>
		</table>
		<table>
			<tr>
				<td>Selecteer klus:</td>
				<td><select><option value="klus">Banden
							vervangen</option></select></td>
			</tr>
			<tr>
				<td>Datum:</td>
				<td><input type="text" name="dag"> - <input type="text"
					name="maand"> - <input type="text" name="jaar"></td>
			</tr>
			<tr>
				<td>Selecteer Monteur:</td>
				<td><select><option value="monteur">Klaas
							vaak</option></select></td>
			</tr>

		</table>
		<input type="submit" value="Toevoegen">
	</form>
</div>

<jsp:include page="footer.jsp" />
