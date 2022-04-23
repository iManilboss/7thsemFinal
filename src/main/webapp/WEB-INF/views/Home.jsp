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

   
    <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/style.css">
  
     <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/slider.css">
  
  
   <style >
   
    
 .search input[type=text]{
        width:75%;
        height:75%;
        border-radius:25px;
        border:solid;
    }
          
    .search{
        float:right;
        margin:4px;
    }
          
    .search button{
        background-color: #0074D9;
        color: #f2f2f2;
        float: right;
        padding: 2px 6px;
        margin-right: 16px;
        margin-bottom: 4px;
        font-size: 12px;
        border: none;
        cursor: pointer;
    }
 </style>

</head>
<body>
    
<!-- header section starts  -->


 
 <header>

    <a href="#home" class="logo"><span>real</span>Estate</a>

    <nav class="navbar">
        <a href="#home">home</a>
        <a href="#services">services</a>
        <a href="#featured">featured</a>
        <a href="#agents">agents</a>
        <a href="#contact">contact</a>
        
        
            
        
 
    </nav>
    
  
      
   
   
      
      
    <div class="icons">
        <div id="menu-bars" class="fas fa-bars"></div>
       <!-- <a href="#" class="fas fa-heart"></a> --> 
        <a href="${pageContext.request.contextPath }/login" >Login</a>
       
         <a href="${pageContext.request.contextPath }/register" >Signup</a>
         
          
    </div>


 
</header>
     

<!-- header section ends -->

<!-- home section starts  -->

<section class="home" id="home">



    
    <!--  
   
-->
<!--image slider start-->
    <div class="slider">
      <div class="slides">
        <!--radio buttons start-->
        <input type="radio" name="radio-btn" id="radio1">
        <input type="radio" name="radio-btn" id="radio2">
        <input type="radio" name="radio-btn" id="radio3">
        <input type="radio" name="radio-btn" id="radio4">
        <!--radio buttons end-->
        <!--slide images start-->
        <div class="slide first">
          <img src="${pageContext.request.contextPath}/assets/image/A.jpg" alt="">
        </div>
        <div class="slide">
          <img src="${pageContext.request.contextPath}/assets/image/B.jpg" alt="">
        </div>
        <div class="slide">
          <img src="${pageContext.request.contextPath}/assets/image/C.png" alt="">
        </div>
        <div class="slide">
          <img src="${pageContext.request.contextPath}/assets/image/D.jpg" alt="">
        </div>
        <!--slide images end-->
        <!--automatic navigation start-->
        <div class="navigation-auto">
          <div class="auto-btn1"></div>
          <div class="auto-btn2"></div>
          <div class="auto-btn3"></div>
          <div class="auto-btn4"></div>
        </div>
        <!--automatic navigation end-->
      </div>
      <!--manual navigation start-->
      <div class="navigation-manual">
        <label for="radio1" class="manual-btn"></label>
        <label for="radio2" class="manual-btn"></label>
        <label for="radio3" class="manual-btn"></label>
        <label for="radio4" class="manual-btn"></label>
      </div>
      <!--manual navigation end-->
    </div>
    <!--image slider end-->
    <script type="text/javascript">
    var counter = 1;
    setInterval(function(){
      document.getElementById('radio' + counter).checked = true;
      counter++;
      if(counter > 4){
        counter = 1;
      }
    }, 5000);
    </script>
</section>

<!-- home section ends -->

<!-- services section starts  -->

<section class="services" id="services">

    <h1 class="heading"> our <span>services</span> </h1>

    <div class="box-container">

        <div class="box">
            <img src="${pageContext.request.contextPath}/assets/image/housebuy.png" alt="">
            <h3>buying home</h3>
            <p>Buy beautiful homes at affordable price. You can choose from multiple options at one place.</p>
            <a href="${pageContext.request.contextPath}/home" class="btn">Search Homes</a>
        </div>



        <div class="box">
            <img src="${pageContext.request.contextPath}/assets/image/deall.png" alt="">
            <h3>selling home</h3>
            <p>Choose the way you want to sell your house and we will be there to help you to get maximum price.</p>
            <a href="${pageContext.request.contextPath}/user/addproperty" class="btn">See Options</a>
        </div>
        
            <div class="box">
            <img src="${pageContext.request.contextPath}/assets/image/plot.png" alt="">
            <h3>buying land</h3>
            <p>Buy land whether for residential or commercial purpose. You can find any kinds of attractive plot here.</p>
            <a href="${pageContext.request.contextPath}/land" class="btn">Search Lands</a>
        </div>
        
            <div class="box">
            <img src="${pageContext.request.contextPath}/assets/image/landsale.png" alt="">
            <h3>selling land</h3>
            <p>We are creating online experience to sell land plot at proper price in short time possible. 
            You can list your land plot here for sale.</p>
            <a href="${pageContext.request.contextPath}/user/addLand" class="btn">See Options </a>
        </div>

    </div>

</section>

<!-- services section ends -->

<!-- featured section starts  -->




<h1 class="heading"> <span>featured</span> properties </h1>
 <c:forEach items="${homedetails }" var="home">  
 <c:if test="${home.id < 20 }">


<section class="featured" id="featured">
<div class="box-container">

        <div class="box">
            <div class="image-container">
            <img src="${pageContext.request.contextPath }/property_image/${home.houseImage[0] }" alt="notfound_image"
	 height="200px" width="200px">
              
             
            </div>
            <div class="content">
                <div class="price">
                    <h3>Rs ${home.propertyPrice }</h3>
                    
                    <a href="#" class="fas fa-envelope"></a>
                    <a href="#" class="fas fa-phone"></a>
                </div>
                <div class="location">
                    <h3>${home.houseType} </h3>
                    <p>${home.propertyLocation}</p>
                </div>
                <div class="details">
                    <h3> <i class="fas fa-expand"></i>${home.propertySize }sqft </h3>
                    <h3> <i class="fas fa-bed"></i> ${home.bedroom }Beds </h3>
                    <h3> <i class="fas fa-bath"></i> ${home.bathroom } Bathroom </h3>
                     
                     
                </div>
                <div class="buttons">
                    <a href="${pageContext.request.contextPath }/onedetail/${home.id}" class="btn">view details</a>
                    <a href="${pageContext.request.contextPath }/home" class="btn">view others</a>
                </div>
            </div>
        </div>
        </div>
        </section>
   


<div>


</div>
</c:if>
</c:forEach>



 <c:forEach items="${landdetails }" var="home">  
 <c:if test="${home.id < 53 }">


<section class="featured" id="featured">
<div class="box-container">

        <div class="box">
            <div class="image-container">
            <img src="${pageContext.request.contextPath }/property_image/${home.landImage[0] }" alt="notfound_image"
	 height="200px" width="200px">
              
             
            </div>
            <div class="content">
                <div class="price">
                    <h3>Rs ${home.propertyPrice }</h3>
                    
                
                </div>
                <div class="location">
                  
                    <p>${home.propertyLocation}</p>
                </div>
               
                <div class="buttons">
                    <a href="${pageContext.request.contextPath }/landonedetail/${home.id}" class="btn">view details</a>
                    <a href="${pageContext.request.contextPath }/land" class="btn">view others</a>
                </div>
            </div>
        </div>
        </div>
        </section>
   


<div>


</div>
</c:if>
</c:forEach>

<!-- featured section ends -->



<!-- agents section starts  -->

<section class="agents" id="agents">

    <h1 class="heading"> professional <span>agents</span> </h1>

    <div class="box-container">
<c:forEach items="${agent }" var="agent"> 
        <div class="box">
         
            <img src="${pageContext.request.contextPath}/agent_image/${agent.photo}" alt="">
            <h3> ${agent.firstName } ${agent.lastName }</h3>
            <span>agent</span>
           
        </div>
</c:forEach>
    

    </div>

</section>

<!-- agents section ends -->



<!-- contact section starts  -->

<section class="contact" id="contact">

<h1 class="heading"> <span>contact</span> us </h1>

<div class="icons-container">

    <div class="icons">
        <img src="${pageContext.request.contextPath}/assets/image/icon-1.png" alt="">
        <h3>phone number</h3>
        <p>9803210055</p>
        <p>9841229751</p>
        
    </div>

    <div class="icons">
        <img src="${pageContext.request.contextPath}/assets/image/icon-2.png" alt="">
        <h3>email address</h3>
        <p>imanilboss@gmail.com</p>
        <p>sauravdangol@gmail.com</p>
        <p>rudrakandel@gmail.com</p>
        
    </div>

     <div class="icons">
        <img src="${pageContext.request.contextPath}/assets/image/icon-3.png" alt="">
        <h3>office address</h3>
        <p>Bagbazar,Kathmandu,Nepal</p>
    </div>

</div>

<div class="row">

    <form action="">
        <div class="inputBox">
            <input type="text" placeholder="name">
            <input type="number" placeholder="number">
        </div>
        <div class="inputBox">
            <input type="email" placeholder="email">
            <input type="text" placeholder="subject">
        </div>
        <textarea name="" placeholder="message" id="" cols="30" rows="10"></textarea>
        <input type="submit" value="send message" class="btn">
    </form>

<div>
     <iframe width="500" height="400" frameborder="0" src="https://www.bing.com/maps/embed?h=400&w=500&cp=27.705871388248212~85.31484603881836&lvl=13&typ=d&sty=r&src=SHELL&FORM=MBEDV8" scrolling="no">
     </iframe>
     <div style="white-space: nowrap; text-align: center; width: 500px; padding: 6px 0;">
        <a id="largeMapLink" target="_blank" href="https://www.bing.com/maps?cp=27.705871388248212~85.31484603881836&amp;sty=r&amp;lvl=13&amp;FORM=MBEDLD">View Larger Map</a> &nbsp; | &nbsp;
        <a id="dirMapLink" target="_blank" href="https://www.bing.com/maps/directions?cp=27.705871388248212~85.31484603881836&amp;sty=r&amp;lvl=13&amp;rtp=~pos.27.705871388248212_85.31484603881836____&amp;FORM=MBEDLD">Get Directions</a>
    </div>
</div>	
</div>

</section>

<!-- contact section ends -->

<!-- footer section starts  -->

<section class="footer">

    <div class="footer-container">

        <div class="box-container">

            <div class="box">
                <h3>branch location</h3>
                <a href="#">Kathmandu</a>
                <a href="#">Bhaktapur</a>
                <a href="#">Lalitpur</a>
                <a href="#">Pokhara</a>
                <a href="#">Ithari</a>
            </div> 
            
            <div class="box">
                <h3>quick links</h3>
                <a href="#">home</a>
                <a href="#">services</a>
                <a href="#">featured</a>
                <a href="#">agents</a>
                <a href="#">contact</a>
            </div> 

        

            <div class="box">
                <h3>follow us</h3>
                <a href="#">facebook</a>
                <a href="#">twitter</a>
                <a href="#">instagram</a>
                <a href="#">linkedin</a>
            </div> 

        </div>
    </div>

</section>

<!-- footer section ends -->



<!-- javascript part  -->
<script>

let menu = document.querySelector('#menu-bars');
let navbar = document.querySelector('.navbar');

menu.onclick = () =>{
    navbar.classList.toggle('active');
    menu.classList.toggle('fa-times');
}

window.onscroll = () =>{
    navbar.classList.remove('active');
    menu.classList.remove('fa-times');
}

</script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/searchScript.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/assets/js/searchSuggestion.js"></script>


</body>
</html>