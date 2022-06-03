<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@include file="./base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Owner</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<div class="d-inline-block align-text-top">
				<img
					src="https://thumbs.dreamstime.com/b/menu-restaurant-food-service-logo-hand-holding-tray-vector-illustration-isolated-white-background-menu-restaurant-food-136082782.jpg"
					class="mr-3" style="width: 110px; height: 65px">
			</div>
			<div class="collapse navbar-collapse" id="navbarSupportedContent"
				style="margin-left: 350px;">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 mr-4">
					<li class="nav-item"><a class="btn btn-outline-primary"
						href="${pageContext.request.contextPath }/ownerprofile/${oid }">Owner
							Profile</a></li>
					<li class="nav-item">

						<button type="button" class="btn btn-outline-primary ml-4" data-toggle="modal"
							data-target="#${oid }">Add Location</button>
						<div class="modal fade" id="${oid }" tabindex="-1"
							aria-labelledby="exampleModalLabel" aria-hidden="true">
							<div class="modal-dialog">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">Add
											Location</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<div class="modal-body">
										<form class="container mt-5 py-3" style="width: 500px"
											action="${pageContext.request.contextPath }/locationadded/${oid }"
											method="post">
											<div class="form-group">
												<h4>
													<label for="locationName">Location Name</label>
												</h4>
												<input type="text" class="form-control" id="locationName"
													aria-describedby="locationname"
													placeholder="Enter location" name="location" required>
											</div>
									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-secondary"
											data-dismiss="modal">Close</button>
										<button type="submit" class="btn btn-primary">Save
											changes</button>
									</div>
									</form>
								</div>
							</div>
						</div>
					<li class="nav-item ml-4"><a class="btn btn-outline-primary"
						href="${pageContext.request.contextPath }/location/${oid }">Add
							Restaurant</a></li>
					<li class="nav-item ml-4"><a class="btn btn-outline-primary"
						href="${pageContext.request.contextPath }/ownerlogin"
						tabindex="-1">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<c:forEach items="${restaurants }" var="r">
		<div
			class="card mb-3 ml-5 mt-5 d-inline-flex flex-direction-row shadow-lg mb-5 bg-white rounded"
			style="margin-right: 20px; width: 50%; height: 200px;">
			<div class="row no-gutters">
				<div class="col-md-6">
					<img style="width: 300px;" class="ml-3 mt-3 rounded"
						src="https://i.ndtvimg.com/i/2015-06/fusion-food_625x350_71434106320.jpg">
				</div>
				<div class="col-md-5">
					<div class="card-body">
						<h3 class="card-title">
							<a class="text-dark"
								href="${pageContext.request.contextPath }/showdish/${r.id }">${r.restaurantName }</a>
						</h3>
						<p class="card-text">
							<a class="btn btn-outline-success"
								href="${pageContext.request.contextPath }/adddish/${r.id }">Add
								Dish</a>
						</p>
						<p class="card-text">
							<a class="text-dark"
								href="${pageContext.request.contextPath }/showorder/${r.id }">Restaurant
								Orders</a>
						</p>
						<p class="card-text">
							<a class="text-dark"
								href="${pageContext.request.contextPath }/removerestaurant/${r.id }/${oid }">Delete
								Restaurant</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</body>
</html>