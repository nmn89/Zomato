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
<h1 class="text-center my-3 font-weight-bold alert-dark" style="width:70%;margin-left:200px;">Ordered Dish</h1>
	<div class="row px-5">
		<div class="col-md-12">
		<div class="card shadow-lg mt-5">
			<table class="table mx-5 my-4" style="width:90%;">
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
	</div>
</body>
</html>