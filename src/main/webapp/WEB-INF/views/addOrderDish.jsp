<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@include file="./base.jsp"%>
<meta charset="UTF-8">
<title>Order Dish</title>
</head>
<body>
	<h1 class="text-center mt-5">Order Dish</h1>
	<form class="card container mt-5 py-3" style="width: 500px"
		action="${pageContext.request.contextPath }/orderdishadded/${rid }/${uid }"
		method="post">
		<div class="form-group">
			<label for="did">Dish Id</label> <input type="text"
				class="form-control" id="did" aria-describedby="did" name="did"
				value="${did }" readOnly>
		</div>
		<div class="form-group">
			<label for="orid">Order Id</label> <input type="text"
				class="form-control" id="orid" aria-describedby="orid" name="orid"
				value="${orid }" readOnly>
		</div>
		<div class="form-group">
			<label for="quantity">Quantity</label> <input type="text"
				class="form-control" id="quantity" aria-describedby="quantity"
				name="quantity" required>
		</div>
		<div class="container text-center mt-3">
			<button type="submit" class="btn btn-success">Place Order</button>
		</div>
	</form>
</body>
</html>