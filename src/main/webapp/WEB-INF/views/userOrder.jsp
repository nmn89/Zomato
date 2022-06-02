<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page isELIgnored="false" %>
    <%@include file="./base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Order</title>
</head>
<body>
<h1 class="text-center my-3 font-weight-bold">My Orders</h1>
	<div class="row">
		<div class="col-md-12">
			<table class="text-center">
				<thead class="thead-dark">
			<tr>
				<th scope="col">Order Date</th>
				<th scope="col">Restaurant Name</th>
				<th scope="col">Dish Name</th>
				<th scope="col">Delete Order</th>
			</tr>
		</thead>
		<c:forEach items="${orders }" var="o">
			<tbody>
				<tr>
					<td scope="row">${o.date }</td>
					<td scope="row">${o.restaurantName }</td>
					<td scope="row">${o.dishName }</td>
					<td scope="row"><a href="${pageContext.request.contextPath }/deleteorder/${o.orderId }/${uid }"><i class="fa-solid fa-trash-can text-danger"></i></a></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
</body>
</html>