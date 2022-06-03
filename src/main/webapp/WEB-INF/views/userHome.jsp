<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@include file="./base.jsp"%>
<!DOCTYPE html>
<html>
<style>
.dropbtn {
	background-color: white;
	color: black;
	padding: 10px;
	font-size: 12px;
}

.dropdown {
	display: inline-block;
	position: relative
}

.dropdown-content {
	position: absolute;
	background-color: white;
	min-width: 200px;
	display: none;
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: grey;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: grey;
}
</style>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<div width="30" height="24" class="d-inline-block align-text-top">
				<img
					src="https://thumbs.dreamstime.com/b/menu-restaurant-food-service-logo-hand-holding-tray-vector-illustration-isolated-white-background-menu-restaurant-food-136082782.jpg"
					class="mr-3" style="width: 110px; height: 65px">
			</div>
			<form
				action="${pageContext.request.contextPath }/searchrestaurant/${uid }"
				class="d-flex" style="margin-left: 25px; width: 500px">
				<input class="form-control me-2" type="search" placeholder="Search"
					aria-label="Search" name="restaurantName">
				<button class="btn btn-outline-success" type="submit">Search</button>
			</form>
			<div class="collapse navbar-collapse" id="navbarSupportedContent"
				style="margin-left: 250px;">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li><div class="dropdown">
							<button class="dropbtn">Select Location</button>
							<div class="dropdown-content">
								<c:forEach items="${locations }" var="l">
									<a
										href="${pageContext.request.contextPath }/userhome/${uid }/${l.id }">${l.location }</a>
								</c:forEach>
							</div>
						</div></li>
					<li class="nav-item"><a class="nav-link active"
						aria-current="page"
						href="${pageContext.request.contextPath }/getorder/${uid }">My
							Orders</a></li>
						<li class="nav-item"><a class="nav-link active"
						href="${pageContext.request.contextPath }/userprofile/${uid }">User
							Profile</a></li>
					<li class="nav-item"><a class="nav-link active"
						href="${pageContext.request.contextPath }/" tabindex="-1">Logout</a>
					</li>
				</ul>
			</div>
		</div>
	</nav>
	<c:forEach items="${restaurants }" var="r">
		<div class="card mt-5 d-inline-flex"
			style="margin-left: 100px; margin-right: 20px; width: 300px; height: 300px">
			<div class="card-img-top">
				<img style="width: 300px"
					src="https://i.ndtvimg.com/i/2015-06/fusion-food_625x350_71434106320.jpg">
			</div>
			<div class="card-body">
				<h5>
					<a href="${pageContext.request.contextPath }/viewdish/${r.id }"
						class="text-dark" style="text-decoration: none">${r.restaurantName }</a>
				</h5>
			</div>
			<div class="card-body">
				<a style="text-decoration: none; width: 100px"
					href="${pageContext.request.contextPath }/setrestaurantorder/${r.id }/${uid }"
					class="text-dark">Order Now</a>
			</div>
		</div>
	</c:forEach>
</body>
</html>