<jsp:include page="header.jsp" />

<%@ page import = "Webapp.AutoTotaalDienst" %>
<%@ page import = "Webapp.Product" %>
<%@ page import="java.util.*"%>

<div class="content">
	<h1>Minimale voorraad aanpassen</h1>
	<% AutoTotaalDienst atd = (AutoTotaalDienst)application.getAttribute("atdRef");%> 
	<% int id = Integer.parseInt(request.getParameter("id")); %>
	<% int type = Integer.parseInt(request.getParameter("type")); %>
	<% Product p = atd.getOnderdeelById(id); %>
	<form action="MinimaleVoorraadWijzigenServlet.do" method="post">
		<table>
		
			<tr>
				<td>Productnummer:</td>
				<td><%=p.getProductNummer()%></td>
			</tr>
			<tr>
				<td>Productnaam:</td>
				<td><%=p.getProductNaam()%></td>
			</tr>
			<tr>
				<td>Minimale voorraad:</td>
				<td><input type="text" name="minVoorraad" value="<%=p.getMinVoorraad()%>">
				<input type="hidden" name="onderdeelId" value="<%=p.getProductNummer()%>">
				<input type="hidden" name="type" value="<%=type%>"></td>
			</tr>
		</table>

		<input type="submit" value="Wijzig">
	</form>
</div>

<jsp:include page="footer.jsp" />
