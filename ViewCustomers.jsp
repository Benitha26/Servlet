<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.* , com.quinnox.basics.dao.*, com.quinnox.basics.model.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/Newcss1.css"/>
</head>
<body>
	<h1>Customers List</h1>
	<div align="center"><img alt="image" src="images/image3.gif" width="10%" height="10%"></div>
	<% List<Customer> list=CustomerDAO.getAllEmployees(); %>
	<div class="test">
	<table border=1>
	<tr>
		<th>Customer Id</th>
		<th>Customer Name</th>
		<th>Password</th>
		<th>Email</th>
		<th>Country</th>
		<th>Edit</th>
		<th>Delete</th>
	</tr>
	<% for(Customer i:list){ %>
	<tr>
		<td><%=i.getId() %></td>
		<td><%=i.getName() %></td>
		<td><%=i.getPassword() %></td>
		<td><%=i.getEmail() %></td>
		<td><%=i.getCountry() %></td>
		<td><a href='EditCustomer.jsp?id=<%=i.getId() %>'>Edit</a></td>
		<td><a href='DeleteServlet?id=<%=i.getId() %>'>Delete</a></td>
	</tr>
	<% } %>
	</table>
	</div>
</body>
</html>