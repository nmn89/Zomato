<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurant Dish</title>
</head>
<body>
	<h1>My Restaurant's Dish</h1>
	<table>
		<thead>
			<tr>
				<th>Dish Name</th>
				<th>Dish Price per plate</th>
				<th>Dish Quantity per plate in gm</th>
				<th>                      </th>
			</tr>
		</thead>
		<c:forEach items="${dishes }" var="d">
			<tbody>
				<tr>
					<td>${d.dishName }</td>
					<td>${d.dishPrice }</td>
					<td>${d.quantity }</td>
					<td><button><a href="${pageContext.request.contextPath }/setorder/${uid }/${d.rid }/${d.dId }">Add to Orders</a></button></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
</body>
</html>