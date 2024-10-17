<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Valid</title>
</head>
<body>

<jsp:useBean id="lb" class="com.sunbeam.bean.LoginJsp" />
<jsp:setProperty name="lb" property="*" />
   
  ${ lb.compare() }
  <c:choose>
       <c:when test="${ not empty lb.cust }">
       <c:redirect url="subject.jsp" />
       </c:when>
       <c:otherwise>
         	Invalid email or password.
			<p>
				<a href="login.jsp">Login Again</a>
			</p>
       </c:otherwise>
  </c:choose>
  

</body>
</html>