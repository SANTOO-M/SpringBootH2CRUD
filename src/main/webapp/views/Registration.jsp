<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Registration</title>
</head>
<body>
	<h1>Product Registration</h1>
	<form action="saveProduct" method="post">
		Product Name:<input type="text" name="pname"><br><br>
		Quantity:<input type="number" name="quantity"><br><br>
		Price:<input type="number" name="price"><br><br>
		<input type="submit" value="Add Product">
		<input type="reset" value="Clear">
	</form><br><br>
	<a href="ViewAllProducts">View All Products</a>
</body>
</html>