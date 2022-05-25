<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Restaurant</title>
</head>
<body>
	<div>

		<h1>Add Restaurant</h1>

		<form action="${pageContext.request.contextPath }/restaurantadded/${oid }" method="post">
			<div>
				<label for="restaurantName">Restaurant Name</label> <input type="text"
					class="form-control" id="restaurantName" aria-describedby="restaurantname"
					placeholder="Enter your Restaurant name" name="restaurantName" required>
			</div>
			<input type="hidden" value="${lid }" name="locatonId" />
			<input type="hidden" value="${oid }" name="oid" />
			<div>
				<button type="submit" class="btn btn-success">Submit</button>
			</div>
		</form>
	</div>
</body>
</html>