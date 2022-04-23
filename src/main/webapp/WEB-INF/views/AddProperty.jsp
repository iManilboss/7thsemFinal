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

<form action="${pageContext.request.contextPath }/user/addHome" method="post" class="row g-3 needs-validation" novalidate style="margin-top: 10px; background-color: lightblue; width:50%; vertical-align: middle; text-align: left; display: flex;margin-left: 26%" enctype="multipart/form-data" >
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
    <label for="validationCustom01" class="form-label">House Area</label>
    <input type="text" name="propertySize" class="form-control" id="validationCustom01"  placeholder="in sq.ft" required>
  </div>
 <div class="col-md-4">
    <label for="validationCustom01" class="form-label"> Property Location</label>
    <input type="text" name="propertyLocation" class="form-control" id="validationCustom01"  required>
  </div>
   <div class="col-md-3">
    <label for="validationCustom04" class="form-label">Faced</label>
    <select class="form-select" name="houseFaced" id="validationCustom04" required>
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
    <label for="validationCustom04" class="form-label">House Type</label>
    <select class="form-select" name="houseType" id="validationCustom04" required>
      <option selected disabled value="">Choose...</option>
      <option>Apartment</option>
      <option>Single Family</option>
      <option>Town House</option>
      <option>Cottage</option>
      <option>FarmHouse</option>
      <option>Bunglow</option>
      <option>Multifamily House</option>
      <option>Mobile House</option>
    </select>
    <div class="invalid-feedback">
      Please select a valid state.
    </div>
  </div>
  
   <div class="col-md-4">


<label for="validationCustom01" class="form-label">Road</label>
    <input type="text" class="form-control" name="houseRoad" id="validationCustom01" placeholder="in feet" required>
  
  </div>
    <label for="validationCustom01" class="form-label">Land size</label>
   <div >
    <input style="width:10%" type="number" name="ropaniSize" id="validationCustom01" value="0"  required> <label>Ropani</label>
    <input style="width:10%; margin-left:10px;" type="text" name="aanaSize" id="validationCustom01" value="0"  required> <label>Aana</label>
    
    <input style="width:10%; margin-left:10px;" type="text" name="paisaSize" id="validationCustom01" value="0"  required> <label>Paisa</label>
    <input style="width:10%; margin-left:10px;" type="text" name="damSize" id="validationCustom01" value="0"  required> <label>Dam</label> 
  </div>
  
  
  <label>Property Type</label>
 <div class="btn-group" role="group" aria-label="Basic radio toggle button group">
  <input type="radio" class="btn-check"  name="propertyType" id="btnradio1" autocomplete="off" checked>
  <label class="btn btn-outline-primary" for="btnradio1">Residential</label>

  <input type="radio" class="btn-check"  id="btnradio2" name="propertyType"  autocomplete="off">
  <label class="btn btn-outline-primary" for="btnradio2">Commercial</label>

 </div>
 
 
   <div>
    <label>Upload the pictures of your house</label>
  </div>
  
  <div class="input-group mb-3">
  <input type="file" class="form-control" multiple="multiple"  id="inputGroupFile02"  name="houseImage" required>
  <label class="input-group-text" for="inputGroupFile02">Upload</label>
</div>

 <div>
    <label>Upload the picture of  lalpurja of your house</label>
  </div>
  
  <div class="input-group mb-3">
  <input type="file" class="form-control" multiple="multiple" id="inputGroupFile02"  name="lalpurjaImage" required>
  <label class="input-group-text" for="inputGroupFile02">Upload</label>
</div>
  
   <div>
    <label>Upload the picture of citizenship of House owner </label>
  </div>
  
  <div class="input-group mb-3">
  <input type="file" class="form-control"  multiple="multiple"  id="inputGroupFile02"  name="citizenshipImage" required>
  <label class="input-group-text" for="inputGroupFile02">Upload</label>
</div>
  
<label>Facilities</label>
<div class="btn-group" role="group" aria-label="Basic checkbox toggle button group">
  <input type="checkbox" class="btn-check" name="facilities" id="btncheck1" value="Parking" autocomplete="off">
  <label class="btn btn-outline-primary"  for="btncheck1">Parking</label>

  <input type="checkbox" class="btn-check" name="facilities" id="btncheck2" value="Garden"  autocomplete="off">
  <label class="btn btn-outline-primary" for="btncheck2">Garden</label>

  <input type="checkbox" class="btn-check"  name="facilities" id="btncheck3"  value="Electricity"  autocomplete="off">
  <label class="btn btn-outline-primary" for="btncheck3">Electricity</label>
  
  <input type="checkbox" class="btn-check" name="facilities" id="btncheck4" value="WaterSupply"  autocomplete="off">
  <label class="btn btn-outline-primary" for="btncheck4">WaterSupply</label>
  
  <input type="checkbox" class="btn-check" name="facilities" id="btncheck5" value="Telephone"  autocomplete="off">
  <label class="btn btn-outline-primary" for="btncheck5">Telephone</label>
  
  <input type="checkbox" class="btn-check" name="facilities" id="btncheck6" value="Internet"  autocomplete="off">
  <label class="btn btn-outline-primary" for="btncheck6">Internet</label>
  
  <input type="checkbox" class="btn-check" name="facilities" id="btncheck7" value="Cable TV"  autocomplete="off">
  <label class="btn btn-outline-primary" for="btncheck7">Cable TV</label>
</div>


   <label for="validationCustom01" class="form-label">Features</label>
   <div >
    <input style="width:6%" type="number" id="validationCustom01" name="livingRoom" required> <label>Living Room</label>
    <input style="width:6%; margin-left:8px;" type="number" id="validationCustom01" name="floor" required> <label>Floors</label>
    <input style="width:6%; margin-left:8px;" type="number" id="validationCustom01" name="bedroom"  required> <label>Bedrooms</label>
    <input style="width:6%; margin-left:8px;" type="number" id="validationCustom01" name="kitchen"  required> <label>Kitchen</label> 
    <input style="width:6%; margin-left:8px;" type="number" id="validationCustom01" name="bathroom" required> <label>Bathrooms</label>
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
  
  

  <div >
    <button class="btn btn-primary" type="submit" style="background-color:green; display:center; ">Submit </button>
  </div>
</form>
</body>
</html>