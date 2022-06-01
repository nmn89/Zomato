<!DOCTYPE html>
<html>
<head>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@include file="./base.jsp"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*,java.text.*"%>
<meta charset="UTF-8">
<title>Add Order</title>
</head>
<body>
	<%
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	String newDate = df.format(new Date());
	%>
	<h1 class="text-center mt-5">Add order</h1>

	<form class="card container mt-5 py-3" style="width: 500px"
		action="${pageContext.request.contextPath }/addorder/${uid }/${rid }" method="post">

		<div class="form-group">
			<label for="uid">User Id</label> <input type="text"
				class="form-control" id="uid" aria-describedby="uid" name="uid"
				value="${uid }" readOnly>
		</div>
		<div class="form-group">
			<label for="date">Date of Order</label> <input type="text"
				class="form-control" id="date" aria-describedby="date" name="date"
				value="<%=newDate%>" readOnly>
		</div>
		<div class="form-group">
			<label for="rid">Restaurant Id</label> <input type="text"
				class="form-control" id="rid" aria-describedby="rid" name="rid"
				value="${rid }" readOnly>
		</div>
		<div class="container text-center mt-3">
			<button type="submit" class="btn btn-success">Place Order</button>
		</div>
	</form>
</body>
</html>