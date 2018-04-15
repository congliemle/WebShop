<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Product found</title>
</head>
<script>
function getName(){
	var url = window.location.href;
	var name = url.substr(url.lastIndexOf("/")+1);
	document.getElementById("productName").innerHTML = "Product found by name " + decodeURI(name);
}
</script>
<body onload="getName()">
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2 id="productName"> </h2></caption>
            <tr>
                <th>Product Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Visible</th>
            </tr>          
  			<tr>
    			<td>${product.productName}</td>
    			<td>${product.price}</td>
    			<td>${product.quantity}</td>
    			<td>${product.visible}</td>  
    		</tr>			
        </table>
    </div>
</body>
</html>