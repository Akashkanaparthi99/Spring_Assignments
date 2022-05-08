<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${product.productId }
${product }
<form action="updateProd">
		Enter Product name : <input name="name" type="text" value = "${product.name }"><br>
		Enter Product ID : <input type = "hidden" name="productId" value = "${product.productId }"><br>
		Enter Category : <select name = "category">
		<option value = "${product.category }">${product.category }</option>
		<option value = "ELECTRONICS">ELECTRONICS</option>
		<option value = "TOYS">TOYS</option>
		<option value = "SPORTS">SPORTS</option>
		<option value = "SHOES">SHOES</option>
		<option value = "APPARELS">APPARELS</option>
		</select><br>
		Enter Brand : <input name = "brand" type="text" value = "${product.brand }"><br>
		Enter Price : <input name = "price" type="text" value = "${product.price }"><br>
		<input type="submit" value="Update Product">
</form>
</body>
</html>