<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product</title>
</head>
<body>
	<table>
		<form action="ProductServlet" method="post">
			ID PRODUCT <input type="text" name="productId"/>
			<br/>
			NAME PRODUCT <input type="text" name="nameProduct"/>
			<input type="submit" value="Submit"/>		
		</form>
		<br/>
		<form action="Menu" method="get">
			<input type="submit" value="Kembali" /> 
		</form>
	</table>
</body>
</html>