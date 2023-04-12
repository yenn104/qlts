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
			<table class="table">
		<tr>
			<td width=15%></td>
			<td align="left" width=20%>
				<a class="dropdown" href="https://www.facebook.com/lby2001" title="Bảo Yến" target="_blank"><i class="fa fa-facebook-f dropbtn" style="font-size:18px; color:black"></i></a>	
				<a class="dropdown" href="https://www.facebook.com/ptth1003" title="Thảo Huyền" target="_blank"><i class="fa fa-instagram dropbtn" style="font-size:19px; color:black"></i></a>		
			</td>
			<td align="center">
				<div class="level1">
					<a href="/qlts" title="HY Jewelry">
						<img alt="logo" src="./images/logo.png" style="width:50px;height:50px"> 
					</a>
				</div>
				<div class="level2">
					<a href="home" title="HY Jewelry">
						<img alt="logo1" src="./images/logo1.png" style="width:164px; height:20px">
					</a>
				</div>
			</td>
			<td align="right" width="20%">
				<table>
					<tr>
						<td>
							<ul>
								<li class="dropdown">
									<i class="fa fa-search dropbtn" style="font-size:18px; color:black"></i>
									<div class="dropdown-content">
							  		  <div class="search-container">
									    <form method="GET" action="Find">
									      <input type="text" placeholder="Từ khóa tìm kiếm.." name="key" style="margin:10px; font-family:Courier New">
									      <button type="submit"><i class="fa fa-search" style="font-size:14px"></i></button>
									    </form>
									  </div>
									</div>
								</li>
							</ul>
						</td>
						<td>
						<c:if test="${name.length() > 0}" >
							<ul>
								<li>
									<a href="Cart?userName=${name}">
										<i class="fa fa-shopping-cart" style="font-size:18px; color:black"></i>
									</a>
								</li>
							</ul>
						</c:if>
						</td>
						<td>
							<ul>
								<li class="dropdown">
									<i class="fa fa-user dropbtn" style="font-size:18px; color:black"></i>
									<div class="dropdown-content">
									  <c:choose>
										    <c:when test="${admin.admin <= 0}" >
										      <a href="UserInfo?userName=${name}" class="hoho">${name}</a>
											  <a href="LogOutServlet">Đăng xuất</a>
										    </c:when>
										    <c:when test="${admin.admin == 1 }">
											      <a href="UserInfo?userName=${name}" class="hoho">${name}</a>
												  <a href="Admin.jsp">Quản lý hệ thống</a>
												  <a href="LogOutServlet">Đăng xuất</a>
										    </c:when>
										    <c:otherwise>
											        <a id="myBtn1">Đăng nhập</a>
												  	<a id="myBtn2">Đăng ký</a>
										    </c:otherwise>
										</c:choose>
									</div>
								</li>
							</ul>
						</td>
					</tr>
				</table>
			</td>
			<td width=15%></td>
		</tr>	
	</table>
	
	<jsp:include page="modal.jsp"></jsp:include>	
	
</body>
</html>