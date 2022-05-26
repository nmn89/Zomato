<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<%@ page import = "java.io.*,java.util.*, javax.servlet.*,java.text.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Order</title>
</head>
<body>
<%DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
String newDate = df.format(new Date()); 
%>
<h1>Add order</h1>

		<form action="${pageContext.request.contextPath }/addorder" method="post">
			<div>
				<label for="uid">User Id</label> <input type="text"
					class="form-control" id="uid" aria-describedby="uid"
					name="uid" value="${uid }" readOnly>
			</div>
			<div>
			<input type="hidden" value="${user }" name="userName" />
			</div>
			<div>
				<label for="date">Date of Order</label> <input type="text"
					class="form-control" id="date" aria-describedby="date"
					name="date" value="<%=newDate %>" readOnly>
			</div>
			<div>
				<label for="rid">Restaurant Id</label> <input type="text"
					class="form-control" id="rid" aria-describedby="rid"
					name="rid" value="${rid }" readOnly>
			</div>
			<div>
				<label for="rname">Restaurant Name</label> <input type="text"
					class="form-control" id="rname" aria-describedby="rname"
					name="restaurantName" value="${restaurant }" readOnly>
			</div>
			<div>
				<label for="did">Dish Id</label> <input type="text"
					class="form-control" id="rid" aria-describedby="rid"
					name="did" value="${dId }" readOnly>
			</div>
			<div>
				<label for="dname">Dish Name</label> <input type="text"
					class="form-control" id="rname" aria-describedby="dname"
					name="dishName" value="${dish }" readOnly>
			</div>
			<div>
				<label for="quantity">Quantity of Dish</label> <input type="text"
					class="form-control" id="quantity" aria-describedby="quantity"
					name="quantity">
			</div>
			<div>
				<button type="submit" class="btn btn-success">Submit</button>
			</div>
		</form>
</body>
</html>