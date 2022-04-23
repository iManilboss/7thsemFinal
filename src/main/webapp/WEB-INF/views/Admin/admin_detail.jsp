<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Details</title>
</head>
<body>
<h3>Displaying all admins</h3>
<table>
<thead>
<tr>
<th>Id </th>
<th>First Name </th>
<th>Last Name </th>
<th>Email </th>
<th>Phone </th>
<th>Dob </th>
<th>Active </th>
<th>UserName </th>
<th>Password </th>
</tr>
</thead>
<tbody>
<c:forEach items="${admins_detail}" var= "admin">
<tr> 
<td> ${admin.id}</td>
<td> ${admin.firstName }</td>
<td> ${admin.lastName }</td>
<td> ${admin.email }</td>
<td> ${admin.phone }</td>
<td> ${admin.dob }</td>
<td> ${admin.active }</td>
<td> ${admin.username }</td>
<td> ${admin.password }</td>
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