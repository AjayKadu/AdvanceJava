<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books</title>
</head>
<body>

<h1>Books of Subject</h1>

	<form action="addcart" method="post">

		<c:forEach var="bk" items="${bookList}">
			<input type="checkbox" name="book" value="${bk.id}" /> ${bk.name} - ${bk.author}-${bk.id}<br>
		</c:forEach> <br>

   <input type="submit" value="Add Cart" />

	</form>


</body>
</html>