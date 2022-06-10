<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page isELIgnored="false"%>
<%@include file="./base.jsp"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*,java.text.*"%>
<!DOCTYPE html>
<html>
<style>
.dropbtn {
	color: black;
	padding: 10px;
	font-size: 12px;
}

.dropdown {
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
</style>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script>
function logout(){
	localStorage.removeItem('load');
	window.location.href="${pageContext.request.contextPath }/";
}
window.addEventListener("load",function(){
	if(localStorage.getItem('load')!=${uid }){
		alert("User LogIn Successfully");
		localStorage.setItem('load',${uid });
	}
})

function refresh(){
	window.location.reload();
}

	$(document).ready(function(){
		$(".viewDish").click(function(){
			var id = $(this).attr("id");
			console.log(id);
			$.getJSON("${pageContext.request.contextPath }/viewdish/"+id, function(result){
				console.log(result);
				var dishes = '';
				$.each(result, function(key,value){
					dishes += '<tbody>';
					dishes += '<tr>';
					dishes += '<td>'+key+'</td>';
					dishes += '<td>'+value+'</td>';
					dishes += '</tr>';
					dishes += '</tbody>';
				    });
				$('table#dish_table').append(dishes);
			});
		});
	});
	</script>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
	<%
	DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	String newDate = df.format(new Date());
	%>
	<nav class="navbar navbar-expand-lg navbar-light bg-info">
		<div class="container-fluid">
			<div width="30" height="24" class="d-inline-block align-text-top">
				<img
					src="https://thumbs.dreamstime.com/b/menu-restaurant-food-service-logo-hand-holding-tray-vector-illustration-isolated-white-background-menu-restaurant-food-136082782.jpg"
					class="mr-3" style="width: 110px; height: 65px">
			</div>
			<form
				action="${pageContext.request.contextPath }/searchrestaurant/${uid }"
				class="d-flex pt-3" style="margin-left: 25px; width: 500px">
				<input class="form-control me-2" type="search" placeholder="Search"
					aria-label="Search" name="restaurantName">
				<button class="btn btn-outline-light ml-2" type="submit">Search</button>
			</form>
			<div class="collapse navbar-collapse" id="navbarSupportedContent"
				style="margin-left: 150px;">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0">
					<li class="nav-item mt-2"><div class="dropdown ">
							<button class="btn-outline-light ">Select Location</button>
							<div class="dropdown-content">
								<c:forEach items="${locations }" var="l">
									<a
										href="${pageContext.request.contextPath }/userhome/${uid }/${l.id }">${l.location }</a>
								</c:forEach>
							</div>
						</div></li>
					<li class="nav-item"><a class="btn btn-outline-light ml-4"
						aria-current="page"
						href="${pageContext.request.contextPath }/getorder/${uid }">My
							Orders</a></li>
					<li class="nav-item"><a class="btn btn-outline-light ml-4"
						href="${pageContext.request.contextPath }/userprofile/${uid }">User
							Profile</a></li>
					<li class="nav-item"><a onclick="logout()"
						class="btn btn-outline-light ml-4" tabindex="-1">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<c:forEach items="${restaurants }" var="r" varStatus="loop">
		<div class="card mt-5 shadow-lg d-inline-flex"
			style="margin-left: 100px; margin-right: 20px; width: 300px; height: 300px">
			<div class="card-img-top">
				<img style="width: 300px"
					src="https://i.ndtvimg.com/i/2015-06/fusion-food_625x350_71434106320.jpg">
			</div>
			<div class="card-body">
				<h5>
					<div>
						<a id="${r.id }" class="viewDish" style="text-decoration: none" data-toggle="modal" data-target="#${r.restaurantName }">${r.restaurantName }</a>
					</div>
				</h5>
				<div class="modal fade" id="${r.restaurantName }" data-backdrop="static" data-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">${r.restaurantName }</h5>
        <button onclick="refresh()" type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <table id="dish_table" class="table">
  <thead class="thead-dark">
    <tr>
      <th scope="col">Dish</th>
      <th scope="col">Dish Price</th>
    </tr>
  </thead>
</table>
</div>
      <div class="modal-footer">
        <button onclick="refresh()" type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>
			</div>
			<div class="card-body">
				<button type="button" class="btn btn-outline-info"
					 data-toggle="modal" data-target="#id_${r.id}">Add Order</button>
			</div>
		</div>
		<div class="modal fade" id="id_${r.id }" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Add Order</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">
						<form class="card container mt-5 py-3" style="width: 450px"
							action="${pageContext.request.contextPath }/addorder/${uid }/${r.id }"
							method="post">
							<div class="form-group">
								<input type="hidden" class="form-control" id="uid"
									aria-describedby="uid" name="userId" value="${uid }" readOnly>
							</div>
							<div class="form-group">
								<label for="date">Restaurant Name</label> <input type="text"
									class="form-control" value="${r.restaurantName }" readOnly>
							</div>
							<div class="form-group">
								<label for="date">Date of Order</label> <input type="text"
									class="form-control" id="date" aria-describedby="date"
									name="date" value="<%=newDate%>" readOnly>
							</div>
							<div class="form-group">
								<input type="hidden" class="form-control" id="rid"
									aria-describedby="rid" name="restaurantId" value="${r.id }"
									readOnly>
							</div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal">Close</button>
						<button type="submit" class="btn btn-primary">Order Food</button>
					</div>
					</form>
				</div>
			</div>
		</div>
		<div class="modal fade" id="exampleModal" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<div class="modal-body">...</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-bs-dismiss="modal">Close</button>
						<button type="button" class="btn btn-primary">Save
							changes</button>
					</div>
				</div>
			</div>
		</div>
	</c:forEach>
</body>
</html>