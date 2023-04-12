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
		<link rel="stylesheet" type="text/css" href="./css/style.css"/>
	<style type="text/css"></style>			

	
</head>
<body>
	<div class="container">
	
	<jsp:include page="_header.jsp"></jsp:include>

	<jsp:include page="_menu.jsp"></jsp:include>


	
	<div id="hihi1">	
		<div class="centered">
			<img alt="line" src="./images/bg1.png">	
		</div>
		<div class="section_1">
				<img alt="line" src="./images/bg.jpg" style="width:667px; height:445px">	
				<span>
					Trang sức giúp nâng cao vẻ đẹp của một người. 
					Nó cũng tượng trưng cho sự giàu có, quyền lực và địa vị. Đối với một số người, trang sức là một hình thức nghệ thuật để thể hiện bản thân và sự sáng tạo. 
					Sau đó, có một số người sử dụng đồ trang sức như một phần của truyền thống và văn hóa của họ. 
					Mặc dù chúng có thể khác nhau về mức độ quan trọng và mức độ liên quan, chúng đều đóng những vai trò quan trọng.
				</span>	
		</div>	
	</div>
	
	
	<jsp:include page="listProduct.jsp"></jsp:include>
	

	
	<div>
		<a class="dropdown" href="" title="lên đầu trang"><i class="fa fa-chevron-up dropbtn" style="font-size:19px; color:rgb(229, 163, 166); margin-bottom:50px;"></i></a>
	</div>



	</div>
</body>
</html>