
<jsp:include page="header.jsp" />

<div class="content">
	<form action="FactuurbetalingBlokkeren.do" method="get">
		<div class="left">
			<h1>Herinneringsbrieven</h1>

			<h2>Factuurbetaling blokkeren voor klant</h2>

			<h4>Klanten die na 90 dagen nog niet betaald hebben:</h4>

			<div>
				<select name="klantveld">
<<<<<<< HEAD
				<% if(atd.getblokkade().size() == 0){
				for(Gebruiker g : atd.getAlleKlantenBlok()){ %>
					<option value="<%= g.getNaam() %>"><%= g.getNaam() %></option>
				<%}
			}
			else{
				for(Gebruiker g : atd.getblokkade()){ %>
				<option value="<%= g.getNaam() %>"><%= g.getNaam() %></option>
			<%}			
			}%>
=======
					<option value="piet">Piet</option>
>>>>>>> branch 'master' of https://github.com/DJxLaurens/TheAteam4.git
				</select>
			</div>

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
				<p>- Er moeten nog aantal factuurbetaling(en) geblokkeerd worden
				
				<p>
			</div>

		</div>
	</form>

</div>

<jsp:include page="footer.jsp" />
