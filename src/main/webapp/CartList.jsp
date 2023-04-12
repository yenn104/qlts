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
	
	    .cart{
	    	margin: 60px 12%;
	    	font-size:15px;
	    }
	    
	    .cart tr td{
	    	width:150px;
	    	padding-right:30px;
	    }
	    
	    .cart table{
			border-collapse: collapse;
	    }
	    
	    
	    .cart table tr{
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
	    
	    
	    .select , #selectall{
			width:16px;
			height:16px;
	    }
	    
	    .tieude td.gop{
	    	text-align: left; 
	    	padding:0px 20px 0px 50px;
	    	width:300px;
	    	margin-left:20px ;
	    }
	    
	    #pay form{
	    	margin: 100px 180px;
	    	display: flex;
	    	justify-content: center;
	    	background-color: rgba(0,0,0,0);
	    	border: 1px solid red;
	    }
	    
	    .tongsp {
	    	width: 900px;
  			margin: 20px;
	    	display: flex;
	    	justify-content: center;
	    	
	    }

	    .tongsp p{
	    	  width:60%;
	    }
	    
	    .thanhtoan {
	    	width: 250px;
  			margin: 20px;
	    	display: inline-block;
	    	justify-content: center;
	    	
	    }
	    
	    .thanhtoan a input{
	    	color: rgb(229, 163, 166);
			font-size:18px;
			height: 40px;
			margin: 10px 0px;
			padding: 25px 0px;
    		font-weight: bold;
		    font-family: Courier New, sans-serif;
		    width: 150px;
		    text-align: center;
		    justify-content: center;
		    padding: inherit;
		    background-color: transparent;
			border: rgba(0,0,0,0.5)
	    }
	    
	    
	    .tongtien {
	    	width: 200px;
  			margin: 20px;
	    	display: flex;
	    	justify-content: center;
    	    font-weight: bold;
		    font-size: 18px;
		    color: #ee4d2d;
	    }
	    
	    .tongtien input{
		    font-size: 18px;
		    font-weight: bold;
		    font-family: Courier New, sans-serif;
		    color: #ee4d2d;
	    }

	    
	</style>
				
	<link rel="stylesheet" type="text/css" href="./css/style.css"/>
</head>
<body>
	<div class="container">
	
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>	
	
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<div class="cart">

		 <form method="get" action="Cart" >
		
	 	
			 <table>
				 <tr class="tieude">
					<td colspan="2" class="gop" style="width: 575px;">Sản phẩm</td>
					<td>Đơn giá</td>
					<td>Số lượng</td>
					<td>Số tiền</td>
					<td>Thao tác</td>
				 </tr>
				 
				  <c:forEach items="${cartList}" var="cart" > 
					  <c:forEach items="${productList}" var="product" >
					 	<c:if test="${cart.idProduct == product.id}"> 
						<tr>
							<td>
							<c:set var="user" value="${cart.userName}" scope="page"/>
							<a href="Detail?idProduct=${product.id}&userName=${cart.userName}" class="product-thumb"><img class="hinhanh" src="${product.img}"></a></td> 
							<td style="width:500px; text-align: left;">${product.name}</td>
							<td id="product-price">${product.price}</td>
							<td style="width:200px;">
								<input id="product-quantity-${cart.idCart}" style="width:30px;text-align: center;" type="number" value="${cart.slg}" min="1" max="${product.slg}" />
								<button style="display: contents;" data-id="${cart.idCart}" data-info="${cart.userName}" class="editslg dropbtn" type="button"><i class="fa fa-pencil-square-o dropbtn" style="font-size:16px; color:black"></i></button>
							</td>
							<td id="product-line-price">${product.price * cart.slg}
								<c:set var="slggg" value="${slggg + cart.slg}" scope="page"/>
								<c:set var="total" value="${total + product.price * cart.slg}" scope="page"/>
							</td>
							<td>
								<a href="DeleteProductCartServlet?id=${product.id}&userName=${cart.userName}"><i class="fa fa-trash dropbtn" style="font-size:19px; color:black"></i></a>
							</td> 
				 		</tr>
		 			 	</c:if>
			 		</c:forEach>
			 	</c:forEach>
			 </table>
	 	</form>
	 	
	</div>
	
	 
	 
	<div id="pay" style="dislay:flex;">
		<form method="post" action="Cart">
			<c:if test="${cartList.isEmpty() }" >
			<div class="tongsp" style="text-align:left;">
				<p>Tổng thanh toán (<input style="text-align:center; border: none; background-color: transparent; width: 40px;" type="text" value="0" name="slgofbill" readonly />sản phẩm)</p>
			</div>
			<div class="tongtien">	
				<p style="display: flex;" ><input class="focus-border" style="text-align:right; border: none; background-color: transparent; width: fit-content;" type="text" value="0" name="totalofbill" readonly/>₫</p>
			</div>
			<div class="thanhtoan" style="">				
			   		<a>
			   			<input type="hidden" value="${userName}" name="userName"/>
				   		<input style="background-color:#ee4d2d; color: white" type="submit" name="submit" value="Thanh toán"/>
			   		</a>
			</div>
			
			</c:if>
			<c:if test="${not cartList.isEmpty() }" >
			<div class="tongsp" style="text-align:left;">
				<p>Tổng thanh toán (<input style="text-align:center; border: none; background-color: transparent; width: 40px;" type="text" value="${slggg}" name="slgofbill" readonly />sản phẩm)</p>
			</div>
			<div class="tongtien">	
				<p style="display: flex;" ><input class="focus-border" style="text-align:right; border: none; background-color: transparent; width: fit-content;" type="text" value="${total}" name="totalofbill" readonly/>₫</p>
			</div>
			<div class="thanhtoan" style="">				
			   		<a>
			   			<input type="hidden" value="${userName}" name="userName"/>
				   		<input style="background-color:#ee4d2d; color: white" type="submit" name="submit" value="Thanh toán"/>
			   		</a>
			</div>
			</c:if>
			
		</form>
	</div>



	


 <script type="text/javascript">
	
 	   	<c:set var="slggg" value="0" scope="page" />
		
 	   	<c:set var="total" value="1" scope="page"/>
 	   	
 	   	
 	   	$(".editslg").on("click", function()
 	   	{	
 	   		var user = $(this).data("info");
 	   		var id = $(this).data("id");
 	   		var quantity = $("#product-quantity-"+id).val();
 	   		window.location = "EditSlg?idCart="+id+"&slg="+quantity+"&userName="+user;
 	   	});
 	   	

 </script>
 

 </div>
</body>


</html>