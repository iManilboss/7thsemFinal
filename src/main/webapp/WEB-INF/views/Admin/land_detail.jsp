<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Land Details</title>
</head>
<body>
<h3>Displaying all land</h3>
<table>
<thead>
<tr>
<th>Id </th>
<th>Owner First Name </th>
<th>Owner Last Name </th>
<th>OwnerContact </th>
<th> Price </th>
<th> location </th>
<th>State </th>
<th>City </th>

<th>Faced</th>

<th>Road</th>

<th>Ropani</th>
<th>Aana</th>
<th>Paisa</th>
<th>Dam</th>


</tr>
</thead>
<tbody>
<c:forEach items="${land_detail}" var= "land">
<tr> 
<td> ${land.id}</td>
<td> ${land.ownerFirstName }</td>
<td> ${land.ownerLastName }</td>
<td> ${land.ownerContact }</td>
<td> ${land.propertyPrice }</td>
<td> ${land.propertyLocation }</td>
<td> ${land.propertyState }</td>
<td> ${land.propertyCity }</td>

<td> ${land.landFaced }</td>

<td> ${land.landRoad }</td>

<td> ${land.ropaniSize }</td>
<td> ${land.aanaSize }</td>
<td> ${land.paisaSize }</td>
<td> ${land.damSize }</td>
<td>
<a href="${pageContext.request.contextPath }/admin/a_detail/edit/${admin.id }">Edit</a> 
<a href="${pageContext.request.contextPath }/admin/a_detail/delete/${admin.id}">Delete</a>
</td>
</tr>
</c:forEach>

</tbody>
</table>
</body>
</html>