<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<style>  
.dropbtn {  
    background-color: white;  
    color: black;  
    padding: 10px;  
    font-size: 12px;  
}  
.dropdown {  
    display: inline-block;  
    position: relative  
}  
.dropdown-content {  
    position: absolute;  
    background-color: white;  
    min-width: 200px;  
    display: none;  
    z-index: 1;  
}  
.dropdown-content a {  
    color: black;  
    padding: 12px 16px;  
    text-decoration: none;  
    display: block;  
}  
.dropdown-content a:hover {  
    background-color: grey;  
}  
.dropdown:hover .dropdown-content {  
    display: block;  
}  
.dropdown:hover .dropbtn {  
    background-color: grey;  
}  
</style>
<head>
<meta charset="UTF-8">
<title>Availiable Locations</title>
</head>
<body>
<h1>Availiable Locations</h1>
<div class="dropdown">  
<button class="dropbtn">Select Location</button>  
<div class="dropdown-content">  
<c:forEach items="${locations }" var="l">
							<a href="${pageContext.request.contextPath }/addrestaurant/${l.locationId }/${id }">${l.location }</a>
</c:forEach>
</div>  
</div>  
<%-- <label for="locations">Choose a location:</label>
<select name="locations">
<c:forEach items="${locations }" var="l">
<option value="href="${pageContext.request.contextPath }/addrestaurant/${l.locationId }/${id }"">${l.location }</option>
</c:forEach>
</select> --%> 
<%-- <ul>
<c:forEach items="${locations }" var="l">
							<li><a href="${pageContext.request.contextPath }/addrestaurant/${l.locationId }/${id }">${l.location }</a></li>
</c:forEach>
</ul> --%>
</body>
</html>