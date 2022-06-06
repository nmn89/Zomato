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
		<div class="card shadow-lg mt-2" style="margin:200px;width:70%">
			<table class="table my-5" style="margin-left:140px;width:70%;">
				<thead class="thead-dark">
					<tr>
						<th scope="col">User Name</th>
						<th scope="col">Mobile Number</th>
						<th scope="col">Email-Id</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td scope="row">${profile.userName }</td>
						<td scope="row">${profile.number }</td>
						<td scope="row">${profile.email }</td>
					</tr>
				</tbody>
			</table>
			
			<div class="container text-center mb-4">
				<a class="btn btn-outline-danger"
					href="${pageContext.request.contextPath }/deleteuser/${profile.id }">Delete
					Account</a> <a class="btn btn-outline-success ml-4"
					href="${pageContext.request.contextPath }/getuser/${profile.id }">Update
					Account</a>
			</div>
			</div>
</body>
</html>