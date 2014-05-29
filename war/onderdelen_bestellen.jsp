
<jsp:include page="header.jsp" />
<%@ page import="Connection.Dbconnectie"%>
<%@ page import="java.util.*"%>

<div class="content">
	<h1>Onderdeel bestellen</h1>

	<%@ page import = "Webapp.AutoTotaalDienst" %>
	<%@ page import = "Webapp.Product" %>
	<form action="VoorraadToevoegenServlet.do" method="post">
		<table>
		<% AutoTotaalDienst atd = (AutoTotaalDienst)application.getAttribute("atdRef");%> 
			<tr>
				<th>Onderdeelnummer</th>
				<th>Onderdeelnaam</th>
				<th>Minimale voorraad</th>
				<th>Voorraad</th>
				<th>Bestel</th>
			</tr>
			<%for(Product p : atd.getAlleOnderdelen()){ %>
			<tr id = "headRow">
				<td><%= p.getProductNummer()  %></td>
				<td><%= p.getProductNaam()  %></td>
				<td><%= p.getMinVoorraad() %></td>
				<td><%= p.getVoorraad()  %></td>
				<td><input type="text" name="prod_<%=p.getProductNummer()%>"/></td>
			</tr>
			<% }%>
		</table>

		<input type="submit" value="Wijzig" name="wijzig">
		<input type="submit" value="Bestel" name = "bestel">
	</form>
</div>


<jsp:include page="footer.jsp" />
