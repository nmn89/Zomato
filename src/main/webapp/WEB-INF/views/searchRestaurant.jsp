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
<div class="card mt-5 d-inline-flex"
			style="margin-left: 100px; margin-right:20px;width:300px; height:300px">
			<div class="card-img-top">
				<img style="width:300px"
					src="https://i.ndtvimg.com/i/2015-06/fusion-food_625x350_71434106320.jpg">
			</div>
	<div class="card-body">
	<a href="${pageContext.request.contextPath }/viewdish/${restaurant.id }">${restaurant.restaurantName }</a>
	<a style="width: 100px;text-decoration:none" href="${pageContext.request.contextPath }/setrestaurantorder/${restaurant.id }/${uid }">Order Now</a>
	</div>
	</div>
	</div>
</body>
</html>