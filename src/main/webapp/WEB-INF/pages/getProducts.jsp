<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Product List</title>
</head>
<body>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of product</h2></caption>
            <tr>
                <th>Product Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Visible</th>
            </tr>
            <c:forEach items="${products}" var="product"> 
  				<tr>
    				<td>${product.productName}</td>
    				<td>${product.price}</td>
    				<td>${product.quantity}</td>
    				<td>${product.visible}</td>  
    			</tr>
			</c:forEach>
        </table>
    </div>
</body>
</html>