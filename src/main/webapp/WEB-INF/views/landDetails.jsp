<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Property Details</title>
 <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
     <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
   
  
 <style type="text/css">
  .btn {

    background-color: white; 

    color: black; 

    border: 2px solid #008CBA;

}


.btn:hover {

    background-color: #008CBA;

    color: white;

}
     	
     	.request{

     		
     		width: 25%;
     		margin-left: 10px;
        display: inline;
  

     	}
     	.request a{
     		
     		margin-bottom: 14px;
        margin-left: 20px;
     		width: 35%;

     	}
     	.contents{
     	float: left;
     	width: 100%;
        height: 100%;
        margin-left:30px;
        margin-top:6px;
        margin-button:4px;

     	}
     	.sort{
     	margin-left:30px;
     	}
     
     	
     	.detail,a{
     	display:inline;
     	float:right;
     	}
     
     
 </style>
</head>

<body>
<nav class="navbar navbar-expand-lg navbar-light" style="background-color: #e3f2fd; height:100%;margin-bottom:4px;">
  <div class="container-fluid">
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="${pageContext.request.contextPath}/">Real Estate</a>
    <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
       
      </ul>
      <form class="d-flex" action="${pageContext.request.contextPath }/searchLand" method="Get">
        <input name="keyword" id="keyword" value="${keyword}"  class="form-control me-2" type="search" placeholder="Search by province,type,faced..." aria-label="Search">
        <button class="btn btn-outline-success" type="submit"  onclick="clearSearch()">Search</button>
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


<div>
<label>Sort By:</label>
<a class="btn btn-primary" href="${pageContext.request.contextPath }/getsortedlandbyprice" role="button" style="float:none;margin-right:2px">Increasing Price </a>
<a class="btn btn-primary" href="${pageContext.request.contextPath }/getsortedlandbypricedes" role="button" style="float:none;margin-right:2px">Decreasing Price </a>

</div>

        
 <section class="contents">
	<c:forEach items="${landdetails }" var="home">  
<c:if test="${home.validatedata== false }">
<div class="card" style="width: 80%;height:400px;margin-left:130px; padding:6px;margin-bottom:8px;">
  <img src="${pageContext.request.contextPath }/property_image/${home.landImage[0] }" class="card-img-top" alt="..." style="height:100%;overflow:hidden;">
 
   <div class="content" >
                <div class="price" class="detail">
                    <h3>Rs ${home.propertyPrice }</h3>
            
                    
                </div>
                <div class="location">
                 
                    <p>location ${home.propertyLocation}</p>
                </div>
           
                <div class="buttons">
                    <a href="${pageContext.request.contextPath }/landonedetail/${home.id}" class="btn"  style="float:left;">view details</a>
                    <a href="${pageContext.request.contextPath }/Home" class="btn">Back to Home</a>
                </div>
            </div>

</div>

        </c:if>
      </c:forEach>
</section>

<div>


</div>



<!--    
<c:if test="${menu.price gt 50 }">

</c:if>
 -->
        <script type="text/javascript">
    function clearSearch() {
        window.location = "[[@{/}]]";
    }
</script>
   
    
  

</body>
</html>