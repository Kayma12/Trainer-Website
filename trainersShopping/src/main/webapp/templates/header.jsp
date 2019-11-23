<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Lux Style</title>
</head>
<body>

    <ul id="nav">
    
    		<li><a href="/home.jsp">Home</a></li>
            <li><a href="/products">Products</a></li>
           
            <%
                String firstName = (String) session.getAttribute("firstName");                     
                if (firstName == null) {
            %>
            <li><a href="/register.jsp">Register</a></li>
            <li><a href="/login.jsp">Login</a></li>

        <% } else {
         %>
            <li>Hi, <%=firstName %>  (<a href="/logout">Logout</a>)</li>
        <% }%>
       			 <li><a href="/order.jsp">Orders</a></li>
       			  <li><a href="/payments.jsp">Payments</a></li>
        </ul>

                
                
                

</body>
</html>