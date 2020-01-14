<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>

<%@ page import="com.enigma.mahasiswa.model.Mahasiswa"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="MahasiswaServlet" method="post">
	Mahasiswa Id	&emsp;&emsp;:<input type="text" name="MahasiswaId" /><br/><br/>
	Mahasiswa Name&nbsp;&nbsp;&nbsp;:<input type="text" name="MahasiswaName" /><br/> <br/>
	    <input type = "submit" value = "submit" />
	</form>
	<br/>
	<br/>
	<form action="MahasiswaServlet" method="post">
	ID MAHASISWA	&emsp;&emsp;:<input type="text" name="idDel" /><br/><br/>
	<br/>
	    <input type = "submit" value = "Delete" />
	</form>
	<br/>
	<br/>
	<form action="MahasiswaServlet" method="post">
	ID PRIMER YANG INGIN DIRUBAH	&emsp;&emsp;:<input type="text" name="UpdtPr" /><br/><br/>
	ID	&emsp;&emsp;:<input type="text" name="UpdtId" /><br/><br/>
	NAMA	&emsp;&emsp;:<input type="text" name="UpdtName" /><br/><br/>
	<br/>
	    <input type = "submit" value = "Update" />
	</form>
	<br>
	<br>
	<table border="1">
		<thead>
			<tr>
				<th>ID PRIMER</th>
				<th>ID MAHASISWA</th>
				<th>NAMA</th>
			</tr>
		</thead>
		<tbody>
			<%
				List<Mahasiswa> listItem = (List<Mahasiswa>) request.getAttribute("listMhs");
					for (int i=0 ; i < listItem.size() ; i++){
			%>
				<tr>
					<td><%=(i)%>
					<td><%=listItem.get(i).getId() %></td>
					<td><%=listItem.get(i).getFullname() %></td>
				</tr>
				<%
				}
				%>		
		</tbody>
	</table>
</body>
</html>