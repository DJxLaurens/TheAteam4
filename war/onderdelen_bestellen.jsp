
<jsp:include page="header.jsp" />

<div class="content">
	<h1>Onderdeel bestellen</h1>

	<%@ page import = "Webapp.AutoTotaalDienst" %>
	<%@ page import = "Webapp.Klus" %>
	<form action="VoorraadToevoegenServlet.do" method="post">
		<table>
			<tr id = "headRow">
				<td>ProductNr:</td>
				<td>Onderdeel</td>
				<td>Minimale voorraad</td>
				<td>Voorraad</td>
				<td>Bestel</td>
			</tr>
			<% for(Klus k : AutoTotaalDienst.getAlleKlussen()){ %>
			<tr>
				<td><%= k.getKlusNummer()  %></td>
				<td><%= k.getKlusNaam()  %></td>
				<td><%= k.g  %></td>
				<td><%= k.getWerknemerId()  %></td>
				<td><input type="text" name="aantal"> </td>
			</tr>
			<% } %>
		</table>

		<input type="submit" value="Wijzig" name="wijzig">
		<input type="submit" value="Bestel" name = "bestel">
	</form>
</div>


<jsp:include page="footer.jsp" />
