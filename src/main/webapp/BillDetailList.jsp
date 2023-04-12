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
		#chao{
			margin: 50px 0px 10px 0px;
			color: rgb(229, 163, 166);
			font-weight: bold;
			font-size: 16px;
		}
		
		.detail{
		   	margin: 60px 12%;
		   	font-size:15px;
		   }
		   
		.detail tr td{
		   	width:150px;
		   	padding-right:30px;
		   }
		   
		.detail table{
			border-collapse: collapse;
		   }
		   
		   
		.detail table tr{
		   	border: 0.1px solid rgb(241 192 183);
		   }
		   
		   
		.hinhanh {
			width:160px;
			margin: 10px 30px;
		   }
		   
		.tieude td{
		   	height: 90px;
		   	margin: 40px 0px;
		   }
		   
		.tieude input{
		   	margin-right: 20px;
		   }
		
	</style>			
	<link rel="stylesheet" type="text/css" href="./css/style.css"/>
</head>
<body>
	
	<div class="container">
	
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>	
	
	
	<div id="chao">
		<h4>Chi tiết hóa đơn #${idBill}</h4>
	</div>
	
	
	<div class="detail">
		 <table>
			<tr class="tieude">
				<td>STT</td>
				<td colspan="2" style="text-align:left; padding-left: 68px;">Sản phẩm</td>
				<td>Số tiền</td>
				<td>Số lượng</td>
			</tr>
			 
			<c:forEach items="${billDetailList}" var="detail" > 
			<c:forEach items="${productList}" var="product" >
		 	<c:if test="${detail.idProduct == product.id}"> 
			<tr>
				<td>
					<c:set var="count" value="${count + 1}" scope="page"/>
					<c:out value = "${count}"/> 
				</td>
				<td>
					<a href="Detail?idProduct=${product.id}&userName=${userName}" class="product-thumb"><img class="hinhanh" src="${product.img}"></a>
				</td> 
				<td style="width:500px; text-align: left;">${product.name}</td>
				<td id="product-price">${product.price}</td>
				<td id="product-quantity">${detail.slg}</td>
	 		</tr>
 		
 			 </c:if>
		 	</c:forEach>
		 	</c:forEach>
		 </table>
	
	</div>
	
<script>

		<c:set var="count" value="0" scope="page" />

</script>	
	
	</div>
	
</body>
</html>
