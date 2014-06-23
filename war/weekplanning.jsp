<jsp:include page="header.jsp" />

<div class="content">
	<h1>Weekplanning</h1>
	<%@ page import="Onderdelen.Klus"%>
	<%@ page import="Onderdelen.Gebruiker"%>
	<%@ page import="Onderdelen.Auto"%>
	<%@ page import="DomeinModel.AutoTotaalDienst"%>
	<form action="WeekplanningServlet.do" method="post">
		<% 
		Object msgs = request.getAttribute("msgs"); 
		if (msgs != null) { 	 
			out.println(msgs); 
			out.println(); 		
		}		
		%>
		<table>
			<tr>
				<td>Klus:</td>
				<td>Monteur:</td>
				<td>Auto:</td>
				<td>Datum:</td>
			</tr>
			<% AutoTotaalDienst atd = (AutoTotaalDienst)application.getAttribute("atdRef"); 
			
			for(Klus k : atd.getAlleKlussen()) { %>
			<tr id="headRow">
				<td><%if(atd.getAlleKlussen().size() > 0){ 
					out.println(k.getKlusNaam()); 
					}%></td>
				<td><%if(k.getAlleMonteurs().size() > 0){ 
					out.println(k.getAlleMonteurs().get(0)); 
					}else{
					out.println("onbekend"); }%></td>
				<td><%if(k.getAlleAutos().size() > 0){ 
					out.println(k.getAlleAutos().get(0)); 
					System.out.println(k.getAlleAutos());
					}else{
					out.println("onbekend"); }%></td>
				<td><%if(k.getAlleData().size() > 0){ 
					out.println(k.getAlleData().get(0)); 
					}else{
					out.println("onbekend"); }%></td>
			</tr>
			<%}%>
		</table>
		<table>
			<tr>
				<td>Selecteer klus:</td>
				<td><select>
						<%
				for(Klus k : atd.getAlleKlussen()) {
					if(k.getWerknemerId() == 0){ %>
						<option value=klus><%=k.getKlusNaam()%>
						</option>
						<%
					}
				}%>
				</select></td>
			</tr>
			<tr>
				<td>Datum:</td>
				<td><input type="text" name="dag"> - <input type="text"
					name="maand"> - <input type="text" name="jaar"></td>
			</tr>
			<tr>
				<td>Selecteer Monteur:</td>
				<td><select>
					<%
					for(Gebruiker g : atd.getAlleMonteurs()) {
						if(g.getRol() == 4){
						%><option value=<%= g.getNaam() %>><%= g.getNaam() %>
					<%}
					}%></option>
				</select></td>
			</tr>

		</table>
		<input type="submit" value="Toevoegen">
	</form>
</div>

<jsp:include page="footer.jsp" />
