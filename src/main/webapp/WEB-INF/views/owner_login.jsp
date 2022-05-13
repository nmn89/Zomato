<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="./base.jsp"%>
<meta charset="UTF-8">
<title>Restaurant Login</title>
</head>
<body>
		<h1 class="text-center mt-5">Restaurant Login</h1>

	<div class="card container mt-5">

		<form action="home" method="post">
		<div class="form-group">
				<label for="restaurantname">Restaurant Name</label> <input
					type="text" class="form-control" id="rname"
					aria-describedby="emailHelp" placeholder="Enter your restaurant name"
					name="rname" required>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Mobile No.</label> <input
					type="text" class="form-control" id="mobile"
					aria-describedby="emailHelp" placeholder="Enter mobile no."
					name="mobile" required>
			</div>
			<div class="form-group">
				<label for="userPassword">Password</label> <input type="password"
					class="form-control" id="userPassword" aria-describedby="username"
					placeholder="Enter password" name="password" required>
			</div>
			<div class="container text-center">
				<button type="submit" class="btn btn-danger">Login</button>
			</div>
		</form>
	</div>
</body>
</html>