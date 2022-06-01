<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@include file="./base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Owner Profile</title>
</head>
<body>
<h1 class="text-center mb-3">Owner Profile</h1>
	<div class="row px-5">
		<div class="col-md-12">
<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Owner Id</th>
				<th scope="col">Owner Name</th>
				<th scope="col">Mobile Number</th>
				<th scope="col">Email-Id</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td scope="row">${owner.oid }</td>
				<td scope="row">${owner.ownerName }</td>
				<td scope="row">${owner.mobileNo }</td>
				<td scope="row">${owner.email }</td>
			</tr>
		</tbody>
	</table>
</div>
</div>
	<div class="container text-center mt-3">
<button class="btn btn-light"><a href="${pageContext.request.contextPath }/deleteowner/${owner.oid }">Delete Account</a></button>
<button class="btn btn-light"><a href="${pageContext.request.contextPath }/getowner/${owner.oid }">Update Account</a></button>
</div>
</body>
</html>