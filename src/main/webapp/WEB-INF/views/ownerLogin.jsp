<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Owner Login</title>
</head>
<body>
<h1>Owner Login</h1>

	<div>

		<form action="ownerhome" method="post">
			<div>
				<label for="exampleInputEmail1">Email</label> <input
					type="text" class="form-control" id="email"
					aria-describedby="emailHelp" placeholder="Enter your email-id"
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
			<div class="container text-center mt-3	">
				<a href="ownerregister">Not Registered! Create Account</a>
			</div>
		</form>
	</div>
</body>
</html>