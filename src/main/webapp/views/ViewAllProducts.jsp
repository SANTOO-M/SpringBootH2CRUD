<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View all Products</title>
</head>
<body>
	<h1>View All Products</h1>
	<table border="1" width="80%">
		<tr><th>Product_ID</th><th>Product_Name</th><th>Quantity</th><th>Price</th><th>Edit</th><th>Delete</th></tr>
			<c:forEach items="${products}" var="product" >
				<tr>
					<td>${product.pid}</td>
					<td>${product.pname}</td>
					<td>${product.quantity}</td>
					<td>${product.price}</td>
					<td><a href="editProduct/${product.pid}">Edit</a></td>
					<td><a href="deleteProduct/${product.pid}">Delete</a></td>
				</tr>
			</c:forEach>		
	</table>
</body>
</html>