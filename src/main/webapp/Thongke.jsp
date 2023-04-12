<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>BILL LIST</title>
 <link rel="icon" href="./images/logo.png" type="image/x-icon">
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css" 
		integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
		crossorigin="anonymous">
		
		<style type="text/css">
			.viewdt{
				width: 800px;
    			margin: 50px 14%;
			}
			
			.tieudee{
				text-align:center;
				font-family: Courier New, sans-serif;
				font-weight: bold;
				margin: 50px;
			}

		</style>
	
</head>
<body>



<div class="container">

 	
 	<div class="viewdt">
	 	<div class="tieudee">
	 		<h3 style="font-weight: bold;">THỐNG KÊ DOANH THU</h3>
	 	</div>
 	
		 <table border="1" cellpadding="5" cellspacing="1" style="text-align:center;" >
			 <tr class="table-danger">
			 	 <th style="width:80px">Năm</th>
				 <th>Tháng</th>
				 <th>Số lượng đơn hàng</th>
				 <th>Số lượng sản phẩm bán được</th>
				 <th>Doanh thu của tháng</th>
				 <th>Xem chi tiết</th>
			 </tr>
			
			 <c:forEach items="${doanhthuList}" var="dt" >
			 
			 	<c:if test="${dt.nam == yearcur}" >
			 	</c:if>
			 	<c:if test="${dt.nam != yearcur}" >
					 <tr style="text-align:left;">
					 	<td colspan="6" style="padding-left: 24px; background-color:cornsilk;">${dt.nam}</td>
					 </tr>
			 	</c:if>
			 <tr>	
			 	 <td></td>
				 <td>${dt.thang}</td>
				 <td>${dt.tongdon}</td>
				 <td>${dt.tongsp}</td>
				 <td>${dt.dthu }</td>
				 <td>
					<a href="ThongkeDetail?nam=${dt.nam}&thang=${dt.thang}"> <i class="fa fa-eye dropbtn" style="font-size:16px; color:black"></i> </a>
				 </td>
			</tr>
			 <c:set var="yearcur" value="${dt.nam}" scope="page" />
			 </c:forEach>
		 </table>
 
 	</div>
 
<script type="text/javascript">
 	   	<c:set var="yearcur" value="0" scope="page" />
 	   	<c:set var="slg" value="1" scope="page" />
</script>
 
 
 </div>
 
</body>
</html>