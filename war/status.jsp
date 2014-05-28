<jsp:include page="header.jsp" />

<div class="content">
	<%@ page import = "Webapp.Klus" %>
	<%@ page import = "Webapp.AutoTotaalDienst" %>
	<h1>Status 12-04-14</h1>
	<form>
		<table>
			<tr>
				<td>Klus:</td>
				<td>Monteur:</td>
				<td>Auto:</td>
				<td>Datum:</td>
			</tr>
			<% AutoTotaalDienst atd = (AutoTotaalDienst)application.getAttribute("atdRef"); 
			
			for(Klus k : atd.getAlleKlussen()) { %>
			<tr id = "headRow">
				<td><%= k.getKlusNaam()  %></td>
				<td><%= k.getWerknemerId() %></td>
				<td><%= k.getAutoId()  %></td>
				<td>0</td>
				<td><input type="text" name="aantal"> </td>
			</tr>
			<% }%>
		</table>		
		<input type="submit" value="Facturatie">
	</form>
</div>

<jsp:include page="footer.jsp" />
