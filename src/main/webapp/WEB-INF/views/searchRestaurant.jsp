<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@include file="./base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurant</title>
</head>
<body>
	<h2 class="my-3 font-weight-bold">Search result for ${restaurant.restaurantName }...</h2>
	<h3><a href="${pageContext.request.contextPath }/viewdish/${restaurant.id }">${restaurant.restaurantName }</a></h3>
	<a style="width: 100px" href="${pageContext.request.contextPath }/setrestaurantorder/${restaurant.id }/${uid }">Order Now</a>
</body>
</html>