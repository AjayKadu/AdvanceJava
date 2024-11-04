<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Director</title>
</head>
<body>

<form action="adddir" method="Post">

    <label>Director Name</label>
      <input type="text" name="name"> <br><br>
      
      <label>Email</label>
      <input type="email" name="email"><br><br>
      
        <label>DOB</label>
      <input type="date" name="date"><br><br>
      
        <label>Password</label>
      <input type="password" name="password"><br><br>
      
       <input type="submit" value="Add Director">
       
       </form>
</body>
</html>