<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Signup!!</title>
</head>
<body>
	<h3>Signup here</h3>
<form action="${pageContext.request.contextPath }/signup" method ="post"  enctype="multipart/form-data">
<p>
<input type ="text" name="firstName" placeholder= "Enter your first name">
</p>
<p>
<input type ="text" name="lastName" placeholder="Enter your last name">
</p>
<p>
<input type ="text" name="email" placeholder="Enter your email">
</p>
<p>
<input type="text" name ="phone" placeholder="Enter your phone number">
</p>
           
<p>
<input type ="date" name="dob" placeholder="Enter your date of birth">
</p>                       

 <p>Please select your role:</p>
  <input type="radio"  name="authority" value="ADMIN">ADMIN
  
  <input type="radio"  name="authority" value="AGENT">Agent


<p>
<input type ="text" name="username" placeholder="Enter your username">
</p>
<p>
<input type ="password" name="password" placeholder="Enter your pasword">
</p>

<div>
    <label>Upload your photo </label>
  </div>
  
  <div class="input-group mb-3">
  <input type="file"   id=""  name="photo" required >

</div>
<p>
<input type ="submit" value ="Save">
</p>
</form>
</body>
</html>