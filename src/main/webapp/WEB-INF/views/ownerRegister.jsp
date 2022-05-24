<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Owner Registration</title>
</head>
<body>
	<div>

		<h1>Owner Registration</h1>

		<form action="owner" method="post">
			<div>
				<label for="ownerName">Owner Name</label> <input type="text"
					class="form-control" id="ownerName" aria-describedby="ownername"
					placeholder="Enter your name" name="ownerName" required>
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
					placeholder="Enter mobile no." name="mobileNo" required>
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