<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book List</title>
</head>
<body>
	<h2>All the Books</h2>
	<table border="1">
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Author</th>
				<th>Subject</th>
				<th>Price</th>
				<th>Action</th>
			</tr>
		</thead>
		<c:forEach var="b" items="${bookList}">
			<tr>
				<td>${b.id}</td>
				<td>${b.name}</td>
				<td>${b.author}</td>
				<td>${b.subject}</td>
				<td>${b.price}</td>
				<td>
					<a href="editbook?id=${b.id}">
						<img src="Images/edit.png" alt="Edit" width="24" height="24"/>
					</a>
					<a href="delbook?id=${b.id}">
						<img src="Images/delete.png" alt="Delete" width="24" height="24"/>
					</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	
	<p>
		<a href="addbook">Add New Book</a>
	</p>
	
	<p>
		<a href="logout">Sign Out</a>
	</p>

</body>
</html>