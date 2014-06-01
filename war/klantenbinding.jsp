<jsp:include page="header.jsp" />

<div class="content">
<div class="left">
	<%@ page import="Webapp.Gebruiker"%>
	<%@ page import="Webapp.Auto"%>
	<%@ page import="Webapp.AutoTotaalDienst"%>
	<%@ page import="Servlet.KlantenbindingServlet" %>
<form action="KlantenbindingServlet.do" method="get">
	<% AutoTotaalDienst atd = (AutoTotaalDienst)application.getAttribute("atdRef"); %>
	<h1>Herinneringsbrieven</h1>
	
	<h2>Klantenbinding</h2>

	<h4>Klanten met auto's jonger dan 2010 die een onderhoudsbeurt
		nodig hebben:</h4>
    
	<div>
		<select name="veld1">
			<option value="leeg"></option>
			<% if(atd.getjongerdan().size() == 0){
				for(Gebruiker g : atd.getAlleKlantenJongerDan2010()){ %>
					<option value="<%= g.getNaam() %>"><%= g.getNaam() %></option>
				<%}
			}
			else{
				for(Gebruiker g : atd.getjongerdan()){ %>
				<option value="<%= g.getNaam() %>"><%= g.getNaam() %></option>
			<%}			
			}%>
		</select>
	</div>



	<h4>Klanten met auto's ouder dan 2010 die een onderhoudsbeurt
		nodig hebben:</h4>

	<div>
		<select name="veld2">
			<option value="leeg"></option>
			<% if(atd.getouderdan().size() == 0){
				for(Gebruiker g : atd.getAlleKlantenOuderDan2010()){ %>
					<option value="<%= g.getNaam() %>"><%= g.getNaam() %></option>
				<%}
			}
			else{
				for(Gebruiker g : atd.getouderdan()){ %>
				<option value="<%= g.getNaam() %>"><%= g.getNaam() %></option>
			<%}			
			}%>
		</select>
	</div>

	<h4>Klanten die langer dan 2 maanden niet aanwezig zijn geweest:</h4>

	<div>
		<select name="veld3">
			<option value="leeg"></option>
			<% if(atd.getafwezig().size() == 0){
				for(Gebruiker g : atd.getAlleKlantenLaatstgeweest()){ %>
					<option value="<%= g.getNaam() %>"><%= g.getNaam() %></option>
				<%}
			}
			else{
				for(Gebruiker g : atd.getafwezig()){ %>
				<option value="<%= g.getNaam() %>"><%= g.getNaam() %></option>
			<%}			
			}%>
		</select>
	</div>

	</br>

	<input type="submit" value="Brieven aanmaken" name="press" /> 

</div>

<div class="right">
	<%@ page import="java.util.Calendar"%>
	<%! Calendar now = Calendar.getInstance(); %>
	<%
		int day = now.get(Calendar.DATE);
		int month = now.get(Calendar.MONTH) + 1;
		int year = now.get(Calendar.YEAR);
		String s = day + "-" + month + "-" + year;
		%>
	</br> </br>
	<%= s %>

	<h1>Brievenoverzicht</h1>
	<div class="box">
		<p>- Er moeten nog 
		
		<%
		int x = atd.getjongerdan().size() + atd.getouderdan().size() + atd.getafwezig().size();
		out.println(x);
		%>
		
		brieven aangemaakt worden<p>
	</div>
	<div class="box1">
		<table width="410px">
			<tr>
				<td>Hoeveelheid brieven</td>
				<td>Type brief</td>
			</tr>
			<tr>
				<td>
				<%
				int y = atd.getjongerdan().size() + atd.getouderdan().size();
				out.println(y);
				%>
				</td>
				<td>Onderhoudsbrief</td>
			</tr>
			<tr>
				<td>
				<%
				int z = atd.getafwezig().size();
				out.println(z);
				%>
				</td>
				<td>Afwezigheidsbrief</td>
			</tr>
		</table>
	</div>
</form>

</div>
</div>

<jsp:include page="footer.jsp" />