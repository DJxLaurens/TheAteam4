<jsp:include page="header.jsp" />

<div class="content">
	<h1>Weekplanning</h1>
	<%@ page import = "java.util.*" %>
	<%@ page import = "Webapp.Klus" %>
	<%@ page import = "Webapp.AutoTotaalDienst" %>
	<%@ page import = "Webapp.Dbconnectie" %>
	<form>
		<table>
			<tr>
				<td>Klus:</td>
				<td>Monteur:</td>
				<td>Auto:</td>
				<td>Datum:</td>
			</tr>
			
			<% Dbconnectie db = new Dbconnectie();
			db.leesDatabase();
			AutoTotaalDienst atd = new AutoTotaalDienst();
			for(Klus k : atd.getAlleKlussen()){ %>
			<tr>
				<td><%= k.getKlusNaam()  %></td>
				<td><%= k.getWerknemerId() %></td>
				<td><%= k.getAutoId()  %></td>
				<td><%= k.getAlleData().get(0)  %></td>
				<td><input type="text" name="aantal"> </td>
			</tr>
			<% }%>
		</table>
		<table>
			<tr>
				<td>Selecteer klus:</td>
				<td><select><option value="klus">Banden
							vervangen</option></select></td>
			</tr>
			<tr>
				<td>Datum:</td>
				<td><input type="text" name="dag"> - <input type="text"
					name="maand"> - <input type="text" name="jaar"></td>
			</tr>
			<tr>
				<td>Selecteer Monteur:</td>
				<td><select><option value="monteur">Klaas
							vaak</option></select></td>
			</tr>

		</table>
		<input type="submit" value="Toevoegen">
	</form>
</div>

<jsp:include page="footer.jsp" />
