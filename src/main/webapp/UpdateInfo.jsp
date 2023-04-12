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
	
		#change-info{
			margin: 60px;
		    color: rgb(229, 163, 166);
		    font-weight: bold;
		    font-size: 20px;
		    display: grid;
		    justify-content: center;
		}
				
		.save{
			padding-top: 18px;
			text-align: center;
		}
		
		.save input{
		 	text-align: center;
		 	padding: 0px 10px;
		 	color: rgb(229, 163, 166);
		    font-family: Courier New;
		    font-weight: bold;
		    font-size: 15px;
		    width: 132px;
		    height: 40px;
		}
		
		
	</style>			
	<link rel="stylesheet" type="text/css" href="./css/style.css"/>
	
</head>
</head>
<body>

	<div class="container">
	
	<jsp:include page="_header.jsp"></jsp:include>
	<jsp:include page="_menu.jsp"></jsp:include>
	
	<div class="noti">
		<span>${icon}</span>
		<span>${done}</span>
	</div>
	
	<div id="change-info">
			<label>Thay đổi thông tin cá nhân</label>
			<form method="post" action="Update">
				<table class="basic-info">
					<tr>
						<td><p>Tên tài khoản</p></td>
						<td><input type="text" name="userName" value="${userName}" readonly></td>
					</tr>
					<tr>
						<td><p>Số điện thoại</p></td>
						<td><input type="text" name="sdt" value="${sdt}"></td>
					</tr>
					<tr>
						<td><p>Email</p></td>
						<td><input type="email" name="mail" value="${mail}"></td>
					</tr>
					<tr>
						<td><p>Mật khẩu</p></td>
						<td><input type="password" name="password" value="${password}"></td>
					</tr>
					<tr>
						<td colspan="2">
							<div class="save">
								<input type="submit"  value="Cập nhật"/>
								<input type="reset" value="Đặt lại">
							</div>
						</td>
					</tr>
				</table>
			</form>
		</div>
	</div>

</body>
</html>