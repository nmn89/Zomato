<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>

		<h1>Add Location of your Restaurant</h1>

		<form action="locationadded" method="post">
			<div>
				<label for="locationName">Location Name</label> <input type="text"
					class="form-control" id="locationName" aria-describedby="locationname"
					placeholder="Enter location" name="location" required>
			</div>
			<div>
				<button type="submit" class="btn btn-success">Submit</button>
			</div>
		</form>
	</div>
</body>
</html>