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
				<th>   </th>
				<th>   </th>
			</tr>
		</thead>
		<c:forEach items="${orders }" var="o">
			<tbody>
				<tr>
					<td>${o.orId }</td>
					<td>${o.date }</td>
					<td>${o.restaurantName }</td>
					<td><button><a href="${pageContext.request.contextPath }/getorderdish/${o.orId }">Show Ordered Dish</a></button></td>
					<td><button><a href="${pageContext.request.contextPath }/deleteorder/${o.orId }/${uid }">Delete Order</a></button></td>
				</tr>
			</tbody>
		</c:forEach>
	</table>
</body>
</html>