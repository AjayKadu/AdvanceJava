<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Cart</title>
</head>
<body>

	
	<h2>Shopping Cart</h2>
	<c:set var="total" value="0.0"/>
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Author</th>
				<th>Subject</th>
				<th>Price</th>
			</tr>
		</thead>
	<tbody>
		<c:forEach var="b" items="${ab.list}">
			<tr>
				<td>${b.id}</td>
				<td>${b.name}</td>
				<td>${b.author}</td>
				<td>${b.subject}</td>
				<td>${b.price}</td>
				<c:set var="total" value="${total + b.price}" />
			</tr>
			<c:set var="total" value="${total + b.price}" />
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<th colspan="5" align="right">Total Bill: Rs. ${total} /-</th>
		</tr>
	</tfoot>
	</table>
	<p>
		<a href="logout.jsp">Sign Out</a>
	</p>
</body>
</html>