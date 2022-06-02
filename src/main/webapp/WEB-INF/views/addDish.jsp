<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored="false" %>
<%@include file="./base.jsp"%>
<meta charset="UTF-8">
<title>Add Dish</title>
</head>
<body>
<div>

		<h1 class="text-center mt-5">Add Dish</h1>

		<form class="card container mt-5 py-3" style="width:500px" action="${pageContext.request.contextPath }/dishadded/${rid}" method="post">
			<div class="form-group">
				<label for="dishName">Dish Name</label> <input type="text"
					class="form-control" id="dishName" aria-describedby="dishname"
					placeholder="Enter your Dish name" name="dishName" required>
			</div>
			<div class="form-group">
				<label for="dishPrice">Dish Price</label> <input type="text"
					class="form-control" id="dishPrice" aria-describedby="dishPrice"
					placeholder="Enter Dish price per plate" name="dishPrice" required>
			</div>
			<input type="hidden" value="${rid }" name="restaurantId" />
			<div class="container text-center mt-3">
				<button type="submit" class="btn btn-outline-success">Submit</button>
			</div>
		</form>
	</div>
</body>
</html>