<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@include file="./base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurant Dish</title>
</head>
<body>
	<h1 class="text-center my-3 font-weight-bold alert-dark" style="width:70%;margin-left:200px;">My Restaurant's Dish</h1>
	<div class="row">
		<div class="col-md-12">
		<div class="card shadow-lg mt-5">
			<table class="table mx-5 my-4" style="width:90%;">
				<thead class="thead-dark">
			<tr>
				<th scope="col">Dish Name</th>
				<th scope="col">Dish Price per plate</th>
				<th scope="col">Order Dish</th>
			</tr>
		</thead>
		<c:forEach items="${dishes }" var="d">
			<tbody>
				<tr>
					<td scope="row">${d.dishName }</td>
					<td scope="row">${d.dishPrice }</td>
					<td scope="row"><a href="${pageContext.request.contextPath }/setorderdish/${uid }/${d.restaurantId }/${d.id }/${orid }" class="badge badge-success">Add to Orders</a></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	</div>
</div>
</div>
</body>
</html>