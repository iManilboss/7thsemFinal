<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">


   <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
     <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
         <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/image.css">
         
     <style type="text/css">
   
     
   
     	.request a{
     		
     		margin-bottom: 14px;
        margin-left: 20px;
     		
     			width: 25%;
     		margin-left: 10px;
        display: inline;

     	}
     	request div{
     	
     	display:inline;}
     	.content{
     	
     	width: 100%;
        height: 100%;
        margin-left:30px;

     	}
     	.sort{
     	margin-left:30px;
     	}
     	.request .card{
     	display:inline-block;
     	
     	}
     		.content .card{
     	display:inline-block;
     	
     	}
     		.content1 .card{
     	display:inline-block;
     	
     	}
     	
     	
     
  

     </style>
<title>AgentHome</title>
</head>
<body>
<jsp:include page="nav.jsp"></jsp:include>
<p style="margin: 20px;"></p>


	<a type="button" class="btn btn-primary btn-lg position-relative" href="#home">
  Buy  Request

</a>
<p style="margin: 10px;"></p>
<section class="request">

<c:forEach items="${buyrequest}" var="home">
<div class="card" style="width: 18rem;">
  
  <ul class="list-group list-group-flush">
    <li class="list-group-item">User code: ${home.userdetail.id}</li>
    <li class="list-group-item">Property code :${home.id}</li>
  </ul>
  <div class="card-body">
      <a href="${pageContext.request.contextPath }/deletebuyHome/${home.id}" class="btn btn-primary">Remove</a>
  </div>
</div>
</c:forEach>



</section>

<!-- sell property request begins -->

<p style="margin: 20px;"></p>
<a type="button" class="btn btn-primary btn-lg position-relative" href="#home">
  Sell House Request
</a>
<p style="margin: 10px;"></p>
<section class="content">


<c:forEach items="${homedetails}" var="home">  
 <c:if test="${home.validatedata== false }"> 

<div class="card" style="width: 18rem;">

  <h2>Property Images</h2>
  <!--   <c:forEach items="${home.houseImage}" var="image"> 
  </c:forEach> -->
   
   <img src=" ${pageContext.request.contextPath }/property_image/${home.houseImage }" class="card-img-top" alt="..." style="margin-bottom:1px;padding-bottom:2px;">
   
  

  <h2>Property Details</h2>
  <ul class="list-group list-group-flush">
    
    <li class="list-group-item">Location: ${home.propertyLocation }</li>
    <li class="list-group-item">Price: ${home.propertyPrice }</li>
      <li class="list-group-item">Road: ${home.houseRoad }</li>
      <li class="list-group-item">Road: ${home.houseFaced }</li>
      <li class="list-group-item">Road: ${home.propertySize }</li>
      <li class="list-group-item">Road: ${home.bedroom }</li>
      <li class="list-group-item">Road: ${home.bathroom }</li>
      <li class="list-group-item">Road: ${home.kitchen }</li>
      <li class="list-group-item">Road: ${home.floor }</li>
  </ul>
  

  <h2>Owner Info</h2>
  <h3>Citizenship Photo</h3>
   <img src="${pageContext.request.contextPath }/property_image/${home.citizenshipImage[0]}"  class="card-img-top" >

<h3>Lalpurja Image</h3>
   <img src="${pageContext.request.contextPath }/property_image/${home.lalpurjaImage[0]}"  class="card-img-top">
<h3>Contact</h3>


  <div class="card-body">
    <a href="${pageContext.request.contextPath }/updateHome/${home.id}" class="btn btn-primary">Accept</a>
    <a href="${pageContext.request.contextPath }/deleteHome/${home.id}" class="btn btn-primary">Reject</a>
  </div>
</div>
</c:if>
</c:forEach>
</section>


<p style="margin: 20px;"></p>
			<a type="button" class="btn btn-primary btn-lg position-relative" href="#home">
  Sell Land Request
</a>
<p style="margin: 10px;"></p>
<section class="content1">
<c:forEach items="${landdetails}" var="home">
<c:if test="${home.validatedata== false }"> 


<!-- this is for sell requests -->
<div class="card" style="width: 18rem;">
  <h2>Property Images</h2>
  <!-- <c:forEach items="${home.landImage}" var="image">   
 </c:forEach>  -->

  <img src=" ${pageContext.request.contextPath }/property_image/${home.landImage[0] }" class="card-img-top" alt="...">
 
  
  
<h2>Property Details</h2>
  <ul class="list-group list-group-flush">
    
    <li class="list-group-item">Location: ${home.propertyLocation }</li>
    <li class="list-group-item">Price: ${home.propertyPrice }</li>
      <li class="list-group-item">Road: ${home.landRoad }</li>
  </ul>

  
  <h3>Citizenship Photo</h3>
  <img src="${pageContext.request.contextPath }/property_image/${home.citizenshipImage[0]}" alt="notfound"  class="card-img-top" >

<h3>Lalpurja Image</h3>
      <img src="${pageContext.request.contextPath }/property_image/${home.lalpurjaImage[0] }"  class="card-img-top">
<h3>Contact : ${home.ownerContact } </h3>


  <div class="card-body">
    <a href="${pageContext.request.contextPath }/updateLand/${home.id}" class="btn btn-primary">Accept</a>
    <a href="${pageContext.request.contextPath }/deleteLand/${home.id}" class="btn btn-primary">Reject</a>
  </div>
</div>


 </c:if>
</c:forEach>



</section>

</body>
</html>