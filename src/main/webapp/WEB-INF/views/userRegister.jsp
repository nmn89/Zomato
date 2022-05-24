<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>
</head>
<body>
	<div>

		<h1>User Registration</h1>

		<form action="register" method="post">
			<div>
				<label for="userName">User Name</label> <input type="text"
					class="form-control" id="userName" aria-describedby="username"
					placeholder="Enter your name" name="userName" required>
			</div>
			<div>
				<label for="exampleInputEmail1">Email address</label> <input
					type="email" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="Enter email" name="email"
					required>
			</div>
			<div>
				<label for="number">Mobile No.</label> <input type="text"
					class="form-control" id="number" aria-describedby="emailHelp"
					placeholder="Enter mobile no." name="number" required>
			</div>
			<div>
				<label for="userPassword">Password</label> <input type="password"
					class="form-control" id="userPassword" aria-describedby="username"
					placeholder="Enter password" name="password" required>
			</div>
			<div>
				<button type="submit" class="btn btn-success">Submit</button>
			</div>
		</form>
	</div>
</body>
</html>