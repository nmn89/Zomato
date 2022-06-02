<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored="false"%>
        <%@include file="./base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Owner</title>
</head>
<body>
<div class="card container mt-5 py-3" style="width:500px">

		<h1 class="text-center my-2">Update Owner</h1>

		<form action="${pageContext.request.contextPath }/updateowner" method="post">
		<div>
			<input type="hidden" value="${owner.id }" name="id" />
		</div>
			<div class="form-group">
				<label for="ownerName">Owner Name</label> <input type="text"
					class="form-control" id="ownerName" aria-describedby="ownerName"
					placeholder="Enter your name" name="ownerName" value="${owner.ownerName }">
			</div>
			<div class="form-group">
				<label for="exampleInputEmail1">Email address</label> <input
					type="email" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="Enter email" name="email"
					value="${owner.email }">
			</div>
			<div class="form-group">
				<label for="number">Mobile No.</label> <input type="number"
					class="form-control" id="mobileNo" aria-describedby="emailHelp"
					placeholder="Enter mobile no." name="mobileNo" value="${owner.mobileNo }">
			</div>
			<div class="form-group">
				<label for="userPassword">Password</label> <input type="password"
					class="form-control" id="userPassword" aria-describedby="username"
					placeholder="Enter password" name="password" value="${owner.password }">
			</div>
			<div class="container text-center mt-3">
				<button type="submit" class="btn btn-outline-success">Submit</button>
			</div>
		</form>
	</div>
</body>
</html>