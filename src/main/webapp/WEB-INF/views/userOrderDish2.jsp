<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page isELIgnored="false" %>
    <%@include file="./base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ordered Dish</title>
</head>
<body>
<h1>Ordered Dish</h1>
<table>
		<thead>
			<tr>
				<th>Order No.</th>
				<th>Dish Name</th>
				<th>Date</th>
				<th>Quantity</th>
			</tr>
		</thead>
		<c:forEach items="${orders }" var="o">
			<tbody>
				<tr>
					<td>${o.odid }</td>
					<td>${o.dishName }</td>
					<td>${o.restaurantName }</td>
					<td>${o.orderDate }</td>
				</tr>
			</tbody>
		</c:forEach>
	</table>

</body>
</html>