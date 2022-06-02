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
	<div class="container mt-3">
		<h1 class="text-center my-5 font-weight-bold">Restaurants</h1>
		<div class="row">
			<div class="col-md-12">
			<div class="text-center mb-5">
			<img src="https://st3.depositphotos.com/1037238/13709/v/600/depositphotos_137092050-stock-illustration-fast-food-restaurant.jpg" style="width:250px;height:200px;">
				</div>
				<table class="table">
					<thead class="thead-dark">
						<tr>
							<th>Restaurant Name</th>
							<th>Order Now</th>
						</tr>
					</thead>
					<c:forEach items="${restaurants }" var="r">
						<tbody>
							<tr>
								<td><a
									href="${pageContext.request.contextPath }/viewdish/${r.id }">${r.restaurantName }</a></td>
								<td><a style="width: 100px"
									href="${pageContext.request.contextPath }/setrestaurantorder/${r.id }/${uid }">Order
										Now</a></td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>