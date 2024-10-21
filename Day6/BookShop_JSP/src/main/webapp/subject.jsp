<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Subject</title>
</head>
<body>
       
       <jsp:useBean id="sb" class="com.sunbeam.bean.Subject_JSP" />
 
       ${ sb.showSubjects()}
       
       <form action="book.jsp" method="post">
       
       <c:forEach var="sub" items="${sb.list}">
            <input type=radio name="subject" value="${sub}"/> ${sub} <br>
       </c:forEach>
        
        <input type="submit" value="Show Books">
       
       </form>
  
         <p>
         <a href="showcart.jsp">show cart (${param.cart_count})</a>
         </p>     
       
       
</body>
</html>