<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
	<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=iso-8859-1" />
		<link rel="stylesheet" type="text/css" href="design.css" />
		<title>Practicum 2</title>
	</head>
	<body background = "model.jpg">
		<form action="LoginServlet.do" method="post">		
			<div id="form"> 			
			<h1>Login</h1>
			<% 
				Object msgs = request.getAttribute("msgs"); 
				if (msgs != null) { 	 
					out.println(msgs); 
					out.println(); 		
				}					
			%>	      
				<div>		
					<label>Usernames:</label> 
					<input type="text" name="username" />
				</div>
				<div>
					<label>Password:</label>
					<input type="password" name="password" />
				</div>
				<div>
				<input type="submit" value="Submit"/>
				<a href="signup.jsp">Sign up</a>
				</div>			
			</div>
		</form>	
	</body>
</html>