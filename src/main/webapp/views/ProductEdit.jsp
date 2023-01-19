<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Product</title>
</head>
<body>
	<h1>Edit Product</h1>
	<form:form action="/updateProduct" method="post" modelAttribute="product">
		Product_ID<form:input path="pid"/><br><br>
		Product_Name:<form:input path="pname"/><br><br>
		Quantity:<form:input path="quantity"/><br><br>
		Price:<form:input path="price"/><br><br>
		<input type="submit" value="Update Product">
		<input type="reset" value="Clear">
	</form:form><br><br>
	<a href="ViewAllProducts">View All Products</a>
</body>
</html>