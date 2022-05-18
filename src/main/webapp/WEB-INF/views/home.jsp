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
				<li class="nav-item active"><a class="nav-link" href="login">Log-in
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
	<div class="card bg-light mt-3 ml-lg-5" style="width:800px">
	<c:forEach items="${rest }" var="r">
		<div id="accordion">
			<div class="card">
				<div class="card-header" id="headingOne">
					<h5 class="mb-0">
						<button class="btn btn-link" data-toggle="collapse"
							data-target="#${r.rid }" aria-expanded="true"
							aria-controls="collapseOne">${r.restaurantName }</button>
					</h5>
				</div>
				<div id="${r.rid }" class="collapse show"
					aria-labelledby="headingOne" data-parent="#accordion">
					<div class="card-body">
						<table class="table">
							<thead class="thead-dark">
								<tr>
									<th scope="col">Dish Name</th>
									<th scope="col">Dish Price</th>
									<th scope="col">Quantity</th>
									<th scope="col"></th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${menu }" var="m">
									<tr>
										<td scope="row">${m.dishName }</td>
										<td class="font-weight-bold">&#8377; ${m.dishPrice }</td>
										<td>${m.quantity }</td>
										<td>
							<a href="add/${m.dId }" class="btn btn-outline-dark">Add to Cart</a>
							</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
	</div>
</body>
</html>