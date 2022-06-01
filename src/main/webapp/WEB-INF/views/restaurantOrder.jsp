<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Restaurant Order</title>
</head>
<body>
<h1>Restaurant's Orders</h1>
	<table>
		<thead>
			<tr>
				<th>Order No.</th>
				<th>Order Date</th>
				<th>Dish Name</th>
				<th>Restaurant Name</th>
				<th>User Name</th>
			</tr>
		</thead>
		<c:forEach items="${orders }" var="o">
			<tbody>
				<tr>
					<td>${o.orid }</td>
					<td>${o.date }</td>
					<td>${o.dishName }</td>
					<td>${o.restaurantName }</td>
					<td>${o.userName }</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
</body>
</html>