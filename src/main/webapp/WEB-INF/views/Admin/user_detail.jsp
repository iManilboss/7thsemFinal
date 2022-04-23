<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Details</title>
</head>
<body>
<h3>Displaying all Users</h3>
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
<c:forEach items="${user_detail}" var= "user">
<tr> 
<td> ${user.id}</td>
<td> ${user.firstName }</td>
<td> ${user.lastName }</td>
<td> ${user.email }</td>
<td> ${user.phone }</td>
<td> ${user.dob }</td>
<td> ${user.active }</td>
<td> ${user.username }</td>
<td> ${user.password }</td>
<td>
<a href="${pageContext.request.contextPath }/admin//edit/${admin.id }">Edit</a> 
<a href="${pageContext.request.contextPath }/admin/item/delete/${admin.id}">Delete</a>
</td>
</tr>
</c:forEach>

</tbody>
</table>
</body>
</html>