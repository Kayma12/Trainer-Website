<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>The Shopping Cart</title>
 <jsp:include page="templates/header.jsp" />
</head>
<body>
<h2>${sessionScope.firstName}  Shopping Cart</h2>

<table>
    <tr>
    	 <th>Id</th>
        <th>Description</th>
        <th>Quantity</th>
        <th>Price</th>
    </tr>
 
    <c:forEach items="${trainers.entrySet()}" var="trainer" >
    
        <tr>
         
          <td>${trainer.getKey().trainerId}</td>
             <td>${trainer.getKey().trainerDescription}</td>
            
            <td>${trainer.getValue()}</td>
             <td>£${trainer.getKey().priceOfTrainer}</td>
              <td> <a href="/shoppingCart/removeProduct/{id}'(id=${trainer.getKey().trainerId})">
            
            	 <button type="button">Remove</button>
            
       
            </a> 
            </td> 
            
             
        </tr> 
    </c:forEach>
</table>
 
   <br></br>
    <h2>Total: [[${total}]]</h2>
        <a href="@{'/shoppingCart/checkout'}">
            <button type="button" text="Checkout">Checkout</button>
        </a>

</body>
</html>