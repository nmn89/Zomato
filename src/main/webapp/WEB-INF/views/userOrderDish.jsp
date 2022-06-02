<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page isELIgnored="false" %>
    <%@include file="./base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ordered Dish</title>
</head>
<body>
<h1 class="text-center my-3 font-weight-bold">Ordered Dish</h1>
<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead class="thead-dark">
			<tr>
				<th>Order No.</th>
				<th>Dish Name</th>
				<th>Date</th>
				<th>Restaurant Name</th>
			</tr>
		</thead>
		<c:forEach items="${orders }" var="o">
			<tbody>
				<tr>
					<td>${o.orderDishId }</td>
					<td>${o.dishName }</td>
					<td>${o.date }</td>
					<td>${o.restaurantName }</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>

</body>
</html>