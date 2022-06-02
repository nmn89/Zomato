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
	<h1 class="text-center my-3 font-weight-bold">My Profile</h1>
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">User Id</th>
						<th scope="col">User Name</th>
						<th scope="col">Mobile Number</th>
						<th scope="col">Email-Id</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td scope="row">${profile.id }</td>
						<td scope="row">${profile.userName }</td>
						<td scope="row">${profile.number }</td>
						<td scope="row">${profile.email }</td>
					</tr>
				</tbody>
			</table>
			<div class="container text-center mt-3">
				<a class="btn btn-outline-danger"
					href="${pageContext.request.contextPath }/deleteuser/${profile.id }">Delete
					Account</a> <a class="btn btn-outline-success"
					href="${pageContext.request.contextPath }/getuser/${profile.id }">Update
					Account</a>
			</div>
</body>
</html>