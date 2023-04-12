<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product</title>
	<link rel="icon" href="./images/logo.png" type="image/x-icon">
	<link rel="stylesheet" type="text/css" href="./css/style.css"/>
		<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" 
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
		crossorigin="anonymous">
		
	<style type="text/css">
		
		.tpadmin{
			width:95%;
			margin: 40px;
		}
		
		.proadmin td{
			text-align: center;
		}
		
		.cpadmin{
			background-color: pink;
		    display: flex;
		    padding: 20px 0px;
		    margin: 0px 30px 40px 40px;
		    justify-content: center;
		}
		
		.onee{
			margin: 0px 50px;
			color: black;
			font-size: 20px;
		}
		
	</style>
		
</head>
<body>
<div class="p-3 mb-2 bg-secondary text-white">
 	
	
<div  align="center" class="container" style="max-width: fit-content; margin: 0px 40px;">

	<div class="cpadmin">
		<a class="onee" href="home" title="Trang chủ website">Trang chủ</a>
		<a class="onee" href="Admin.jsp" title="Trang quản lý">Quản lý</a>
		<a class="onee" href="newProductServlet">Create Product</a>
	</div>
 
 
	<h3  align="center" style="color: pink">DANH SÁCH SẢN PHẨM</h3>
	<c:if test="${productList.isEmpty() }" >
		<p class="error" style="color: pink ;">${errorString}</p>
	</c:if>	
	
	<table class="tpadmin" border="1" cellpadding="9" cellspacing="1">
		<tr class="table-danger">
			<th style="color: black">ID</th>
			<th style="color: black">Name</th>
			<th style="color: black">Type</th>
			<th style="color: black">Quality</th>
			<th style="color: black">Price</th>
			<th style="color: black">Detail</th>
			<th style="color: black">Img</th>
			<th style="color: black">Edit</th>
			<th style="color: black">Delete</th>
		</tr>
		<c:forEach items="${productList}" var="product">
			<tr class="table-danger proadmin">
				<td style="color: black">${product.id}</td>
				<td style="color: black; width:200px; text-align: left;">${product.name}</td>
				<td style="color: black"> ${product.type}</td>
				<td style="color: black"> ${product.slg}</td>
				<td style="color: black">${product.price}</td>
				<td style="color: black;text-align: justify;">${product.detail}</td>
				<td style="color: black;"><img style=" width:250px;" src="${product.img}"/></td>
				<td>
				  	<a href="editProductServlet?id=${product.id}&name=${product.name}&type=${product.type}&slg=${product.slg}&price=${product.price}&detail=${product.detail}&img=${product.img}">Edit</a> 
				 </td>
				 <td>
				 	<a href="DeleteProductServlet?id=${product.id}">Delete</a>
				 </td>
				
			</tr>
		</c:forEach>
	</table>
</div>


	
</div>
</body>
</html>