<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HY Jewelry</title>
<link rel="icon" href="./images/logo.png" type="image/x-icon">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style type="text/css"></style>
<link rel="stylesheet" type="text/css" href="./css/admin.css" />
</head>
<body>
	<div class="contrainer">
		<div class="menu">
			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<a class="navbar-brand" href="#">STAFF</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbarSupportedContent"
					aria-controls="navbarSupportedContent" aria-expanded="false"
					aria-label="Toggle navigation">
					<span class="navbar-toggler-icon"></span>
				</button>

				<div class="collapse navbar-collapse" id="navbarSupportedContent">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item active"><a class="nav-link" href="index.jsp">TRANG CHỦ <span class="sr-only">(current)</span>
						</a></li>
						
						<li class="nav-item">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> QUẢN LÝ SẢN PHẨM </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="ProductListAdmin">CẬP NHẬT SẢN PHẨM</a> 
							</div></li>
						<li class="nav-item">
						<li class="nav-item dropdown"><a
							class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
							role="button" data-toggle="dropdown" aria-haspopup="true"
							aria-expanded="false"> THỐNG KÊ </a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="dropdown-item" href="ThongkeServlet">THỐNG KÊ DOANH THU</a>
									
							</div></li>
					</ul>
					
			</nav>
		</div>
	</div>
	<div class="jumbotron jumbotron-fluid">
		<div class="container">
			<h1 class="display-4">STAFF ONLY</h1>
			<p class="lead">Tao nhã chính là sự tinh giản</p>
			<nav class="navbar navbar-light bg-light">
				<a class="navbar-brand" href="#"> <img src="./images/logo.png"
					width="30" height="30" class="d-inline-block align-top" alt="">
					HY Jewelry
				</a>
			</nav>
		</div>
	</div>
		
	<div style="text-align:center;">
		<a class="navbar-brand" href="#"> <img src="./images/nenAdmin.jpg" width="80%" class="d-inline-block align-top" alt=""></a>
	</div>
	
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.14.7/dist/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>