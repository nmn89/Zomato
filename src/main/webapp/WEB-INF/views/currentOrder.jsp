<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@include file="./base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Current Orders</title>
</head>
<body>
	<div class="row">
		<div class="col-md-12">
			<h1 class="text-center mb-3">Current Orders</h1>
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Order No.</th>
						<th scope="col">Order Date</th>
						<th scope="col">Restaurant Name</th>
						<th scope="col">Dish Name</th>
						<th scope="col">Dish Quantity</th>
						<th scope="col"></th>
					</tr>
				</thead>
				<c:forEach items="${orders }" var="o">
					<tbody>
						<tr>
							<td scope="row">${o.orId }</td>
							<td scope="row">${o.date }</td>
							<td scope="row">${o.restaurantName }</td>
							<td scope="row">${o.dishName }</td>
							<td scope="row">${o.quantity }</td>
							<td><button>
									<a
										href="${pageContext.request.contextPath }/deleteorder/${o.orId }/${uid }">DeleteOrder</a>
								</button></td>
						</tr>
					</tbody>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>