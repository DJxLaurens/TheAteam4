
<jsp:include page="header.jsp" />

<div class="content">
<form action="BrievenAanmaken.do" method="get">
	<div class="left">
	<h1>Herinneringsbrieven</h1>
	
	<h2>Brieven aanmaken</h2>

	<h4>Klanten die nog niet betaald hebben binnen 90 dagen:</h4>

	<div>
		<select>
			<option value="leeg"></option>
			<option value="klaas">Klaas</option>
			<option value="piet">Piet</option>
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

	<p>- Er moeten nog aantal brieven aangemaakt worden<p>

</form>
</div>

</div>

<jsp:include page="footer.jsp" />