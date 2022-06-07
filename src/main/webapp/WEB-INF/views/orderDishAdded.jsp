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

	<h2 class="text-center my-3 font-weight-bold alert-dark" style="width:70%;margin-left:200px;">Dish Ordered Successfully</h2>
	<div class="row px-5">
		<div class="col-md-12">
		<div class="card shadow-lg mt-5" style="margin-left:60px;width:90%;">
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Order No.</th>
						<th scope="col">Restaurant</th>
						<th scope="col">Dish</th>
						<th scope="col">Date</th>			
					</tr>
				</thead>
				<c:forEach items="${orders }" var="o">
					<tbody>
						<tr>
							<td scope="row">${o.orderDishId }</td>
							<td scope="row">${o.restaurantName }</td>
							<td scope="row">${o.dishName }</td>
							<td scope="row">${o.date }</td>
						</tr>
					</tbody>
				</c:forEach>
			</table>
			</div>
		</div>
	</div>
	<div class="container text-center mt-3">
			<a class="btn btn-outline-primary" href="${pageContext.request.contextPath }/showrestaurantdish/${rid }/${uid }/${orid }">Order More Dish</a>
			<a onclick="submit()" class="btn btn-outline-success ml-4" href="${pageContext.request.contextPath }/getorder/${uid }">SubmitOrder</a>
	</div>
<script type="text/javascript">
function submit(){
	console.log("Ordered");
	alert("Your order placed successfully");
}
</script>
</body>
</html>