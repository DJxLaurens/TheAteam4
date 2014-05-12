<jsp:include page="header.jsp" />

<div class="content">
	<h1>Parkeerplaats reserveren</h1>


	<form>
		<table>
			<tr>
				<td>Kies parkeerplaats:</td>
				<td><select><option value="parkeerplaats1">Parkeerplaats
							1</option>
						<option value="parkeerplaats2">Parkeerplaats 2</option>
						<option value="parkeerplaats3">Parkeerplaats 3</option></select></td>
			</tr>
			<tr>
				<td>Naam reservering:</td>
				<td><input type="text" name="naam_reservering"></td>
			</tr>
			<tr>
				<td>Kenteken Auto:</td>
				<td><input type="text" name="kenteken"></td>
			</tr>
			<tr>
				<td>Datum:</td>
				<td><input type="text" name="dag"> - <input type="text"
					name="maand"> - <input type="text" name="jaar"></td>
			</tr>
		</table>

		<input type="submit" value="Reserveer">
	</form>
</div>

<jsp:include page="footer.jsp" />
