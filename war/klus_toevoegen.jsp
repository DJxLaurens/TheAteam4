<jsp:include page="header.jsp" />

<div class="content">
	<h1>Klus toevoegen</h1>
	<%@ page import="Onderdelen.Klus"%>
	<%@ page import="Onderdelen.Auto"%>
	<%@ page import="DomeinModel.AutoTotaalDienst"%>

	<form action="KlusToevoegenServlet.do" method="post">
	<% 
		Object msgs = request.getAttribute("msgs"); 
		if (msgs != null) { 	 
			out.println(msgs); 
			out.println(); 		
		}	%>	
		<table>
			<tr>
				<td>Klus naam:</td>
				<td><input type="text" name="klusNaam"></td>
			</tr>
			<tr>
				<td>Klus omschrijving:</td>
				<td><input type="text" name="klusOmschrijving"></td>
			</tr>
			<tr>
				<td>Kies Auto:</td>				
				<td><select name = "auto">
				<% AutoTotaalDienst atd = (AutoTotaalDienst)application.getAttribute("atdRef"); 			
				for(Auto a : atd.getAlleAutos()) {
					%><option value=<%=a.getAutoID() %>><%= a.getMerk() + " " + a.getType() %>
				<%}%></option>
				</select></td>
			</tr>
			<tr>
				<td>Datum:</td>
				<td>
				<input type="number" name="dag" min="1" max="31">
				<input type="number" name="maand" min="1" max="12">
				<input type="number" name="jaar" min="2014" max="2020"></td>
			</tr>
		</table>
		<input type="submit" value="Toevoegen">
	</form>
</div>

<jsp:include page="footer.jsp" />
