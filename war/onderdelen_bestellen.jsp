
<jsp:include page="header.jsp" />
<%@ page import="Connection.Dbconnectie"%>
<%@ page import="java.util.*"%>

<div class="content">
	<h1>Onderdeel bestellen</h1>

	<%@ page import = "Webapp.AutoTotaalDienst" %>
	<%@ page import = "Webapp.Product" %>
	<form action="VoorraadToevoegenServlet.do" method="post">
		<table>
		<% AutoTotaalDienst atd = (AutoTotaalDienst)application.getAttribute("atdRef"); 
			
			for(Product p : atd.getAlleOnderdelen()){ %>
			<tr id = "headRow">
				<td><%= p.getProductNaam()  %></td>
				<td>Onderdeel</td>
				<td>Minimale voorraad</td>
				<td>Voorraad</td>
				<td>Bestel</td>
			</tr>
			<% }%>
		</table>

		<input type="submit" value="Wijzig" name="wijzig">
		<input type="submit" value="Bestel" name = "bestel">
	</form>
</div>


<jsp:include page="footer.jsp" />
