<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>

	<form action="registration.jsp" method="post">

		<label> ID: </label> 
		<input type="text" name="id"> <br><br> 
		
		<label> Name: </label>
		<input type="text" name="name"> <br><br> 
		
		<label> Password: </label>
		<input type="password" name="password"> <br><br>
		
		<label> Mobile No: </label> 
		<input type="text" name="mobile"> <br><br> 
		
		<label> Address: </label> 
		<textarea rows="5" cols="9" name="address"></textarea> <br><br> 
		
		<label> Email: </label> 
		<input type="email" name="email"> <br><br> 
		
		<label> Birth Date: </label> 
		<input type="text" name="birth" placeholder="yyyy-mm-dd"> <br><br>
		
		
		<input type="submit" value="Sign up">

	</form>

</body>
</html>