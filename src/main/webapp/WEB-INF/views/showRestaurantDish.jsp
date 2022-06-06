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
					<td>
					<button type="button" class="btn btn-outline-success" data-toggle="modal" data-target="#${d.id }">
  Order Dish
</button></td>	
				
				<div class="modal fade" id="${d.id }" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Order Dish</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <form class="container mt-3 py-3" style="width: 500px"
		action="${pageContext.request.contextPath }/orderdishadded/${d.restaurantId }/${uid }"
		method="post">
		<div class="form-group">
			<input type="hidden"
				class="form-control" id="did" aria-describedby="did" name="dishId"
				value="${d.id }" readOnly>
		</div>
		<div class="form-group">
			<input type="hidden"
				class="form-control" id="orid" aria-describedby="orid" name="orderId"
				value="${orid }" readOnly>
		</div>
		<div class="form-group">
			<label for="quantity">Dish Name</label> <input type="text"
				class="form-control" value="${d.dishName }" aria-describedby="quantity"
				required>
		</div>
		<div class="form-group">
			<label for="quantity">Quantity</label> <input type="text"
				class="form-control" id="quantity" aria-describedby="quantity"
				name="quantity" required>
		</div>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary">Order</button>
        </form>
      </div>
    </div>
  </div>
</div>
				
				</tr>
			</tbody>
		</c:forEach>
	</table>
	</div>
</div>
</div>
</body>
</html>