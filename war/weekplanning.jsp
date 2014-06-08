<jsp:include page="header.jsp" />

<div class="content">
	<h1>Weekplanning</h1>
	<%@ page import="Onderdelen.Klus"%>
	<%@ page import="Onderdelen.Monteur"%>
	<%@ page import="DomeinModel.AutoTotaalDienst"%>
	<form action ="WeekplanningServlet.do" method = "post">
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
				<td><%= k.getKlusNaam()  %></td>
				<td><%= k.getWerknemerId() %></td>
				<td><%= k.getAutoId()  %></td>
				<td>0</td>
				<td><input type="text" name="aantal"></td>
			</tr>
			<% }%>
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
							for(Monteur m : atd.getAlleMonteurs()) {
						%>
						<option value=monteur><%=m.getNaam()%>
						</option>
						<%
							}
						%>
				</select></td>
			</tr>

		</table>
		<input type="submit" value="Toevoegen">
	</form>
</div>

<jsp:include page="footer.jsp" />
