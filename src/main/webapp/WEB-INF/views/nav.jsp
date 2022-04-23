<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
       <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
       <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RealState Webapp</title>

   
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">

   
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
     <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
  
  
  

</head>
<body style="margin-bottom:4px">
    
<!-- header section starts  -->



  
    
  
      
   
   
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd; height:100%;margin-bottom:4px;">
  <div class="container-fluid">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">Real Estate</a>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
       
      </ul>
      <form class="d-flex" action="#" method="#">
        <input class="form-control me-2" type="search" placeholder="Search by province,type,faced..." aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
      </form>
      <p style="margin-left:12px"></p>
         <security:authorize access="isAuthenticated()">
  
     <a href="${pageContext.request.contextPath }/logout" style="" > 

     <i class="fa fa-user"></i> 
     <security:authentication property="principal.username" /> </a>
</security:authorize>
    </div>
  </div>
</nav>
      
      
 



     

<!-- header section ends -->








</body>
</html>