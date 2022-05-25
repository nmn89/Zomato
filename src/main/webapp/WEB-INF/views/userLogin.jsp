<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Login</title>
</head>
<body>
	<h1>Login</h1>

	<div>

		<form action="userhome" method="post">
			<div>
				<label for="exampleInputEmail1">Email</label> <input
					type="text" class="form-control" id="email"
					aria-describedby="emailHelp" placeholder="Enter your Email-id"
					name="email" required>
			</div>
			<div>
				<label for="userPassword">Password</label> <input type="password"
					class="form-control" id="userPassword" aria-describedby="username"
					placeholder="Enter password" name="password" required>
			</div>
			<div>
				<button type="submit" class="btn btn-danger">Login</button>
			</div>
			<div>
				<a href="registerUser">New User! Create Account</a>
			</div>
			<div>
				<a href="ownerlogin">Login as Owner</a>
			</div>
			<div>
				<p style="font-style: italic; color:red;">${msg }</p>
			</div>
		</form>
	</div>
</body>
</html>