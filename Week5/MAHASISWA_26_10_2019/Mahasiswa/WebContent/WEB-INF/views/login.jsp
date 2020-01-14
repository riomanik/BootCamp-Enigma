<%@ page import="java.util.Calendar" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	Current Time:
	<%= Calendar.getInstance().getInstance() %>
	<table>
		<form action="Login" method="post">
			Username : <input type="text" name="userName" /> <br/>
			Password : <input type="password" name="userPassword"/> <br/>
			<input type="submit" value="submit" />			
		</form>
	</table>
</body>
</html>