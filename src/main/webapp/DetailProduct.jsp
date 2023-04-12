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
	<style type="text/css">
		.hoho{
			font-size:14px;
		}
	</style>			
	<link rel="stylesheet" type="text/css" href="./css/style.css"/>
</head>
<body>
	
	<div class="container">
	
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>	
	
	
	<div id="detail-product">
		<div class="detail-img">  				
  				<img src="${img}" alt="...">
   		</div>
   		<div class="detail-info">
   				<p class="detail-name">${nameproduct}</p>
   				<p class="detail-price">Giá: ${price}</p>
   				<p class="detail-type">Loại: ${type}</p>
   				<p class="detail-quality">Số lượng còn: ${slg} </p>
   				
   				<c:if test="${ not userName.isEmpty()}">
   					<a href="AddProductCart?idProduct=${id}&userName=${userName}" class="cart1">Add to Cart</a>
   				</c:if>
   				<c:if test="${userName.isEmpty()}">
   					<p class="cart1">Sign in to add to cart</p>
   				</c:if>
   				
   		</div>
		
		
	</div>
	
	<div id="detail-mota">
		<p style="padding:0px 0px 0px -5px;">
			Thông tin chi tiết về sản phẩm:
		<br>
		<br>
 			${detail} </p>
	</div>
	
	
	
	</div>
</body>
</html>