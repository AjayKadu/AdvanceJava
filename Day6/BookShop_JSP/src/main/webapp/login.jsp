<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="loginValidate.jsp" method="post">

		<label>UserName</label> <input type="email" name="uname" /> <label>Password</label>
		<input type="password" name="passwd" /> <input type="submit"
			value="Login">

		<p>${param.message}</p>
	</form>
</body>
</html>