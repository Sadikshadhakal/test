<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Shipping And Billing Addresses</h1>
<table border="1">
		<tr>
		    <th>Address</th>
		    <th>Shipping Address</th> 
		    <th>Billing Address</th>
		  </tr>
		<tr>
			<td>Street</td>
			<td>${shippingAddress.street }</td>
			<td>${billingAddress.street }</td>
		</tr>
		<tr>
			<td>City</td>
			<td>${shippingAddress.city }</td>
			<td>${billingAddress.city }</td>
		</tr>
		<tr>
			<td>State</td>
			<td>${shippingAddress.state }</td>
			<td>${billingAddress.state }</td>
		</tr>
		<tr>
			<td>Zip</td>
			<td>${shippingAddress.zip }</td>
			<td>${billingAddress.zip }</td>
		</tr>
	</table>
	
	<div>
	<input type="checkbox" name="add" value="sameShipBill"> Billing Same As Shipping?<br>
  	<input type="checkbox" name="add" value="saveShippingAdd"" checked>Save Shipping Address<br>
  	<input type="checkbox" name="add" value="saveBillingAdd" checked>Save Billing Address<br>
	</div>
	<div class="buttonRow">
		<input type="submit" value="Select Ship Address"  onclick="window.location='${pageContext.servletContext.contextPath}/selectshipaddress'">
		<input type="submit" value="Select Bill Address" onclick="window.location='${pageContext.servletContext.contextPath}/selectbilladdress'">
		<input type="submit" value="Checkout" onclick="window.location='${pageContext.servletContext.contextPath}/payment'">
		<input type="submit" value="Back To Cart" onclick="goBack()">
	</div>
	<script>
		function goBack() {
			window.history.back();
		}
	</script>
</body>
</html>