<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Credit Card Information</h1>
<form action="${pageContext.servletContext.contextPath}/terms" method="post">
<table border="1">
		<tr>
			<td>Name</td>
			<td>${ccard[0] }</td>
		</tr>
		<tr>
			<td>Card Number</td>
			<td>${ccard[1] }</td>
		</tr>
		<tr>
			<td>Card Type</td>
			<td>
				<select>
				  <option value="volvo">Master Card</option>
				  <option value="saab">${ccard[2]}</option>
				  <option value="mercedes">Discover</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>Expiration Date</td>
			<td>${ccard[3]}</td>
		</tr>
	</table>
		<input type="submit" value="Checkout"  >
	</form>
	<div class="buttonRow">
		
			<input type="submit" value="Back to Shipping Cart" onclick="window.location='${pageContext.servletContext.contextPath}/addToCart'">
			<input type="submit" value="Previous Page" onclick="goBack()">
		</div>
	<script>
		function goBack() {
			window.history.back();
		}
	</script>
</body>
</html>