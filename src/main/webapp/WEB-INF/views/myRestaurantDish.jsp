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
	<h1 class="text-center my-3 font-weight-bold alert-dark" style="width:70%;margin-left:200px;">${restaurant.restaurantName }'s Dish</h1>
	<div class="row px-5">
		<div class="col-md-12">
		<div class="card shadow-lg mt-5">
<table class="table mx-5 my-4" style="width:90%;">
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
					<td scope="row"><button onclick="confirm(${d.id })" class="badge badge-danger">Delete Dish</button></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
	</div>
	</div>
	</div>
	<script type="text/javascript">
	function confirm(id){
		console.log("hi");
		let result= confirm("Do you really want to delete Dish");
		if(result){
			window.location.href="${pageContext.request.contextPath }/removedish/id/${restaurant.id }";
		}	
	}
	</script>
</body>
</html>