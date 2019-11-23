<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>

<h2>Registration</h2>

 <form action="${contextPath}/register" method="POST" autocomplete="off">  
 
Title : <input type="text" name="title" value = "${param.title}" required/><br/><br/> 
First Name : <input type="text" name="firstName" value = "${param.firstName}" required/><br/><br/> 
Last Name : <input type="text" name="lastName" value = "${param.lastName}" required/><br/><br/> 
UserName : <input type="text" name="userName" value = "${param.userName}" required/><br/><br/> 
Email Address : <input type="text" name="emailAddress" value = "${param.emailAddress}" required/><br/><br/> 
Address : <input type="text" name="address" value = "${param.address}" required/><br/><br/> 
Password : <input type="password" name="password" value = "${param.password}" required/><br/><br/> 
Confirm Password : <input type="password" name="confirmPassword" value = "${param.confirmPassword}" required/><br/><br/> 

 <a href="home.jsp"> <input type="button" value="Back To Home" />
	</a><br/><br/>   
<input type="submit" value="Register"/><br/><br/>   
	${regMessage}
</form>  

</body>
</html>