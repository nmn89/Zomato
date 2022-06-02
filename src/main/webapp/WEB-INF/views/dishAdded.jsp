<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@include file="./base.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="alert-success media position-relative" style="margin-top: 50;width: 500px;margin-left: 92px;">
  <img src="https://thumbs.dreamstime.com/b/menu-restaurant-food-service-logo-hand-holding-tray-vector-illustration-isolated-white-background-menu-restaurant-food-136082782.jpg" class="mr-3" style="width:150px;height:100px">
  <div class="media-body">
    <h5 class="mt-0">Dish Added Successfully</h5>
    <a href="${pageContext.request.contextPath }/showdish/${rid }" class="stretched-link">Click Here to view my Dishes</a>
  </div>
</div>
</body>
</html>