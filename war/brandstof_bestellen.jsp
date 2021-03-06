<jsp:include page="header.jsp" />
<%@ page import="java.util.*"%>

<div class="content">
	<h1>Brandstof bestellen</h1>

	<%@ page import = "DomeinModel.AutoTotaalDienst" %>
	<%@ page import = "Onderdelen.Product" %>
	
	<a href="voorraad_toevoegen.jsp">Voeg een brandstof toe</a><br>
	<form action="VoorraadWijzigenServlet.do" method="post">
		<table>
		<% AutoTotaalDienst atd = (AutoTotaalDienst)application.getAttribute("atdRef");%> 
			<tr>
				<th></th>
				<th>Brandstofnummer</th>
				<th>Brandstofnaam</th>
				<th>Minimale voorraad</th>
				<th>Voorraad</th>
				<th>In bestelling</th>
				<th>Bestel</th>
			</tr>
			<%for(Product p : atd.getAlleBrandstoffen()){ %>
			<tr id = "headRow">
				<td><a href="verwijderVoorraad.jsp?id=<%=p.getProductNummer()%>&type=1"><img src="images/deleteIcon.png"/></a></td>
				<td><%= p.getProductNummer()  %></td>
				<td><%= p.getProductNaam()  %></td>
				<td><%= p.getMinVoorraad() %> Liter <a href="minimalevoorraad.jsp?id=<%=p.getProductNummer()%>&type=1"><img src="images/edit_icon.png" style="float: right; margin-right: 45px;"/></a></td>
				<td <%if(p.getVoorraad() < p.getMinVoorraad()){%> class="red" <%}%>><%= p.getVoorraad()  %> Liter</td>
				<td><%= p.getInBestelling()  %> Liter</td>
				<td><input type="number" min="1" name="prod_<%=p.getProductNummer()%>"/></td>
				<%if(p.getInBestelling() != 0){ %><td><a href="bestelling_ophalen.jsp?id=<%=p.getProductNummer()%>&type=1"><img src="images/icon-vrachtwagen.png"/></a></td><%} %>
			</tr>
			<input type="hidden" name="voorraadId" value="<%= p.getProductNummer()  %>"/>
			<input type="hidden" name="voorraadNaam" value="<%= p.getProductNaam()  %>"/>
			<input type="hidden" name="voorraadMin" value="<%= p.getMinVoorraad() %>"/>
			<input type="hidden" name="voorraad" value="<%= p.getVoorraad()  %>"/>
			<input type="hidden" name="voorraadType" value="<%= p.getType() %>"/>
			<input type="hidden" name="inbestelling" value="<%= p.getInBestelling() %>"/>
			
			<% }%>
		</table>
		<input type="submit" value="Bestel" name = "bestel">
	</form>
</div>


<jsp:include page="footer.jsp" />
