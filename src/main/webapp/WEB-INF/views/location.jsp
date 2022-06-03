<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@include file="./base.jsp"%>
<!DOCTYPE html>
<html>
<style>
.dropbtn {
	background-color: white;
	color: black;
	padding: 10px;
	font-size: 12px;
}

.dropdown {
	display: inline-block;
	position: relative
}

.dropdown-content {
	position: absolute;
	background-color: white;
	min-width: 200px;
	display: none;
	z-index: 1;
}

.dropdown-content a {
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
}

.dropdown-content a:hover {
	background-color: grey;
}

.dropdown:hover .dropdown-content {
	display: block;
}

.dropdown:hover .dropbtn {
	background-color: grey;
}
</style>
<head>
<meta charset="UTF-8">
<title>Add Restaurant</title>
</head>
<body>
<div class="card container mt-5 py-3" style="width: 500px">
<h1 class="text-center mt-5">Add Restaurant</h1>
	<form class="container mt-5 py-3" style="width: 500px"
		action="${pageContext.request.contextPath }/restaurantadded/${oid }"
		method="post">
		<div class="form-group">
			<label for="restaurantName">Restaurant Name</label> <input
				type="text" class="form-control" id="restaurantName"
				aria-describedby="restaurantname"
				placeholder="Enter your Restaurant name" name="restaurantName"
				required>
		</div>
		<label for="restaurantName">Select Location</label>
		<select name="locationId" id="locationId">
		<c:forEach items="${locations }" var="l">
    <option value="${l.id }">${l.location }</option>
    </c:forEach>
  </select>
<input type="hidden" value="${oid }" name="ownerId" />
		<div class="container text-center mt-3">
			<button type="submit" class="btn btn-success">Submit</button>
		</div>
	</form>
	</div>
</body>
</html>