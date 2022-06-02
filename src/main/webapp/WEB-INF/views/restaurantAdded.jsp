<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@include file="./base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Successfully</title>
</head>
<body>
<div class="alert alert-success" role="alert">
<h4 class="alert-heading">Restaurant Added Successfully</h4>
<hr>
<a href="${pageContext.request.contextPath }/ownerrestaurant/${oid }">Click Here to view my Restaurants...</a>
</div>
</body>
</html>