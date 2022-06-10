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
<h1 class="text-center my-3 font-weight-bold alert-dark" style="width:70%;margin-left:200px;">Owner Profile</h1>
	<div class="row px-5">
		<div class="col-md-12">
		<div class="card shadow-lg mt-5">
<table class="table mx-5 my-4" style="width:90%;">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Owner Name</th>
				<th scope="col">Mobile Number</th>
				<th scope="col">Email-Id</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td scope="row">${owner.ownerName }</td>
				<td scope="row">${owner.mobileNo }</td>
				<td scope="row">${owner.email }</td>
			</tr>
		</tbody>
	</table>
	</div>
</div>
</div>
	<div class="container text-center mt-5">
<a onclick="deleteAccount()" class="btn btn-outline-danger">Delete Account</a>
<a class="btn btn-outline-primary ml-3" href="${pageContext.request.contextPath }/getowner/${owner.id }">Update Account</a>
</div>
<script type="text/javascript">
	function deleteAccount(){
		console.log("hi");
		let result= confirm("Do you really want to delete your Profile");
		if(result){
			window.location.href="${pageContext.request.contextPath }/deleteowner/${owner.id }";
		}	
	}
	</script>
</body>
</html>