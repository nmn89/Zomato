<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@include file="./base.jsp"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*,java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurant</title>
</head>
<body>
	<%
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	String newDate = df.format(new Date());
	%>
	<h2 class="my-3 font-weight-bold">Search result for
		${restaurant.restaurantName }...</h2>
	<div class="card mt-5 shadow-lg d-inline-flex"
		style="margin-left: 100px; margin-right: 20px; width: 300px; height: 300px">
		<div class="card-img-top">
			<img style="width: 300px"
				src="https://i.ndtvimg.com/i/2015-06/fusion-food_625x350_71434106320.jpg">
		</div>
		<div class="card-body">
			<h5>
				<a
					href="${pageContext.request.contextPath }/viewdish/${restaurant.id }"
					class="text-dark" style="text-decoration: none">${restaurant.restaurantName }</a>
			</h5>
		</div>
		<div class="card-body">
			<button type="button" class="btn btn-outline-info"
				data-toggle="modal" data-target="#${restaurant.id }">Add
				Order</button>
		</div>
	</div>
	<div class="modal fade" id="${restaurant.id }" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalLabel">Add Order</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form class="card container mt-5 py-3" style="width: 450px"
						action="${pageContext.request.contextPath }/addorder/${uid }/${restaurant.id }"
						method="post">
						<div class="form-group">
							<input type="hidden" class="form-control" id="uid"
								aria-describedby="uid" name="userId" value="${uid }" readOnly>
						</div>
						<div class="form-group">
							<label for="date">Restaurant Name</label> <input type="text"
								class="form-control" value="${restaurant.restaurantName }"
								readOnly>
						</div>
						<div class="form-group">
							<label for="date">Date of Order</label> <input type="text"
								class="form-control" id="date" aria-describedby="date"
								name="date" value="<%=newDate%>" readOnly>
						</div>
						<div class="form-group">
							<input type="hidden" class="form-control" id="rid"
								aria-describedby="rid" name="restaurantId"
								value="${restaurant.id }" readOnly>
						</div>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-dismiss="modal">Close</button>
					<button type="sub,mit" class="btn btn-primary">Save
						changes</button>
				</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>