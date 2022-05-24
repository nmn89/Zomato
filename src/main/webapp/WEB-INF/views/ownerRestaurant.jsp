<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Restaurant</h1>
<ul>
<c:forEach items="${restaurants }" var="r">
							<li><a href="${pageContext.request.contextPath }/adddish/${r.rid }">${r.restaurantName }</a></li>
</c:forEach>
</ul>
</body>
</html>