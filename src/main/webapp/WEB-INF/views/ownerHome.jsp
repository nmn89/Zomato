<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Owner</title>
</head>
<body>
<h3><a href="ownerprofile/${oid }">Owner Profile</a></h3>
<h3><a href="location/${oid }">Add Restaurant</a></h3>
<a href="${pageContext.request.contextPath }/addlocation">Location not availiable! Add Location</a>
<a href="${pageContext.request.contextPath }/ownerrestaurant/${oid }">My Restaurants</a>
</body>
</html>