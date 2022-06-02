<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Restaurants</title>
</head>
<body>
<h1>My Restaurants</h1>
<ol>
<c:forEach items="${restaurants }" var="r">
							<li><a href="${pageContext.request.contextPath }/showdish/${r.id }">${r.restaurantName }</a>
							<button><a href="${pageContext.request.contextPath }/adddish/${r.id }">Add Dish</a></button>
							<button><a href="${pageContext.request.contextPath }/showorder/${r.id }">Restaurant Orders</a></button>
							<button><a href="${pageContext.request.contextPath }/removerestaurant/${r.id }/${oid }">Delete Restaurant</a></button></li>
</c:forEach>
</ol>
</body>
</html>