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
		.links{
	    	margin: 0px 9%;
	    	margin-top: 60px;
		    margin-bottom: 8px;
		    height: auto;
	    }
	    
	    #sanpham{
			width:100%;
			margin-top: 60px;
			}
			
		#sanpham ul.products{
			margin: 6% 9%;		
		}
	</style>			
	<link rel="stylesheet" type="text/css" href="./css/style.css"/>
	
</head>
</head>
<body>
			<div id="sanpham">
	 		<c:if test="${productList.isEmpty() }" >
	 			<p class="error">${errorString}</p>	
	 		</c:if>			
			<ul class="products">
				<c:forEach items="${productList}" var="product" >
					   <li>
					      <div class="product-item">
					      		<div class="product-top">
				      				<a href="Detail?idProduct=${product.id}&userName=${name}" class="product-thumb">
				      					<img src="${product.img}" alt="..."></a>
					   				<c:if test="${ name.length() > 0 }">
					   					<a href="AddProductCart?idProduct=${product.id}&userName=${name}" class="cart">Add to Cart</a>
					   				</c:if>
					   				<c:if test="${ name == null }">
					   					<p class="cart">Sign in to add to cart</p>
					   				</c:if>
					      		</div>
						      	<div class="product-info">
						      		<a href="Detail?idProduct=${product.id}&userName=${name}" class="product-name">${product.name}</a>
						      		<div class="product-price">${product.price}</div>
						      	</div>
					      </div>
					   </li>
			   </c:forEach> 
		  	</ul>
		</div>
</body>
</html>