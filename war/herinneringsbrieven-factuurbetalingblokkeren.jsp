
<jsp:include page="header.jsp" />

<div class="content">
	<%@ page import="Onderdelen.Gebruiker"%>
	<%@ page import="Onderdelen.Auto"%>
	<%@ page import="DomeinModel.AutoTotaalDienst"%>
	<%@ page import="KlantenbindingServlets.KlantenbindingServlet" %>
	<form action="FactuurbetalingBlokkeren.do" method="post">
	<% AutoTotaalDienst atd = (AutoTotaalDienst)application.getAttribute("atdRef"); %>
		<div class="left">
			<h1>Herinneringsbrieven</h1>

			<h2>Factuurbetaling blokkeren voor klant</h2>

			<h4>Klanten die na 90 dagen nog niet betaald hebben:</h4>

			<div>
				<select name="klantveld">
					<option value="leeg">Kies een klant</option>
				<% for(Gebruiker g : atd.getblokkade()){ %>
					<option value="<%= g.getGebruikerID() %>" name="blokkadeId"><%= g.getNaam() %></option>
				<%}%>
	
				</select>
			</div>
			<br/>
			<input type="submit" value="Betaling blokkeren" name="press" />

		</div>

		<div class="right">

			<%@ page import="java.util.Calendar"%>
			<%!Calendar now = Calendar.getInstance();%>
			<%
				int day = now.get(Calendar.DATE);
				int month = now.get(Calendar.MONTH) + 1;
				int year = now.get(Calendar.YEAR);
				String s = day + "-" + month + "-" + year;
			%>
			<%=s%>

			<h1>Factuuroverzicht</h1>
			<div class="box">
				<p>- Er moeten nog aantal 
				<%
				int x = atd.getblokkade().size();
				out.println(x);
				%>
				
				factuurbetaling(en) geblokkeerd worden
				
				<p>
			</div>

		</div>
	</form>

</div>

<jsp:include page="footer.jsp" />