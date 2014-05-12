<jsp:include page="header.jsp" />

<div class="content">
	<h1>Brandstof bestellen</h1>


	<form>
		<table>
			<tr id = "headRow">
				<td>ProductNr:</td>
				<td>Brandstof</td>
				<td>Minimale voorraad</td>
				<td>Voorraad</td>
				<td>Bestel</td>
			</tr>
			<tr>
				<td>1</td>
				<td>Diesel</td>
				<td>1000 liter</td>
				<td>450 liter</td>
				<td><input type="text" name="aantal"> </td>
			</tr>
			<tr>
		</table>

		<input type="submit" value="Wijzig" name="wijzig">
		<input type="submit" value="Bestel" name = "bestel">
	</form>
</div>


<jsp:include page="footer.jsp" />
