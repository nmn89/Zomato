<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@include file="./base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Profile</title>
</head>
<body>
	<h1 class="text-center my-3 font-weight-bold alert-dark" style="width:70%;margin-left:200px;">My Profile</h1>
	<div class="row" style="width:1300px; margin-top:50px;margin-left:25px">
		<div class="col-md-12">
		<div class="card shadow-lg mt-2" style="margin:50px;width:90%">
			<table class="table my-5" style="margin-left:50px;width:90%;">
				<thead class="thead-dark">
					<tr>
						<th scope="col">User Name</th>
						<th scope="col">Mobile Number</th>
						<th scope="col">Email-Id</th>
						<th scope="col">Default Location</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td scope="row">${profile.userName }</td>
						<td scope="row">${profile.number }</td>
						<td scope="row">${profile.email }</td>
						<td scope="row">${location }</td>
					</tr>
				</tbody>
			</table>
			
			<div class="container text-center mb-4">
				<a class="btn btn-outline-danger">Delete
					Account</a> <a class="btn btn-outline-success ml-4"
					href="${pageContext.request.contextPath }/getuser/${profile.id }">Update
					Account</a>
					<a class="btn btn-outline-success ml-4" href="${pageContext.request.contextPath }//userhome/${profile.id }/${profile.defaultLocationId }">Home</a>
			</div>
			</div>
			<script type="text/javascript">
	function deleteAccount(){
		console.log("hi");
		let result= confirm("Do you really want to delete your Profile");
		if(result){
			window.location.href="${pageContext.request.contextPath }/deleteuser/${profile.id }";
		}	
	}
	</script>
</body>
</html>