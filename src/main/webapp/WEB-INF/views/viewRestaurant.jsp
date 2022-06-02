<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurant</title>
</head>
<body>
<h1>Restaurants</h1>
<ul>
<c:forEach items="${restaurants }" var="r">
							<li><h3><a href="${pageContext.request.contextPath }/viewdish/${r.id }">${r.restaurantName }</a>
							<button><a href="${pageContext.request.contextPath }/setrestaurantorder/${r.id }/${uid }">Order from this Restaurant</a></button></h3></li>
</c:forEach>
</ul>
</body>
</html>