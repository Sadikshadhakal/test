<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EBazaar - Catalog</title>
</head>
<body>
this is test
	Browse Catalogs
	<table border="1">
		<c:forEach var="catalogPres" items="${catalogs}">
			<tr>
				<td><a href="${pageContext.servletContext.contextPath}/viewProductList/catalogId/${catalogPres.id }/catalogName/${catalogPres.name }">${catalogPres.name }</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href="${pageContext.servletContext.contextPath}/login/callback/login">Login</a>
	<a href="${pageContext.servletContext.contextPath}/orderhistory">View Order History</a>

</body>
</html>