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
<h2 class="text-center mb-3">Ordered Dish</h2>
	<div class="row px-5">
		<div class="col-md-12">
			<table class="table">
				<thead class="thead-dark">
					<tr>
						<th scope="col">Dish Name</th>
						<th scope="col">Date</th>			
					</tr>
				</thead>
				<c:forEach items="${orders }" var="o">
					<tbody>
						<tr>
							<td scope="row">${o.dishName }</td>
							<td scope="row">${o.date }</td>
						</tr>
					</tbody>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>