<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurant</title>
</head>
<body>
	<h2>Search result for ${restaurant.restaurantName }</h2>
	<h3><a href="${pageContext.request.contextPath }/showdish/${restaurant.id }">${restaurant.restaurantName }</a></h3>
</body>
</html>