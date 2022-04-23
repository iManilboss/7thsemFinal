<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Details</title>
</head>
<body>
<h3>Displaying all homes</h3>
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
<th>Type </th>
<th>Size </th>
<th>Bedroom </th>
<th>Bathroom </th>
<th>Kitchen </th>
<th>livingRoom </th>
<th>floor </th>
<th>Faced</th>
<th>Type</th>
<th>Road</th>
<th>Facilities</th>
<th>Ropani</th>
<th>Aana</th>
<th>Paisa</th>
<th>Dam</th>


</tr>
</thead>
<tbody>
<c:forEach items="${home_detail}" var= "home">
<tr> 
<td> ${home.id}</td>
<td> ${home.ownerFirstName }</td>
<td> ${home.ownerLastName }</td>
<td> ${home.ownerContact }</td>
<td> ${home.propertyPrice }</td>
<td> ${home.propertyLocation }</td>
<td> ${home.propertyState }</td>
<td> ${home.propertyCity }</td>
<td> ${home.propertyType }</td>
<td> ${home.propertySize }</td>
<td> ${home.bedroom }</td>
<td> ${home.bathroom }</td>
<td> ${home.kitchen }</td>
<td> ${home.livingRoom }</td>
<td> ${home.floor }</td>
<td> ${home.houseFaced }</td>
<td> ${home.houseType }</td>
<td> ${home.houseRoad }</td>
<td> ${home.facilities }</td>
<td> ${home.ropaniSize }</td>
<td> ${home.aanaSize }</td>
<td> ${home.paisaSize }</td>
<td> ${home.damSize }</td>
<td>
<a href="${pageContext.request.contextPath }/admin/home_detail/edit/${home.id }">Edit</a> 
<a href="${pageContext.request.contextPath }/admin/home_detail/delete/${home.id}">Delete</a>
</td>
</tr>
</c:forEach>

</tbody>
</table>
</body>
</html>