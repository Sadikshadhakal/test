<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"/>
 
<link href="<c:url value="/resources/css/dataTables.tableTools.css" />" type="text/css" rel="stylesheet">
<link href="<c:url value="/resources/css/jquery.dataTables.css" />" type="text/css" rel="stylesheet">

 
<title>EBazaar - Cart Items</title>
</head>
<body >


	Cart Items
	<table id="cartTable" border="1">
	<thead>
            <tr>
            	<th >
            	
            	</th>
                <th>ItemName</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Total Price</th>
            </tr>
        </thead>
        <tbody>
		<c:forEach var="cartItemPres" items="${cartItems}">
			<tr>
				<td align ="center">
					<input type ="checkbox" name ="checkbox" />
				</td>
				<td>${cartItemPres.itemName }</td>
				<td>${cartItemPres.quantity }</td>
				<td>${cartItemPres.price }</td>
				<td>${cartItemPres.totalPrice }</td>
				
			</tr>
		</c:forEach>
		</tbody>
	</table>
	

	<p class="buttonRow">
		<input type="submit" value="Proceed to Checkout"  onclick="window.location='${pageContext.servletContext.contextPath}/shippingbilling'">
		<input type="submit" value="Continue Shopping" onclick="window.location='${pageContext.servletContext.contextPath}'">
		<input type="submit" value="Save Cart">
		<input id="delete" type="submit" value="Delete Selected">
	</p>
	
<script>	
	$(document).ready(function () {
		alert(1)

		   $("#delete").on("click", function () {
			   alert(hello);
		        $('table tr').has('input[name="checkbox"]:checked').remove()
		    })
		});

	</script>	

<%-- 	
<script src="<c:url value="resources/js/jquery.js" />" type="text/javascript" ></script>
<script src="<c:url value="resources/js/dataTables.tableTools.js" />" type="text/javascript" ></script>
<script src="<c:url value="resourcesjs/jquery.dataTables.js" />" type="text/javascript" ></script>
<script type="text/javascript">
$(document).ready(function() {
	  $('#example').DataTable( {
	        dom: 'T<"clear">lfrtip',
	        tableTools: {
	            "sRowSelect": "single"
	        }
	    } );
	/* $('tbody tr').click(function () {
		
        var itemName = $(this).children('td:eq(0)').html();
        var quantity = $(this).children('td:eq(1)').html();
        var price = $(this).children('td:eq(2)').html();
        var totalprice = $(this).children('td:eq(3)').html();
        console.log(itemName);
        $('div').html(
            'itemName: ' + itemName + '<br />' +
            'quantity: ' + quantity + '<br />' + 
            'price: ' + price + '<br />' + 
            'totalprice:' + totalprice + '<br />'
        );
    }); 
	$("#delete").on("click", function () {
	    $('tbody tr').remove()
	}) */
} );
</script> --%>

</body>

</html>