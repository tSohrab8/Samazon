<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Shopping Cart</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
	<ul>
	<c:forEach var="item" items="${list}">
	
		<li> ${item.productid } and ${item.quantity} </li>
		
	
	
	</c:forEach>
	</ul>
		
		<a href="/Samazon/index.jsp">Return To Shop</a>
	


</body>
</html>