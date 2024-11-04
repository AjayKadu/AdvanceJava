<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Director List</title>
</head>
<body>

	<h3>${loginUser.username}</h3>


	<table border="1">
		<thead>
			<tr>
				<th>id</th>
				<th>User Name</th>
				<th>Email</th>
				<th>DOB</th>
				<th>Password</th>
				<th>Action</th>
			</tr>
		</thead>


		<tbody>
			<c:forEach var="dl" items="${ directorList }">
				<tr>
					<td>${dl.u_id}</td>
					<td>${dl.username}</td>
					<td>${dl.email}</td>
					<td>${dl.date}</td>
					<td>${dl.password}</td>
					<td>
					<a href="update?id=${dl.u_id}">Update</a> 
					<a href="delete?id=${dl.u_id}">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>

	<a href="adddir">Add Director</a>
	<a href="logout">Logout</a>
</body>
</html>