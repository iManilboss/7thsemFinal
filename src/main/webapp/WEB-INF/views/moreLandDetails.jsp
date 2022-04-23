<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  isELIgnored="false"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<head>
	
<link  href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/assets/css/view.css" rel="stylesheet">
<script src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
</head>

<body style="background-color: lightblue;">
<jsp:include page="nav.jsp"></jsp:include>


	<div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel" >
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  
  
  <div class="carousel-inner">
    <div class="carousel-item active">
    <c:forEach items="${onedetails.landImage }" var="house"> 
      <img src="${pageContext.request.contextPath }/property_image/${house}" class="d-block w-100" alt="..." style="width: 20px; height: 350px;margin:5px;padding-left:6px;padding-right:6px;">
      <div class="carousel-caption d-none d-md-block">
        
      </div>
      </c:forEach>
    </div>

  
  </div>
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div>



<div class="description">
	<h2>Description:</h2>
	<ul>
	<li> <p>It is loacted at ${onedetails.propertyLocation }, ${onedetails.propertyCity } , ${onedetails.propertyState }. </p></li>
	<li> <p>It's price  is Rs ${onedetails.propertyPrice }.  </p></li>
		
		<li><p>It has area of  ${onedetails.ropaniSize } Ropani,  ${onedetails.aanaSize } Aana,  ${onedetails.paisaSize } Paisa,  ${onedetails.damSize } Dam  area. </p></li>
		<li> <p>Plot is ${onedetails.landFaced } Faced. </p></li>
		
		<li> <p>It has access to  ${onedetails.landRoad } feet road. </p></li>
		
	</ul>
	<div >
	<a class="btn btn-primary  btn-lg" href="${pageContext.request.contextPath }/user/contactlandAgent/${onedetails.id}" role="button">Buy Land</a>
	<a class="btn btn-primary  btn-lg" href="${pageContext.request.contextPath }/land" role="button">Watch Other Lands</a>
	</div>

</div>







</body>
</html>