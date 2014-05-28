<jsp:include page="header.jsp" />
<%@ page import="Webapp.Dbconnectie"%>
<%@ page import="java.util.*"%>

<div class="content">
	<h1>Onderdeel bestellen</h1>


	<form>
		<table>
		<%
			Dbconnectie db = new Dbconnectie();
			ArrayList<Onderdeel> onderdelen = db.getOnderdelen();
			
		%>
			<tr id = "headRow">
				<td>ProductNr:</td>
				<td>Onderdeel</td>
				<td>Minimale voorraad</td>
				<td>Voorraad</td>
				<td>Bestel</td>
			</tr>
			<tr>
				<td>1</td>
				<td>Uitlaat</td>
				<td>100 stuks</td>
				<td>450 stuks</td>
				<td><input type="text" name="aantal"> </td>
			</tr>
			<tr>
		</table>

		<input type="submit" value="Wijzig" name="wijzig">
		<input type="submit" value="Bestel" name = "bestel">
	</form>
</div>


<jsp:include page="footer.jsp" />
