<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Owner Profile</title>
</head>
<body>
<h1>Owner Profile</h1>
<table>
		<thead>
			<tr>
				<th>Owner Id</th>
				<th>Owner Name</th>
				<th>Mobile Number</th>
				<th>Email-Id</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>${owner.oid }</td>
				<td>${owner.ownerName }</td>
				<td>${owner.mobileNo }</td>
				<td>${owner.email }</td>
			</tr>
		</tbody>
	</table>
<button><a href="${pageContext.request.contextPath }/deleteowner/${owner.oid }">Delete Account</a></button>
<button><a href="${pageContext.request.contextPath }/getowner/${owner.oid }">Update Account</a></button>
</body>
</html>