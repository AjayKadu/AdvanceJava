<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
</head>
<body>

	<jsp:useBean id="dd" class="com.sunbeam.bean.Registration_JSP" />
	<jsp:setProperty name="dd" property="*" />

	 String message = ${dd.registration()}
	 request.setAttribute("message", message);
	 
	  <jsp:forward page="login.jsp">
    	<jsp:param name="message" value="${message}"/>
    </jsp:forward>
	 
	

</body>
</html>