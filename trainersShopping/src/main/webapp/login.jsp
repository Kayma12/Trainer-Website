<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log In</title>
 <jsp:include page="templates/header.jsp" />
</head>
<body>
<h2>LOG IN PAGE</h2>
 
 <form action="${contextPath}/login" method="POST">  

UserName: <input type="text" name="userName" value = "${param.userName}" required/><br/><br/>  
Password: <input type="password" name="password" value = "${param.password}" required/><br/><br/>  
<input type="submit" value="login"/><br/><br/>   
	${message}
</form>  
 
 
 
 <a href="home.jsp"> <input type="button" value="Back To Home" />
	</a>
 <a href="register.jsp"> <input type="button" value="Register" />
	</a>
 
</body>
</html>