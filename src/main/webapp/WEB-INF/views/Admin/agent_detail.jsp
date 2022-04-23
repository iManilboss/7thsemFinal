<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agent Details</title>
</head>
<body>
<h3>Displaying all agents</h3>
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
<c:forEach items="${agent_detail}" var= "agent">
<tr> 
<td> ${agent.id}</td>
<td> ${agent.firstName }</td>
<td> ${agent.lastName }</td>
<td> ${agent.email }</td>
<td> ${agent.phone }</td>
<td> ${agent.dob }</td>
<td> ${agent.active }</td>
<td> ${agent.username }</td>
<td> ${agent.password }</td>
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