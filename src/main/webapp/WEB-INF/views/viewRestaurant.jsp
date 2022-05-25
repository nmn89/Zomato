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
							<li>${r.restaurantName }
							<button><a href="${pageContext.request.contextPath }/setorder/${uid }/${r.rid }">Add to Orders</a></button></li>
</c:forEach>
</ul>
</body>
</html>