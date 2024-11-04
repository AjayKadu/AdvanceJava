<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Movie</title>
</head>
<body>

<form action="addmovie" method="Post">

    <label>Movie Name</label>
      <input type="text" name="movie_name"> <br><br>
      
      <label>Actor</label>
      <input type="text" name="actor"><br><br>
      
        <label>Actress</label>
      <input type="text" name="actress"><br><br>
      
        <label>Rating</label>
      <input type="text" name="rating"><br><br>
      
       <input type="submit" value="Add Movie">
       
       </form>
</body>
</html>