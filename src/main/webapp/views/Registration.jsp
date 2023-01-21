<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Registration</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js"></script>

<!-- Bootstrap Icon-->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">

<!-- Font Awesome icon-->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.0.0/css/font-awesome.min.css">
</head>
<style>
	.card
	{
		position:absolute;
		top:50%;
		left:50%;
		transform:translate(-50%,-50%);
		}
</style>
<body>
<div class="card col-sm-4">
	<div class="card-body">
	<div class="card-title bg-success text-light text-center"><h1>Product Registration</h1></div>
	<form:form action="saveProduct" method="post" modelAttribute="product">
	<div class="form-group">
		<label for="pname">Product_Name</label>
		<form:input type="text" path="pname" placeholder="Enter the Product Name" class="form-control"/>
	</div>
	<div class="form-group">
		<label for="quantity">Quantity</label>
		<form:input type="number" path="quantity" placeholder="Enter the Quantity" class="form-control"/>
	</div>
	<div class="form-group">
		<label for="price">Price</label>
		<form:input type="number" path="price" placeholder="Enter the price" class="form-control"/>
	</div>	
	
		<button type="submit" class="btn btn-primary text-light"><i class="fa fa-floppy-o" aria-hidden="true"></i>  Add Product</button>
		<button type="reset" class="btn btn-dark text-light"><i class="bi bi-x-circle-fill"></i>  Clear</button>
	</form:form>
	<a href="ViewAllProducts">View All Products</a>
	</div>
</div>
</body>
</html>