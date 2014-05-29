<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" type="text/css" href="design.css" />
<title>Registreren</title>
</head>
<body background="model.jpg">
	<form action="RegistreerServlet.do" method="post">
		<div id="form">
			<h1>Registreer</h1>
			<%
				Object msgs = request.getAttribute("msgs");
				if (msgs != null) {
					out.println(msgs);
					out.println();
				}
			%>
			<div>
				<label>Naam:</label> <input type="text" name="naam" />
			</div>
			<div>
				<label>Wachtwoord:</label> <input type="password" name="wachtwoord" />
			</div>
			<div>
				<label>Bevestig wachtwoord:</label> <input type="password"
					name="wachtwoord2" />
			</div>
			<div>
				<label>Adres:</label> <input type="text" name="adres" />
			</div>
			<div>
				<label>Postcode:</label> <input type="text" name="postcode" />
			</div>
			<div>
				<label>Woonplaats:</label> <input type="text" name="woonplaats" />
			</div>
			<div>
				<label>Telefoonnummer:</label> <input type="text"
					name="telefoonnummer" />
			</div>
			<div>
				<label>Emailadres:</label> <input type="text" name="emailadres" />
			</div>
			<div>
				<label>Bevestig emailadres:</label> <input type="text"
					name="emailadres2" />
			</div>
			<div>
				<select name="rol_id">
					<option value="1">Administrateur</option>
					<option value="2">Bedrijfsleider</option>
					<option value="3">Kassamedewerker</option>
					<option value="4">Klant</option>
					<option value="5">Magazijn</option>
					<option value="6">Planner</option>
					<option value="7">Monteur</option>
				</select>
			</div>
			<div>
				<input type="submit" value="Registreer" /> <a href="login.jsp">Login</a>
			</div>
		</div>
	</form>
</body>
</html>