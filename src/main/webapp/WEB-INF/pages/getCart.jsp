<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Cart Information</title>
</head>
<body>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Cart ${cart.cartId} Information</h2></caption>
            <tr>
                <th>ItemId</th>
                <th>Product</th>
                <th>Quantity</th>
                <th>Grand Total</th>
            </tr>     
  			<tr>
    			<td>${cart.cartId}</td>
    			<td>${cart.productName}</td>
    			<td>${cart.quantity}</td>
    			<td>${cart.grandTotal}</td>  
    		</tr>		
        </table>
    </div>
</body>
</html>
