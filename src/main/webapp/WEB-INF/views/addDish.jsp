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
		<h1 class="text-center mt-5 font-weight-bold">Add Dish</h1>

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
				<button type="button" class="btn btn-outline-primary" data-toggle="modal" data-target="#${rid }">
  Submit
</button>
			</div>
			<div class="modal fade" id="${rid }" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-body">
      <div class="media position-relative" style="margin-top:50;width: 450px;">
  <img src="https://thumbs.dreamstime.com/b/menu-restaurant-food-service-logo-hand-holding-tray-vector-illustration-isolated-white-background-menu-restaurant-food-136082782.jpg" class="mr-3" style="width:120px;height:100px">
      
       <h4 class="mt-4">Dish Added Successfully</h4>
       </div>
      </div>
      <div class="modal-footer">
        <button type="submit" class="btn btn-primary">Show Dish</button>
      </div>
    </div>
  </div>
</div>
		</form>
	</div>
</body>
</html>