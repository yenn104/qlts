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


<!-- LOG IN -->		
<div id="myModal1" class="modal">
   	<div class="logSign-box">
   		  <span class="close">&times;</span>
		  <h2>Đăng nhập</h2>
		  <form method="post" action="LogInServlet">
		    <div class="user-box">
		      <input type="text" name="username" required="">
		      <label>Tên tài khoản</label>
		    </div>
		    <div class="user-box">
		      <input type="password" name="password" required="">
		      <label>Mật khẩu</label>
		    </div>
		    <a href="#">
		      <span></span>
		      <span></span>
		      <span></span>
		      <span></span>
		      <input type="submit" name="submit" value="Đăng nhập"/>
		    </a>
		  </form>
	</div>
</div>


<!-- Sign Up -->
<div id="myModal2" class="modal">
   	<div class="logSign-box">
   		  <span class="close">&times;</span>
		  <h2>Đăng ký</h2>
		  <form method="post" action="SignUpServlet">
		    <div class="user-box">
		      <input type="text" name="username" required="">
		      <label>Tên tài khoản</label>
		    </div>
		    <div class="user-box">
		      <input type="text" name="sdt" required="">
		      <label>Số điện thoại</label>
		    </div>
		    <div class="user-box">
		      <input type="text" name="mail" required="">
		      <label>Mail</label>
		    </div>
		    <div class="user-box">
		      <input type="password" name="password" required="">
		      <label>Mật khẩu</label>
		    </div>
		    <a href="#">
		      <span></span>
		      <span></span>
		      <span></span>
		      <span></span>
		      <input type="submit" name="submit" value="Đăng ký"/>
		    </a>
		  </form>
	</div>
</div>




<script>
// Get the modal
var modal1 = document.getElementById('myModal1');
var modal2 = document.getElementById('myModal2');

// Get the button that opens the modal
var btn1 = document.getElementById("myBtn1");
var btn2 = document.getElementById("myBtn2");

// Get the <span> element that closes the modal
var span1 = document.getElementsByClassName("close")[0];
var span2 = document.getElementsByClassName("close")[1];

// When the user clicks the button, open the modal 
btn1.onclick = function() {
  	modal1.style.display = "block";
}
btn2.onclick = function() {
  	modal2.style.display = "block";
}

// When the user clicks on <span> (x), close the modal
span1.onclick = function() {
	modal1.style.display = "none";
}
span2.onclick = function() {
	modal2.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal1) {
    modal1.style.display = "none";
  }
  if (event.target == modal2) {
    modal2.style.display = "none";
  }
}

</script>

</body>
</html>