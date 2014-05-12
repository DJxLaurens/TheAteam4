
<jsp:include page="header.jsp" />

<div class="content">
<form action="Klantenbinding.do" method="get">
	<h1>Herinneringsbrieven</h1>
	
	<h2>Factuurbetaling blokkeren voor klant</h2>

	<h4>Klanten die na 90 dagen nog niet betaald hebben:</h4>

	<div>
		<select>
			<option value="piet">Piet</option>
		</select>
	</div>

	</br>

	<input type="submit" value="Betaling blokkeren" name="press" /> <input
		type="submit" value="Terug" name="press" />

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

	<h1>Factuuroverzicht</h1>
	
	<p>- Er moeten nog aantal factuurbetaling(en) geblokkeerd worden<p>
	
</form>

</div>

<jsp:include page="footer.jsp" />