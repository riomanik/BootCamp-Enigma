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
			Order ID <input type="text" name="productId"/>
			<br/>
			Pilih Product <input type="text" name="nameProduct"/>
			<br/>
			Quantity <input type="text" name="nameProduct"/>
			<input type="submit" value="Submit"/>		
		</form>
		<br/>
		<form action="Menu" method="get">
			<input type="submit" value="Kembali" /> 
		</form>
	</table>
	<br/>
	<table border="1">
		<br/>
		<thead>
			<tr>
				<th>Order Id</th>
				<th>Product</th>
				<th>Quantity</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
		<%
			List<Order> listOrder = (List<Order>) request.getAttribute("listOrder");
			for(Order order : listOrder){
		%>
			<tr>
				<td><%=order.getOrderid()%></td>
				<td><%=order.getOrderproduct()%></td>
				<td><%=order.getQuantity%></td>
				<td>Edit,Delete</td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>