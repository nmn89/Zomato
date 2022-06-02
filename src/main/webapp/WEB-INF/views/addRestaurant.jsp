<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@page isELIgnored="false"%>
<%@include file="./base.jsp"%>
<meta charset="UTF-8">
<title>Add Restaurant</title>
</head>
<body>
	<div>

		<h1 class="text-center mt-5">Add Restaurant</h1>

		<form class="card container mt-5 py-3" style="width: 500px"
			action="${pageContext.request.contextPath }/restaurantadded/${oid }"
			method="post">
			<div class="form-group">
				<label for="restaurantName">Restaurant Name</label> <input
					type="text" class="form-control" id="restaurantName"
					aria-describedby="restaurantname"
					placeholder="Enter your Restaurant name" name="restaurantName"
					required>
			</div>
			<input type="hidden" value="${lid }" name="locationId" /> <input
				type="hidden" value="${oid }" name="ownerId" />
			<div class="container text-center mt-3">
				<button type="submit" class="btn btn-success">Submit</button>
			</div>
		</form>
	</div>
</body>
</html>