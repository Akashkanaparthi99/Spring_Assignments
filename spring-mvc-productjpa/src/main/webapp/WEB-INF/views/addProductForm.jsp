<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="addProduct">
		Enter Product name : <input name="name" type="text"><br>
		Enter Category : <select name = "category">
		<option value = "ELECTRONICS">ELECTRONICS</option>
		<option value = "TOYS">TOYS</option>
		<option value = "SPORTS">SPORTS</option>
		<option value = "SHOES">SHOES</option>
		<option value = "APPARELS">APPARELS</option>
		</select><br>
		Enter Brand : <input name = "brand" type="text"><br>
		Enter Price : <input name = "price" type="text"><br>
		<input type="submit" value="Add Product">
</form>
</body>
</html>