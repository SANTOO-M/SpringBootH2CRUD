<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body><table border="1" width="80%">
		<tr><th>Product_ID</th><th>Product_Name</th><th>Quantity</th><th>Price</th></tr>
			<c:forEach items="${records}" var="productnames" >
				<tr>
					<td>${productnames.pid}</td>
					<td>${productnames.pname}</td>
					<td>${productnames.quantity}</td>
					<td>${productnames.price}</td>
				</tr>
			</c:forEach>		
	</table>
</body>
</html>