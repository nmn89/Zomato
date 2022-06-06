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
<h1 class="text-center my-3 font-weight-bold alert-dark" style="width:70%;margin-left:200px;">My Orders</h1>
	<div class="row">
		<div class="col-md-12">
		<div class="card shadow-lg mt-5">
			<table class="table mx-5 my-5" style="width:90%;">
				<thead class="thead-dark">
			<tr>
			<th scope="col">Order No.</th>
				<th scope="col">Order Date</th>
				<th scope="col">Restaurant Name</th>
				<th scope="col">View Dish Ordered</th>
				<th scope="col">Delete Order</th>
			</tr>
		</thead>
		<c:forEach items="${orders }" var="o">
			<tbody>
				<tr>
				<td scope="row">${o.orderId }</td>
					<td scope="row">${o.date }</td>
					<td scope="row">${o.restaurantName }</td>
					<td scope="row"><a href="${pageContext.request.contextPath }/getorderdish/${o.orderId }">View Ordered Dish</a></td>
					<td scope="row"><a href="${pageContext.request.contextPath }/deleteorder/${o.orderId }/${uid }"><i class="fa-solid fa-trash-can text-danger"></i></a></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	</div>
	</div>
	</div>
</body>
</html>