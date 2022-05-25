<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Dish</title>
</head>
<body>
<div>

		<h1>Add Dish</h1>

		<form action="${pageContext.request.contextPath }/dishadded/${rid}" method="post">
			<div>
				<label for="dishName">Dish Name</label> <input type="text"
					class="form-control" id="dishName" aria-describedby="dishname"
					placeholder="Enter your Dish name" name="dishName" required>
			</div>
			<div>
				<label for="dishPrice">Dish Price</label> <input type="text"
					class="form-control" id="dishPrice" aria-describedby="dishPrice"
					placeholder="Enter Dish price per plate" name="dishPrice" required>
			</div>
			<div>
				<label for="quantity">Quantity</label> <input type="text"
					class="form-control" id="quantity" aria-describedby="quantity"
					placeholder="Enter quantity of dish" name="quantity" required>
			</div>
			<input type="hidden" value="${rid }" name="rid" />
			<div>
				<button type="submit" class="btn btn-success">Submit</button>
			</div>
		</form>
	</div>
</body>
</html>