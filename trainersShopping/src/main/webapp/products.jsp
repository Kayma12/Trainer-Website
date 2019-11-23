<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <jsp:include page="templates/header.jsp" />
</head>
<body>

${trainers}

${sessionScope.firstName}

  <h2>Products</h2>

 
 <table>
    <tr>
    	 <th>Id</th>
        <th>Description</th>
         <th>Image</th>
        <th>Quantity In Stock</th>
        <th>Price</th>
    </tr>
    <c:forEach items="${trainers}" var="trainer" >
        <tr>
          <td>${trainer.trainerId}</td>
            <td>${trainer.trainerDescription}</td>
            <td>
			<img src="${pageContext.request.contextPath }/productImages/${trainer.trainerDescription}1.JPG" width="120">
				</td>
            <td>${trainer.quantityInStock}</td>
             <td>£${trainer.priceOfTrainer}</td>
              <td> <a href="shoppingCart/addProduct/${trainer.trainerId}">
            <c:if test="${sessionScope.firstName != null && trainer.quantityInStock > 0}">
            	 <button type="button">Buy Now</button>
            </c:if>
       
            </a> 
            </td>
             
        </tr>
    </c:forEach>
</table>
 
 
 
 
</body>
</html>