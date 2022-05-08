<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="text-align: right">
<a href = "admin">Admin</a>
</div>
<form action = "search">
	Enter brand / category <input type = "text" name = "choice"><br>
	<input type ="submit" value = "Search By Category/Brand">
</form>
<h2>Product List</h2>
${products }
</body>
</html>