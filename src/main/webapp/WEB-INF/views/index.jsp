<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!doctype html>
<html lang="en">
<head>
<%@include file="./base.jsp"%>
<!-- Required meta tags -->
<meta charset="utf-8">

<title>Authentication</title>
</head>
<body>

	<h1 class="text-center mt-5">Login</h1>

	<div class="card container mt-5">

		<form action="home" method="post">
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
			<div class="container text-center mt-3	">
				<a href="add-user">New User! Create Account</a>
			</div>
		</form>
	</div>
</body>
</html>

