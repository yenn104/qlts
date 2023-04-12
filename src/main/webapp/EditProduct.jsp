<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <head>
 <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>Edit Product</title>
 <link rel="icon" href="./images/logo.png" type="image/x-icon">
 </head>
 <body>
	<div  align="center" class="container"> 
		 <h1>Edit Product</h1>
		 
		<form method="POST" action="editProductServlet" enctype="multipart/form-data">
			 <table>
				 <tr>
					 <td>Product ID</td>
					 <td><input type="text" name="id"  value="${p_id}" readonly/></td>
				 </tr>
				 <tr>
					 <td>Product Name</td>
					 <td><input type="text" name="name" value="${p_name}"/></td> 
				 </tr>
				 <tr>
					 <td>Product Type</td>
					 <td><input type="text" name="type" value="${p_type}"/></td>
				 </tr>
				 <tr>
					 <td>Product Amount</td>
					 <td><input type="text" name="slg" value="${p_slg}"/></td> 
				 </tr>
				 <tr>
					 <td>Product Price</td>
					<td><input type="text" name="price" value="${p_price}"/></td>
				 </tr>
				 <tr>
				 <tr>
					 <td>Product Detail</td>
					 <td><input style="width:fit-content;" type="text" name="detail" value="${p_detail}"/></td> 
				 </tr>
				 <%-- <tr>
					 <td>Product Image</td>
					 <td><img src="${p_img}"  width=100 height=100 /></td>
				 </tr> --%>
				 <tr>
					 <td>Product Image</td>
					 <td>
						 <img src="${p_img}" width=100 height=100 />
						 <input type="hidden" name="image1" value="${p_img}" />
					 </td>
				 </tr>
				 <tr>
					 <td>Change Image</td>
					 <td><input type="file" name="image2" ></td>
				 </tr>
				 <tr>
					 <td colspan="2"><button>Update</button><input type="reset"></td>
				 </tr>
			 </table>
		</form>
		<div> 
		 	<h5>${thongnbao}</h5> 
		 </div>
	 
	 </div>
 </body>
 
</html>