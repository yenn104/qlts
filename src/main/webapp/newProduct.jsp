<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Product</title>
<link rel="icon" href="./images/logo.png" type="image/x-icon">
</head>
<body>
<div  align="center" class="container"> 
	<h1 align="center" style="color: pink">Create Product</h1>
	<form method="POST" action="newProductServlet"enctype="multipart/form-data">
		<table>
			<tr>
				<td align="center" style="color: pink">Product ID</td>
				<td><input type="text" name="ID" /></td>
			</tr>
			<tr>
				<td align="center" style="color: pink">Product Name</td>
				<td><input type="text" name="name" /></td>
			</tr>
			<tr>
				<td align="center" style="color: pink">Product Type</td>
				<td><input type="text" name="type" /></td>
			</tr>
			<tr>
				<td align="center" style="color: pink">Product Quality</td>
				<td><input type="text" name="slg" /></td>
			</tr>
			<tr>
				<td align="center" style="color: pink">Product Price</td>
				<td><input type="text" name="price" /></td>
			</tr>
			<tr>
				<td align="center" style="color: pink">Product Detail</td>
				<td><input type="text" name="detail" /></td>
			</tr>
			<tr>
				<td align="center" style="color: pink">Product Image</td>
				<td><input type="file" name="image" value=""></td>
			</tr>
			<tr>
				<td colspan="2"><button align="center" style="color: pink">Submit</button>
					<input align="center" style="color: pink" type="reset"></td>
			</tr>
		</table>
	</form>
	<div>
		<h5>${thongbao}</h5>
	</div>
	</div>
</body>
</html>