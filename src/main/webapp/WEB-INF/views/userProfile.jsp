<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Profile</title>
</head>
<body>
	<h1>My Profile</h1>
	<table>
		<thead>
			<tr>
				<th>User Id</th>
				<th>User Name</th>
				<th>Mobile Number</th>
				<th>Email-Id</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${profile.uid }</td>
				<td>${profile.userName }</td>
				<td>${profile.number }</td>
				<td>${profile.email }</td>
			</tr>
		</tbody>
	</table>
	<button><a href="${pageContext.request.contextPath }/deleteuser/${profile.uid }">Delete Account</a></button>
	<button><a href="${pageContext.request.contextPath }/getuser/${profile.uid }">Update Account</a></button>
</body>
</html>