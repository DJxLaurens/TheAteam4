<jsp:include page="header.jsp" />

<%@ page import = "DomeinModel.AutoTotaalDienst" %>
<%@ page import = "Onderdelen.Product" %>
<%@ page import="java.util.*"%>

<div class="content">
	<h1>Minimale voorraad aanpassen - Onderdelen</h1>
	<% AutoTotaalDienst atd = (AutoTotaalDienst)application.getAttribute("atdRef");%> 
	<% int id = Integer.parseInt(request.getParameter("id")); %>
	<% int type = Integer.parseInt(request.getParameter("type")); %>
	<% Product p = atd.getOnderdeelById(id); %>
	<form action="VerwijderVoorraadServlet.do" method="post">
		<table>
			<b>Weet u zeker dat u het product "<%=p.getProductNaam()%>" met productnummer "<%=p.getProductNummer()%>" wilt verwijderen?</b>
			<input type="hidden" name="pId" value="<%=p.getProductNummer()%>">
			<input type="hidden" name="type" value="<%=type%>">
		</table>
		<input type="submit" value="Verwijder het product">
	</form>
</div>

<jsp:include page="footer.jsp" />
