<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update User</title>
</head>
<body>
<div>

		<h1>Update user</h1>

		<form action="${pageContext.request.contextPath }/updateuser" method="post">
		<div>
			<input type="hidden" value="${user.uid }" name="uid" />
		</div>
			<div>
				<label for="userName">User Name</label> <input type="text"
					class="form-control" id="userName" aria-describedby="username"
					placeholder="Enter your name" name="userName" value="${user.userName }">
			</div>
			<div>
				<label for="exampleInputEmail1">Email address</label> <input
					type="email" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="Enter email" name="email"
					value="${user.email }">
			</div>
			<div>
				<label for="number">Mobile No.</label> <input type="number"
					class="form-control" id="number" aria-describedby="emailHelp"
					placeholder="Enter mobile no." name="number" value="${user.number }">
			</div>
			<div>
				<label for="userPassword">Password</label> <input type="password"
					class="form-control" id="userPassword" aria-describedby="username"
					placeholder="Enter password" name="password" value="${user.password }">
			</div>
			<div>
				<button type="submit" class="btn btn-success">Submit</button>
			</div>
		</form>
	</div>
</body>
</html>