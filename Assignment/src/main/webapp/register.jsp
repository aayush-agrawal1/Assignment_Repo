<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Page</title>


</head>
<body>
	<p><font color=red size=5>Registration Page</font></p>
	<form action="RegistrationServlet" method="post">
	<table border="6">
		<tr>
			<td>Name</td><td><input type=text id="n1" name=nm required ></td>
		</tr>
		<tr>
			<td>Password</td><td><input type=password name=pass maxlength=8 minlength=3></td>
		</tr>
		<tr>
			<td>Email</td><td><input type=email name=em id="em1"><div id="rr1"></div></td>
		</tr>
		<tr>
			<td>Address</td><td><input type=text name=ad></td>
		</tr>
		
		<tr>
			<td><input type="Submit" value=SignUp id="b" ></td><td><input type=reset></td>
		</tr>
	</table>
	</form>
	<br>
	<%= request.getAttribute("result") %>
</body>
</html>