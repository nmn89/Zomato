<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Added</title>
</head>
<body>
<h2>Order Added Successfully</h2>
<button><a href="${pageContext.request.contextPath }/showrestaurantdish/${rid }/${uid }">Add more Dish</a></button>
</body>
</html>