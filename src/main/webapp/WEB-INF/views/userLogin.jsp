<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
</head>
<body>
<h1 class="text-center mt-5">Login</h1>

	<div class="card container mt-5">

		<form action="/homePage" method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">Mobile No.</label> <input
					type="text" class="form-control" id="mobile"
					aria-describedby="emailHelp" placeholder="Enter mobile no."
					name="mobileNo" required>
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
				<a href="registerUser">New User! Create Account</a>
			</div>
			<div>
			<div class="container text-center ">
				<p style="font-style: italic; color:red;">${msg }</p>
			</div>
			</div>
		</form>
	</div>
</body>
</html>