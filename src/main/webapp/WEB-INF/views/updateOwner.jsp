<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update Owner</title>
</head>
<body>
<div>

		<h1>Update Owner</h1>

		<form action="${pageContext.request.contextPath }/updateowner" method="post">
		<div>
			<input type="hidden" value="${owner.oid }" name="oid" />
		</div>
			<div>
				<label for="ownerName">Owner Name</label> <input type="text"
					class="form-control" id="ownerName" aria-describedby="ownerName"
					placeholder="Enter your name" name="ownerName" value="${owner.ownerName }">
			</div>
			<div>
				<label for="exampleInputEmail1">Email address</label> <input
					type="email" class="form-control" id="exampleInputEmail1"
					aria-describedby="emailHelp" placeholder="Enter email" name="email"
					value="${owner.email }">
			</div>
			<div>
				<label for="number">Mobile No.</label> <input type="number"
					class="form-control" id="mobileNo" aria-describedby="emailHelp"
					placeholder="Enter mobile no." name="mobileNo" value="${owner.mobileNo }">
			</div>
			<div>
				<label for="userPassword">Password</label> <input type="password"
					class="form-control" id="userPassword" aria-describedby="username"
					placeholder="Enter password" name="password" value="${owner.password }">
			</div>
			<div>
				<button type="submit" class="btn btn-success">Submit</button>
			</div>
		</form>
	</div>
</body>
</html>