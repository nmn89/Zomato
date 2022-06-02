<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="./base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add User</title>
</head>
<body style="background-color:#DCDCDC;">
	<div class="card container mt-5 py-3" style="width:500px">

		<h2 class="text-center my-3">User Registration</h2>
		<form  action="register" method="post">
			<div class="form-group">
				<label for="userName">User Name</label> <input type="text"
					class="form-control" id="userName" aria-describedby="username"
					placeholder="Enter your name" name="userName" required>
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Email address</label> <input
					type="email" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="Enter email" name="email"
					required>
			</div>
			<div class="form-group">
				<label for="number">Mobile No.</label> <input type="text"
					class="form-control" id="number" aria-describedby="emailHelp"
					placeholder="Enter mobile no." name="number" required>
			</div>
			<div class="form-group">
				<label for="userPassword">Password</label> <input type="password"
					class="form-control" id="userPassword" aria-describedby="username"
					placeholder="Enter password" name="password" required>
			</div>
			<div class="container text-center mt-3" >
				<button type="submit" class="btn btn-outline-success">Submit</button>
			</div>
		</form>
	</div>
</body>
</html>