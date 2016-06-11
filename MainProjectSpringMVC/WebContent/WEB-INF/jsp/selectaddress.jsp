<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>

<title>Insert title here</title>
</head>
<body>
	<h1>${title}</h1>
	<table border="1">
		<tr>
		    <th>Name</th>
		    <th>Street</th> 
		    <th>City</th>
		    <th>State</th> 
		    <th>ZipCode</th>
		  </tr>
		  <c:forEach var="address" items="${addressList}">
		  <tr>
		  	<td>Test</td>
			<td>${address.street }</td>
			<td>${address.city }</td>
			<td>${address.state }</td>
			<td>${address.zip }</td>
		</tr>
		  </c:forEach>
	</table>
	<input type="button" name="Select" class="select"/>
	<input type="button" name="Delete Selected"/>
	<input type="button" name="Back" onclick="goBack()"/>
	<script>
		function goBack() {
			window.history.back();
			
		}
		$('.select').on('click', function(e){
		    alert($("#table tr.selected td:first").html());
		});
	</script>
</body>
</html>