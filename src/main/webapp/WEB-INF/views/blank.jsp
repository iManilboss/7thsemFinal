<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
     <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
        
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
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

     	}
     	.sort{
     	margin-left:30px;
     	}
     
     	
     	.detail,a{
     	display:inline;
     	float:right;
     	}
     .details,h3{
      margin-left:75px;
      margin-right:120px;
     display:flex;
     
   
     }
     

     </style>
</head>
<body>
<jsp:include page="nav.jsp"></jsp:include>

<section class="contents">
	
<div class="card" style="width: 80%;height:450px;margin-left:130px; padding:6px">
  <img src="..." class="card-img-top" alt="..." style="height:100%;">
 
   <div class="content" >
                <div class="price" class="detail">
                    <h2>Rs ${home.propertyPrice }</h3>
                    
                    
            
                    <a href="#" class="fas fa-envelope" style="margin-left:12px"></a>
                    
                    <a href="#" class="fas fa-phone" style="margin-left:12px"></a>
                </div>
                
                <div class="location">
                  <h3>${home.houseType} </h3>
                    <p>location ${home.propertyLocation}</p>
                </div>
                
                   <div class="details">
                    <h3> <i class="fas fa-expand"></i>${home.propertySize }sqft </h3>
                    <h3> <i class="fas fa-bed"></i> ${home.bedroom }Beds </h3>
                    <h3> <i class="fas fa-bath"></i> ${home.bathroom } Bathroom </h3>
                     
                     
                </div>
           
                <div class="buttons">
                    <a href="${pageContext.request.contextPath }/landonedetail/${home.id}" class="btn"  style="float:left;">view details</a>
                    <a href="${pageContext.request.contextPath }/Home" class="btn">Back to Home</a>
                </div>
            </div>

</div>
</section>
</body>
</html>