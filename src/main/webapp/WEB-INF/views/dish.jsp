<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="./base.jsp"%>
<meta charset="UTF-8">
<title>Add Dish</title>
</head>
<body>
	<h1 class="text-center mt-5">Add Dish</h1>

	<div class="card container mt-5">

		<form action="${pageContext.request.contextPath}/home_restaurant"
			method="post">
			<div class="form-group">
				<label for="dishname">Dish Name</label> <input type="text"
					class="form-control" id="rname" aria-describedby="emailHelp"
					placeholder="Enter your dish name" name="dishName" required>
			</div>
			<div class="form-group">
				<label for="dishprice">Dish Price</label> <input type="text"
					class="form-control" id="mobile" aria-describedby="emailHelp"
					placeholder="Enter Dish price per plate" name="dishPrice" required>
			</div>
			<div class="form-group">
				<label for="quantity">Quantity Per Plate</label> <input type="text"
					class="form-control" id="userPassword" aria-describedby="username"
					placeholder="Enter quantity per plate" name="quantity" required>
			</div>
			<div class="container text-center">
				<button type="submit" class="btn btn-success">Add</button>
				<a href="home_restaurant" class="btn btn-outline-dark">Skip</a>
			</div>
		</form>
	</div>
</body>
</html>