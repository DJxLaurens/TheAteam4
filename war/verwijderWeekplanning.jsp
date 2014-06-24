<jsp:include page="header.jsp" />

<%@ page import = "DomeinModel.AutoTotaalDienst" %>
<%@ page import = "Onderdelen.Product" %>
<%@ page import = "Onderdelen.Weekplanning" %>
<%@ page import="java.util.*"%>

<div class="content">
	<h1>Minimale voorraad aanpassen - Onderdelen</h1>
	<% AutoTotaalDienst atd = (AutoTotaalDienst)application.getAttribute("atdRef");%> 
	<% int id = Integer.parseInt(request.getParameter("id")); %>
	<% Weekplanning w = atd.getWeekplanningById(id); %>
	<form action="VerwijderWeekplanningServlet.do" method="post">
		<table>
			<b>Weet u zeker dat u de klus met klusNummer "<%=w.getId() %>" wilt verwijderen uit de weekplanning?</b>
			<input type="hidden" name="wId" value="<%=w.getId() %>"/>
		</table>
		<input type="submit" value="Verwijder uit de weekplanning">
	</form>
</div>

<jsp:include page="footer.jsp" />
