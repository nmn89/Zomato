<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="./base.jsp"%>
<meta charset="UTF-8">
<title>Zomato</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<a class="navbar-brand add" href="owner">Add Restaurant</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link" href="index">Log-in
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item active"><a class="nav-link" href="add-user">Sign-up</a>
				</li>
			</ul>
			<form class="form-inline my-2 my-lg-0">
				<input class="form-control mr-sm-2" type="search"
					placeholder="Search" aria-label="Search">
				<button class="btn btn-outline-danger my-2 my-sm-0" type="submit">Search</button>
			</form>
		</div>
	</nav>
	<div class="container mt-3">
		<div class="row">
			<div class="col-md-12">
				<h1 class="text-center mb-3">Welcome to Zomato</h1>
				<table class="table">
					<thead class="thead-dark">
						<tr>
						<th scope="col">Restaurant Name</th>
							<th scope="col">Dish Name</th>
							<th scope="col">Dish Price</th>
							<th scope="col">Quantity</th>
						</tr>
					</thead>
					<tbody>
						
							<tr>
							<td scope="row">${food.restaurantName }</td>
								<td scope="row">${food.dishName }</td>
								<td class="font-weight-bold">&#8377; ${food.dishPrice }</td>
								<td>${food.quantity }</td>
							</tr>
						
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>