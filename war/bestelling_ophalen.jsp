<jsp:include page="header.jsp" />
<%@ page import="java.util.*"%>
<%@ page import = "DomeinModel.AutoTotaalDienst" %>
<%@ page import = "Onderdelen.Product" %>

<div class="content">

<h1>Bestelling wordt opgehaald</h1>
	<% AutoTotaalDienst atd = (AutoTotaalDienst)application.getAttribute("atdRef");%> 
	<% int id = Integer.parseInt(request.getParameter("id")); %>
	<% Product p = atd.getOnderdeelById(id); %>
	<% int type = Integer.parseInt(request.getParameter("type")); %>

	<form action="BestellingOphalenServlet.do" method="post">
			<table>
			
				<img src="images/vrachtwagen.gif"/><br><br>
				
				<b>De volgende bestelling komt binnen:</b> <br>
				<b>Productnummer:</b> "<%=p.getProductNummer()%>"<br>
				<b>Naam:</b> "<%=p.getProductNaam()%>"<br>
				<b>Aantal:</b> "<%=p.getInBestelling() %>"
				<input type="hidden" name="pId" value="<%=p.getProductNummer()%>">
				<input type="hidden" name="inBestelling" value="<%=p.getInBestelling() %>">
				<input type="hidden" name="voorraad" value="<%=p.getVoorraad() %>">
				<input type="hidden" name="type" value="<%=type%>">
			</table>
			<input type="submit" value="Haal het product op">
	</form>

</div>


<jsp:include page="footer.jsp" />