<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Order</title>
</head>
<body>
<h1>My Orders</h1>
	<table>
		<thead>
			<tr>
				<th>Order No.</th>
				<th>Order Date</th>
				<th>Restaurant Name</th>
				<th>Dish Name</th>
				<th>   </th>
				<th>   </th>
			</tr>
		</thead>
		<c:forEach items="${orders }" var="o">
			<tbody>
				<tr>
					<td>${o.orid }</td>
					<td>${o.date }</td>
					<td>${o.restaurantName }</td>
					<td>${o.dishName }</td>
					<td><button><a href="${pageContext.request.contextPath }/deleteorder/${o.orid }/${uid }">Delete Order</a></button></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
</body>
</html>