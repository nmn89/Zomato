<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<label for="exampleInputEmail1">Mobile No.</label> <input
					type="number" class="form-control" id="mobile"
					aria-describedby="emailHelp" placeholder="Enter mobile no."
					name="mobileNo" required>
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
		</form>
	</div>
</body>
</html>