<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@include file="./base.jsp"%>
<meta charset="UTF-8">
<title>Add Location</title>
</head>
<body>
<div>

		<h1 class="text-center mt-5">Add Location of your Restaurant</h1>

		<form class="card container mt-5 py-3" style="width:500px" action="${pageContext.request.contextPath }/locationadded/${oid }" method="post">
			<div class="form-group">
				<label for="locationName">Location Name</label> <input type="text"
					class="form-control" id="locationName" aria-describedby="locationname"
					placeholder="Enter location" name="location" required>
			</div>
			<div class="container text-center mt-3">
				<button type="submit" class="btn btn-outline-success">Submit</button>
			</div>
		</form>
	</div>
</body>
</html>