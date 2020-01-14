<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Current Time:
	<%= Calendar.getInstance().getTime() %>
	<form action="LoginServlet" method="post">
		userName&emsp;&emsp;: <input type="text" name="userName" /> <br />
		userPassword&nbsp;&nbsp;: <input type="text" name="userPassword">
		<br> <input type="submit" value="submit" />
	</form>

</body>
</html>