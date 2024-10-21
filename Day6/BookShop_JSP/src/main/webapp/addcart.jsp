<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    
    <jsp:useBean id="ab" class="com.sunbeam.bean.AddCart_JSP" scope="session"/>
    <jsp:setProperty property="bookIds" name="ab" param="book"/>
    
    ${ab.toString()}
    ${ ab.addCarts()}
    <jsp:forward page="subject.jsp">
    	<jsp:param name="cart_count" value="${ab.list.size()}"/>
    </jsp:forward>
        
</body>
</html>