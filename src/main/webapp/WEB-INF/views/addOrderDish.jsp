<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored="false" %>
    <%@ page import = "java.io.*,java.util.*, javax.servlet.*,java.text.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Dish</title>
</head>
<body>
<%DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
String newDate = df.format(new Date()); 
%>
<h1>Order Dish</h1>
<form action="${pageContext.request.contextPath }/orderdishadded" method="post">
			
			<div>
				<label for="uid">User Id</label> <input type="text"
					class="form-control" id="uid" aria-describedby="uid"
					name="uId" value="${uid }" readOnly>
			</div>
			<div>
				<label for="date">Date of Order</label> <input type="text"
					class="form-control" id="date" aria-describedby="date"
					name="date" value="<%=newDate %>" readOnly>
			</div>
			<div>
				<label for="rid">Restaurant Id</label> <input type="text"
					class="form-control" id="rid" aria-describedby="rid"
					name="rId" value="${rid }" readOnly>
			</div>
			<div>
				<label for="did">Dish Id</label> <input type="text"
					class="form-control" id="did" aria-describedby="did"
					name="dId" value="${dId }" readOnly>
			</div>
			<div>
				<label for="dName">Dish Name</label> <input type="text"
					class="form-control" id="dName" aria-describedby="dName"
					name="dishName" value="${dish }" readOnly>
			</div>
			<div>
				<label for="orid">Order Id</label> <input type="text"
					class="form-control" id="orid" aria-describedby="orid"
					name="orId" value="${orid }" readOnly>
			</div>
			<div>
				<label for="quantity">Quantity</label> <input type="text"
					class="form-control" id="quantity" aria-describedby="quantity"
					name="quantity" required>
			</div>
			<div>
				<button type="submit" class="btn btn-success">Place Order</button>
			</div>
		</form>
</body>
</html>