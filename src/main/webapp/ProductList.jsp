<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="vi">
<head>
		<meta charset="ISO-8859-1">
		<meta charset="UTF-8">
		
<title>HY Jewelry</title>
	<link rel="icon" href="./images/logo.png" type="image/x-icon">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">		
	<style type="text/css"></style>			
	<link rel="stylesheet" type="text/css" href="./css/style.css"/>
	
</head>
</head>
<body>

	<div class="container">
	
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>
		
		
		
		<div class="links">
			<ul class="list">
					<li><a href="home">Trang Chủ</a> <span>/</span></li>
					<li><a href="home#sanpham">Sản Phẩm</a> <span>/</span></li>
					<li><a>${key}</a></li>
					
			</ul>
		</div>

	<jsp:include page="listProduct.jsp"></jsp:include>
		
		
		<div>
			<a class="dropdown" href="" title="lên đầu trang"><i class="fa fa-chevron-up dropbtn" style="font-size:19px; color:rgb(229, 163, 166); margin-bottom:50px;"></i></a>
		</div>
		
		
	</div>
</body>
</html>