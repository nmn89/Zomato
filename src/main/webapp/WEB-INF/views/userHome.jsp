<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
	<form action="searchrestaurant" method="post">
		<input type="search" placeholder="Search" name="restaurantName">
		<button type="submit">Search</button>
	</form>
	<h3>
		<a href="userprofile/${uid }">User Profile</a>
	</h3>
	<h3>
		<a href="showlocation/${uid }">View Restaurants</a>
	</h3>
	<h3>
		<a href="getorder/${uid }">My Orders</a>
	</h3>
</body>
</html>