<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored="false"%>
    <%@include file="./base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User</title>
</head>
<body>
<div class="card shadow-lg container mt-5 py-3" style="width:500px">

		<h2 class="text-center my-2">Update user</h2>

		<form action="${pageContext.request.contextPath }/updateuser" method="post">
		<div class="form-group">
			<input type="hidden" value="${user.id }" name="id" />
		</div>
			<div class="form-group">
				<label for="userName">User Name</label> <input type="text"
					class="form-control" id="userName" aria-describedby="username"
					placeholder="Enter your name" name="userName" value="${user.userName }">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Email address</label> <input
					type="email" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="Enter email" name="email"
					value="${user.email }">
			</div>
			<div class="form-group">
				<label for="number">Mobile No.</label> <input type="number"
					class="form-control" id="number" aria-describedby="emailHelp"
					placeholder="Enter mobile no." name="number" value="${user.number }">
			</div>
			<div class="form-group">
				<label for="userPassword">Password</label> <input type="password"
					class="form-control" id="userPassword" aria-describedby="username"
					placeholder="Enter password" name="password" value="${user.password }">
			</div>
			<div class="container text-center mt-3">
				<button type="submit" class="btn btn-outline-success">Submit</button>
			</div>
		</form>
	</div>
</body>
</html>