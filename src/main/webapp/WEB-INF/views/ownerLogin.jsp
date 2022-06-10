<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@include file="./base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Owner Login</title>
</head>
<body>
<div class="card shadow-lg container mt-5 py-3" style="width:500px">
<h1 class="text-center mt-3">Owner Login</h1>

	<div>

		<form class="container mt-3 py-3" style="width: 460px" action="${pageContext.request.contextPath }/ownerhome" method="post">
			<div class="form-group">
				<label for="exampleInputEmail1">Email</label> <input
					type="text" class="form-control" id="email"
					aria-describedby="emailHelp" placeholder="Enter your email-id"
					name="email" required>
			</div>
			<div class="form-group">
				<label for="userPassword">Password</label> <input type="password"
					class="form-control" id="userPassword" aria-describedby="username"
					placeholder="Enter password" name="password" required>
			</div>
			<div class="container text-center mt-3">
				<button type="submit" class="btn btn-outline-success">Login</button>
			</div>
			<div class="container text-center mt-3	">
				<a href="ownerregister">Not Registered! Create Account</a>
			</div>
			<div class="text-center">
				<p style="font-style: italic; color:red;">${msg }</p>
			</div>
		</form>
	</div>
	</div>
</body>
</html>