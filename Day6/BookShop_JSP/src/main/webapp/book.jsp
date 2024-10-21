<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books</title>
</head>
<body>
     
     <jsp:useBean id="bb" class="com.sunbeam.bean.Book_JSP"/>
     <jsp:setProperty name="bb" property="*" />
     
      ${ bb.toString() } <br><b>
     
     ${bb.showBooks()}

    <form action="addcart.jsp" method="post">
    
    <h1>Hello</h1>
    
    <c:forEach var="bk" items="${bb.list}">
    <input type="checkbox" name="book" value="${bk.id}" /> ${bk.name} - ${bk.author} - ${bk.id} <br>
    </c:forEach> 
    <br><b>
    
    <input type="submit" value="Add Cart">
    
     </form>
     
</body>
</html>