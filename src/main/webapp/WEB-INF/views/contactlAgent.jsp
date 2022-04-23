<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

 <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css">
  <script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
</head>
<body>

<jsp:include page="nav.jsp"></jsp:include>
<h2><b>CONTRACT AGENT</b></h2>
<p style="margin: 20px;"></p>
<form action="${pageContext.request.contextPath }/user/contactlandAgent" method="post" style="margin-left:30%;margin-right:30%; background: lightblue;padding: 30px;border: solid lightgrey;" enctype="multipart/form-data">
  <div class="row mb-3">
    <label for="inputEmail3" class="col-sm-2 col-form-label"> </label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" name="land" value="${landdetails.id }" hidden>
    </div>
  </div>


  <div class="row mb-3">
    <label for="inputEmail3" class="col-sm-2 col-form-label">Message</label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" name="message" placeholder="enter a message" >
    </div>
  </div>
   <div class="row mb-3">
    <label for="inputEmail3" class="col-sm-2 col-form-label"></label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" name="user" value="${landdetails.userDetails.id } " hidden>
    </div>
  </div>

   <div class="row mb-3">
    <label for="inputEmail3" class="col-sm-2 col-form-label"></label>
    <div class="col-sm-10">
      <input type="text" class="form-control" id="inputEmail3" name="agent" value="${ landdetails.agentDetails.id }" hidden>
    </div>
  </div>


  
  

 
  <input href="" type="submit" class="btn btn-primary"></input>
</form>
</body>
</html>