<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
	<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
		<link rel="stylesheet" type="text/css" href="design.css" />
		<title>Practicum 2</title>
	</head>
	<body background = "model.jpg">
		<form action="RegisterServlet.do" method="post">		
			<div id="form"> 		
			<h1>Sign in</h1>	
	            <% 
	                Object msgs = request.getAttribute("msgs"); 
	                if (msgs != null) { 
	                        out.println(msgs); 
	                        out.println(); 
	                }			
	            %>
	            <div>		
	                    <label>Naam:</label> 
	                    <input type="text" name="username" />
	            </div>
	            <div>
	                    <label>Adres:</label>
	                    <input type="text" name="address" />
	            </div>
	            <div>
	                    <label>Wachtwoord:</label>
	                    <input type="password" name="password" />
	            </div>
	            <div>
	                    <label>Bevestig wachtwoord:</label>
	                    <input type="password" name="password2" />
	            </div>
	            <div>
	                    <label>E-mail:</label>
	                    <input type="text" name="email" />
	            </div>
	            <div>
	                    <label>Bevestig E-mail:</label>
	                    <input type="text" name="email2" />
	            </div>
	            <div>
		            <input type="submit" value="Submit"/>
		            <a href="login.jsp">Login</a>
	            </div>
			</div>
		</form>
	</body>
</html>