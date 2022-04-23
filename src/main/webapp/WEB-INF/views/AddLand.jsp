<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false" %>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link  rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css" >
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/bootstrap.min.js"></script>
<title>Upload Your Property Details</title>
</head>

<body>

<jsp:include page="nav.jsp"></jsp:include>


<form action="${pageContext.request.contextPath }/user/addLand" method="post" class="row g-3 needs-validation" novalidate style="margin: 2px; background-color: lightblue; width:50%; vertical-align: middle; text-align: left; display: flex;margin-left: 26%" enctype="multipart/form-data" >
  <label style="font-size:20px">PROPERTY DETAILS</label>
  <div class="col-md-4">
    <label for="validationCustom01" class="form-label" >First name</label>
    <input type="text" name="ownerFirstName" class="form-control" id="validationCustom01"  required>
    <div class="valid-feedback">
      Looks good!
    </div>
  </div>
  <div class="col-md-4">
    <label for="validationCustom02" class="form-label">Last name</label>
    <input type="text" name="ownerLastName" class="form-control" id="validationCustom02"  required>
    <div class="valid-feedback">
      Looks good!
    </div>
  </div>
  <div class="col-md-4">
    <label for="validationCustomUsername" class="form-label">Phone no:</label>
    <div class="input-group has-validation">
      <input type="number" name="ownerContact" class="form-control" id="validationPhonenumber" aria-describedby="inputGroupPrepend" required>
    </div>
  </div>
  <div class="col-md-6">
    <label for="validationCustom03" class="form-label">City</label>
    <input type="text" name="propertyCity" class="form-control" id="validationCustom03" required>
    <div class="invalid-feedback">
      Please provide a valid city.
    </div>
  </div>
  <div class="col-md-3">
    <label for="validationCustom04" class="form-label">State</label>
    <select class="form-select" name="propertyState" id="validationCustom04" required>
      <option selected disabled value="">Choose...</option>
      <option >Province 1</option>
      <option >Madhesh</option>
      <option >Bagmati</option>
      <option >Gandaki</option>
      <option >Lumbini</option>
      <option >Karnali</option>
      <option >Sudurpashchim</option>
    </select>
    <div class="invalid-feedback">
      Please select a valid state.
    </div>
  </div>
  <div class="col-md-4">
    <label for="validationCustom01" class="form-label">Price</label>
    <input type="text" name="propertyPrice" class="form-control" id="validationCustom01"  required>
  </div>
   
 <div class="col-md-4">
    <label for="validationCustom01" class="form-label"> Property Location</label>
    <input type="text" name="propertyLocation" class="form-control" id="validationCustom01"  required>
  </div>
   <div class="col-md-3">
    <label for="validationCustom04" class="form-label">Faced</label>
    <select class="form-select" name="landFaced" id="validationCustom04" required>
      <option selected disabled value="">Choose...</option>
      <option >East</option>
      <option >West</option>
      <option >North</option>
      <option >South</option>
      <option >SouthWest</option>
      <option >SouthEast</option>
      <option >NorthEast</option>
      <option >NorthWest</option>
    </select>
    <div class="invalid-feedback">
      Please select a valid state.
    </div>
  </div>
  
  
  
   <div class="col-md-4">
<label for="validationCustom01" class="form-label">Road</label>
    <input type="text" class="form-control" name="landRoad" id="validationCustom01" placeholder="in feet" required>
  
  </div>
    <label for="validationCustom01" class="form-label">Land size</label>
   <div >
    <input style="width:10%" type="number" name="ropaniSize" id="validationCustom01" value="0"  required> <label>Ropani</label>
    <input style="width:10%; margin-left:10px;" type="text" name="aanaSize" id="validationCustom01" value="0"  required> <label>Aana</label>
    
    <input style="width:10%; margin-left:10px;" type="text" name="paisaSize" id="validationCustom01" value="0"   required> <label>Paisa</label>
    <input style="width:10%; margin-left:10px;" type="text" name="damSize" id="validationCustom01" value="0"   required> <label>Dam</label> 
  </div>
  
  
 
 
 
   <div>
    <label>Upload the pictures of your land</label>
  </div>
  
  <div class="input-group mb-3">
  <input type="file" class="form-control" id="inputGroupFile02" multiple="multiple" name="landImage" required>
  <label class="input-group-text" for="inputGroupFile02">Upload</label>
</div>

 <div>
    <label>Upload the picture of  lalpurja of your land</label>
  </div>
  
  <div class="input-group mb-3">
  <input type="file" class="form-control" id="inputGroupFile02" multiple="multiple" name="lalpurjaImage" required>
  <label class="input-group-text" for="inputGroupFile02">Upload</label>
</div>
  
   <div>
    <label>Upload the picture of citizenship of land owner </label>
  </div>
  
  <div class="input-group mb-3">
  <input type="file" class="form-control" id="inputGroupFile02" multiple="multiple" name="citizenshipImage" required>
  <label class="input-group-text" for="inputGroupFile02">Upload</label>
</div>
  
<div>
<input type="hidden" value="false" name="validatedata"   required>
</div>

 <div class="col-md-4">
    <label for="validationCustom04" class="form-label"> Select Agent </label>
    <select class="form-select" name="agent" id="validationCustom04" required>
    <option selected disabled value="">Choose...</option>
    <c:forEach items="${agentlist }" var="agent"> 
      
      <option value="${agent.id }">${agent.firstName } ${agent.lastName }</option>
      </c:forEach>
       </select>
  </div>


  <div class="col-12">
    <button class="btn btn-primary" type="submit" style="background-color:green; ">Submit </button>
  </div>
</form>
</body>
</html>