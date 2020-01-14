<%@page import="java.util.List" %>
<%@page import="com.enigma.riomarket.model.Product" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Product</title>
</head>
<body>
	<table border="1">
		<form action="ListServlet" method="get">
		ID <input type="text" name="idList"/>		
		</form>
		<br/>
		<thead>
			<tr>
				<th>Id Product</td>
				<th>Nama Product</td>
			</tr>
		</thead>
		<tbody>
		<%
			List<Product> listProduct = (List<Product>) request.getAttribute("listProduct");
			for(Product product : listProduct){
		%>
			<tr>
				<td><%=product.getProductid()%></td>
				<td><%=product.getProductname()%></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
		<br/>
		<form action="Menu" method="get">
		<input type="submit" value="Kembali Ke Menu"/>
		</form>
</body>
</html>