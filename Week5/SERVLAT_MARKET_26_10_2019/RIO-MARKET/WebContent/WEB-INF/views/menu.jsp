<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Menu</title>
</head>
<body>
	<table>
		<form action="ProductServlet" method="get">
			<input type="submit" value="Add Product" />	
		</form>
		<br/>
		<br/>
		<form action="ListServlet" method="get">
			<input type="submit" value="List Product" />
		</form>
	</table>
</body>
</html>