<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Category List</title>
</head>
<body>

    <h1>Categories</h1>

    <!-- Table to display categories -->
    <form action="index" method="get">
        <input type="submit" value="Show Categories">
    </form>

    <table border="1" cellpadding="5" cellspacing="0">
        <thead>
            <tr>
                <th>ID</th>
                <th>Title</th>
                <th>Description</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="category" items="${catList}">
                <tr>
                    <td>${category.id}</td>
                    <td>${category.title}</td>
                    <td>${category.description}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</body>
</html>
