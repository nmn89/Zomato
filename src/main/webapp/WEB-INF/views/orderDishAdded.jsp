<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@include file="./base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Successfull</title>
</head>
<body>

	<h2 class="text-center mb-3">Dish Ordered Successfully</h2>
	<div class="row px-5">
		<div class="col-md-12">
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Order No.</th>
						<th scope="col">Restaurant Name</th>
						<th scope="col">Dish Name</th>
						<th scope="col">Date</th>			
					</tr>
				</thead>
				<c:forEach items="${orders }" var="o">
					<tbody>
						<tr>
							<td scope="row">${o.odid }</td>
							<td scope="row">${o.restaurantName }</td>
							<td scope="row">${o.dishName }</td>
							<td scope="row">${o.date }</td>
						</tr>
					</tbody>
				</c:forEach>
			</table>
		</div>
	</div>
	<div class="container text-center mt-3">
		<button class="btn btn-light">
			<a href="${pageContext.request.contextPath }/showrestaurantdish/${rid }/${uid }/${orid }">Order More Dish</a>
		</button>
		<button class="btn btn-light">
			<a href="${pageContext.request.contextPath }/getorder/${uid }">SubmitOrder</a>
		</button>
	</div>

</body>
</html>