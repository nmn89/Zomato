<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	    <%@include file="./base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Owner Registration</title>
</head>
<body>
<div class="card shadow-lg container mt-5 py-3" style="width:500px">

		<h2 class="text-center my-2">Owner Registration</h2>

		<form method="post">
			<div class="form-group">
				<label for="ownerName">Owner Name</label> <input type="text"
					class="form-control" id="ownerName" aria-describedby="ownername"
					placeholder="Enter your name" name="ownerName" required>
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
					placeholder="Enter mobile no." name="mobileNo" required>
			</div>
			<div class="form-group">
				<label for="userPassword">Password</label> <input type="password"
					class="form-control" id="userPassword" aria-describedby="username"
					placeholder="Enter password" name="password" required>
			</div>
			<div class="container text-center mt-3">
				<button type="submit" class="btn btn-outline-primary">Submit</button>
			</div>
		</form>
	</div>
	<script type="text/javascript">
	let myButton=document.querySelector('button');
	myButton.onclick=function(){
		let form = document.querySelector('form');
		form.addEventListener("submit",function(e){
			e.preventDefault();
			alert("Your Account Created Successfully");
			form.action="owner";
			form.submit();
		})
	};
	</script>
</body>
</html>