<jsp:include page="header.jsp" />

<div class="content">
	<h1>Minimale voorraad aanpassen - Onderdelen</h1>
	<form>
		<table>
			<tr>
				<td>Kies Onderdeel:</td>
				<td><select><option value="parkeerplaats1">Diesel</option>
						<option value="parkeerplaats2">Benzine</option>
						<option value="parkeerplaats3">LPG</option></select></td>
			</tr>
			<tr>
				<td>Minimale voorraad:</td>
				<td><input type="text" name="naam_reservering" value="1000"></td>
			</tr>
		</table>

		<input type="submit" value="Wijzig">
	</form>
</div>

<jsp:include page="footer.jsp" />
