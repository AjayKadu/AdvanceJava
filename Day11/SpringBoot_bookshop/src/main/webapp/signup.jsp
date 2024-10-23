<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Customer</title>
</head>
<body>

<form action="signup" method="post">
        <label>Name</label>
        <input type="text" name="name"> <br><br>
        <label>email</label>
        <input type="email" name="email"><br><br>
        <label>Password</label>
        <input type="password" name="Password"><br><br>
        <label>mobile</label>
        <input type="text" name="mobile"><br><br>
        <label>address</label>
        <input type="text" name="address"><br><br>
        <label>birth</label>
        <input type="text" name="birth"><br><br>
        
    <input type="submit" value="Sign Up"><br><br>
        
    </form>

    <p>Already have an account? <a href="index">Login here</a></p>

</body>
</html>