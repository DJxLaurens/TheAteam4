<jsp:include page="header.jsp" />

<div class="content">
	<h1>Klus toevoegen</h1>
	
	<%
		Object msgs = request.getAttribute("msgs");
		if (msgs != null) {
			out.println(msgs);
			out.println();
		}
	%>
	
	<form action="KlusToevoegenServlet.do" method="post">
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
				<td><select><option value="BMW M3 GTR" name="auto">BMW M3 GTR</option>
				</select></td>
			</tr>
		</table>
		<input type="submit" value="Toevoegen">
	</form>
</div>

<jsp:include page="footer.jsp" />
