<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Movie List</title>
</head>
<body>

 <h3>${loginUser.username}</h3>


	<table border="1">
		<thead>
			<tr>
				<th>Movie_id</th>
				<th>M_Name</th>
				<th>Actor</th>
				<th>Actress</th>
				<th>Rating</th>
				<th>Action</th>
			</tr>
		</thead>


		<tbody>
			<c:forEach var="dl" items="${ movieList }">
				<tr>
					<td>${dl.m_id}</td>
					<td>${dl.movie_name}</td>
					<td>${dl.actor}</td>
					<td>${dl.actress}</td>
					<td>${dl.rating}</td>
					<td>Update | Delete</td>
				</tr>
			</c:forEach>
		</tbody>

	</table>
	
	<a href="addmovie">Add Movie</a>
	<a href="logout">Logout</a>
</body>
</html>