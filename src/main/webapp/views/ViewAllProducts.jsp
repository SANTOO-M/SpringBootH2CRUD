<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View all Products</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>

<!-- Bootstrap Icon-->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">

<!-- Font Awesome icon-->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.0/css/font-awesome.min.css">

</head>
<body>
	<h1>View All Products</h1>
	<table class="table table-striped" border="1" width="80%">
		<tr class="table-row bg-info text-light"><th>Product_ID</th><th>Product_Name</th><th>Quantity</th><th>Price</th><th>Edit</th><th>Delete</th></tr>
			<c:forEach items="${products}" var="product" >
				<tr>
					<td>${product.pid}</td>
					<td>${product.pname}</td>
					<td>${product.quantity}</td>
					<td><div class="badge bg-info text-light">${product.price}</div></td>
					<td><a href="editProduct/${product.pid}" role="button" class="btn btn-success"><i class="fa fa-pencil" aria-hidden="true"></i> Edit</a></td>
					<td><a href="deleteProduct/${product.pid}" role="button" class="btn btn-danger"><i class="fa fa-trash-o" aria-hidden="true"></i> Delete</a></td>
				</tr>
			</c:forEach>		
	</table>
</body>
</html>