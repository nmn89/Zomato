<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@include file="./base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
</head>
<body>
<div class="card container mt-5 py-3" style="width:500px">
	<h2 class="text-center my-2">Login</h2>
		<form action="userhome" method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">Email</label> <input
					type="text" class="form-control" id="email"
					aria-describedby="emailHelp" placeholder="Enter your Email-id"
					name="email" required>
			</div>
			<div class="form-group">
				<label for="userPassword">Password</label> <input type="password"
					class="form-control" id="userPassword" aria-describedby="username"
					placeholder="Enter password" name="password" required>
			</div>
			<div class="container text-center mt-3">
				<button type="submit" class="btn btn-outline-danger">Login</button>
			</div>
			<div class="container text-center mt-3">
				<p>New User! <a href="registeruser">Create Account</a></p>
			</div>
			<div class="container text-center mt-2">
				<a href="ownerlogin">Login as Owner</a>
			</div>
			<div>
				<p style="font-style: italic; color:red;">${msg }</p>
			</div>
		</form>
	</div>
</body>
</html>