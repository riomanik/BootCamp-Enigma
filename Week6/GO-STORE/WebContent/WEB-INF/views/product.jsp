<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>

<%@ page import="com.enigma.hellostore.model.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ProductServlet" method="post">
	Product Id	&emsp;&emsp;:<input type="text" name="productId" /><br/><br/>
	Product Name&nbsp;&nbsp;&nbsp;:<input type="text" name="productName" /><br/> <br/>
	    <input type = "submit" value = "submit" />
	</form>
	<br>
	<br>
	<table border="1">
		<thead>
			<tr>
				<th>kode</th>
				<th>Nama</th>
			</tr>
		</thead>
		<tbody>
			<%
				List<Product> listItem = (List<Product>) request.getAttribute("products");
				for (Product product : listItem){
				%>
				<tr>
					<td><%=product.getProductid() %></td>
					<td><%=product.getProductname() %></td>
				</tr>
				<%
				}
				%>		
		</tbody>
	</table>
</body>
</html>