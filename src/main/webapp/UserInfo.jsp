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
<body>
	<div class="container">
	
		<jsp:include page="_header.jsp"></jsp:include>
		<jsp:include page="_menu.jsp"></jsp:include>
			
			<div id="person-welcome">
				<h4>Xin chào ${userName}</h4>
				<div class="noti" style="margin:10px;">
						<span>${icon}</span>
						<span>${done}</span>
					</div>
			</div>
			
			<div id="user-info">
				<div class="info">
					<label>Thông tin cá nhân</label>
					<table class="basic-info">
						<tr>
							<td><p>Tên tài khoản</p></td>
							<td><input type="text" name="userName" value="${userName}" disabled></td>
						</tr>
						<tr>
							<td><p>Số điện thoại</p></td>
							<td><input type="text" name="sdt" value="${sdt}" disabled></td>
						</tr>
						<tr>
							<td><p>Email</p></td>
							<td><input type="text" name="mail" value="${mail}" disabled></td>
						</tr>
						<tr>
							<td><p>Mật khẩu</p></td>
							<td><input type="password" name="password" value="${password}" disabled></td>
						</tr>
						<tr>
							<td colspan="2" style="text-align: center; padding-top: 18px;" >
								<a class="" title="Thay đổi thông tin" href="Update?userName=${userName}&sdt=${sdt}&mail=${mail}&password=${password}">
									<label style="font-size:15px;">Thay đổi thông tin</label>
									<i class="fa fa-pencil-square-o dropbtn" style="font-size:18px; color:black;"></i>
								</a>		
							</td>
						</tr>
					</table>
				</div>
				<div class="order-history">
					<label>Lịch sử đặt hàng</label>
					<table class="order-info">
						<tr>
							<td><p style="width: 80px;">STT</p></td>
							<td><p style="width: 140px;">Mã hóa đơn</p></td>
							<td><p style="width: 170px;">Số lượng sản phẩm</p></td>
							<td><p style="width: 140px;">Tổng hóa đơn</p></td>
							<td><p style="width: 160px;">Ngày thanh toán</p></td>
							<td><p style="width: 140px;">Xem chi tiết</p></td>
						</tr>
						<c:forEach items="${bill}" var="bill" > 
							<tr>
      							<td>
									<c:set var="count" value="${count + 1}" scope="page"/>
      								<c:out value = "${count}"/> 
      							</td>
      							<td>#${bill.idBill}</td>
								<td>${bill.slg}</td>
								<td>${bill.totalPrice}</td>
								<td>${bill.date}</td>
								<td>
									<a href="BillDetail?idBill=${bill.idBill}&userName=${userName}"> <i class="fa fa-eye dropbtn" style="font-size:16px; color:black"></i> </a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
			
			

<script>

		<c:set var="count" value="0" scope="page" />

</script>

			
	</div>		
</body>
</html>