<jsp:include page="header.jsp" />
<%@ page import="java.util.*"%>
<%@ page import = "DomeinModel.AutoTotaalDienst" %>
<%@ page import = "Onderdelen.Product" %>

<div class="content">

<h1>Bestelling wordt opgehaald</h1>
	<% AutoTotaalDienst atd = (AutoTotaalDienst)application.getAttribute("atdRef");%> 
	<% int id = Integer.parseInt(request.getParameter("id")); %>
	<% Product p = atd.getOnderdeelById(id); %>

	<form action="BestellingOphalen.do" method="post">
			<table>
				<b>De volgende bestelling komt binnen:</b> <br>
				<b>Productnummer:</b> "<%=p.getProductNummer()%>"<br>
				<b>Naam:</b> "<%=p.getProductNaam()%>"<br>
				<b>Aantal:</b> "<%=p.getInBestelling() %>"
				<input type="hidden" name="pId" value="<%=p.getProductNummer()%>">
			</table>
			<input type="submit" value="Verwijder het product">
	</form>

</div>


<jsp:include page="footer.jsp" />