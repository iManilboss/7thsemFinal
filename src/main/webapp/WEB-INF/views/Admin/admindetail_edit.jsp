<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Admin Details</title>
</head>
<body>
<h3>Update Admin details</h3>
<form action="${pageContext.request.contextPath}/admin/a_detail/update" method ="post">
<p>
<input type ="text" name="id" value="${admin.id}" readonly>
</p>
<p>
<input type ="text" name="name" value="${admin.firstName }">
</p>
<p>
<input type ="text" name="description" value= "${item.lastName }">
</p>
<p>
<input type="text" name ="type" value="${item.active }">
</p>
<p>
<input type ="submit" value ="Save">
<input type="reset" value="Reset">
</p>
</form>
</body>
</html>