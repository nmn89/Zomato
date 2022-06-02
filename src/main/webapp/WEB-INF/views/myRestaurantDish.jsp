<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@include file="./base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurant Dish</title>
</head>
<body>
	<h1 class="text-center my-3">My Restaurant's Dish</h1>
	<div class="row px-5">
		<div class="col-md-12">
<table class="table">
		<thead class="thead-dark">
			<tr>
				<th scope="col">Dish Name</th>
				<th scope="col">Dish Price per plate</th>
				<th scope="col">Delete Dish</th>
			</tr>
		</thead>
		<c:forEach items="${dishes }" var="d">
			<tbody>
				<tr>
					<td scope="row">${d.dishName }</td>
					<td scope="row">${d.dishPrice }</td>
					<td scope="row"><a href="${pageContext.request.contextPath }/removedish/${d.id }/${rid }" class="badge badge-danger">Delete Dish</a></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	</div>
	</div>
</body>
</html>