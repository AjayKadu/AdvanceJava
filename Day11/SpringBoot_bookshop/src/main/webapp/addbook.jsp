<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>
</head>
<body>
	<h2>Add New Book</h2>
	
	<form method="post" action="addbook">
		Id: <input type="text" name="id"/> <br/><br/>
		Name: <input type="text" name="name"/> <br/><br/>
		Author: <input type="text" name="author"/> <br/><br/>
		Subject: <input type="text" name="subject"/> <br/><br/>
		Price: <input type="text" name="price"/> <br/><br/>
		<input type="submit" value="Add Book"/>
		<p>
			<a href="booklist">Back</a>
		</p>
	</form>
</body>
</html>

