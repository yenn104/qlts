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
			.viewdtt{
				width: 900px;
    			margin: 50px 14%;
			}
			
			.viewdtt table{
				width: 900px;
				text-align: center;
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

	<div class="viewdtt">
 	<div class="tieudee">
 	<h3 style="font-weight: bold;">BILL LIST FOR ${nam}/${thang}</h3>
 	</div>
	 <c:if test="${billList.isEmpty() }" >
		<p class="error">${errorString}</p>	
	</c:if>	
 
	 <table border="1" cellpadding="5" cellspacing="1" >
		 <tr class="table-danger">
			 <th>Mã hóa đơn</th>
			 <th>Số lượng</th>
			 <th>Tổng</th>
			 <th>Ngày</th>
			 <th>Khách hàng</th>
			 <th>Xem chi tiết</th>
		 
		 </tr>
		 <c:forEach items="${billList}" var="bill" >
			 <tr>
				 <td>#${bill.idBill}</td>
				 <td>${bill.slg}</td>
				 <td>${bill.totalPrice}</td>
				 <td>${bill.date }</td>
				 <td>${bill.userName }</td>
				 <td>
					 <a href="BillDetail?idBill=${bill.idBill}&userName=${userName}"> <i class="fa fa-eye dropbtn" style="font-size:16px; color:black"></i> </a>
				 </td>
			</tr>
		 </c:forEach>
	 </table>
 <br>
 <br>
 </div>
 </div>
 
</body>
</html>