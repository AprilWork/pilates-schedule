<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<c:import url="assets/include/header.jsp"><c:param name="title" value="Happy Heart"/></c:import>
  <!-- *****************************************************************************************************************
   BLUE WRAP
   ***************************************************************************************************************** -->
  <div id="blue">
    <div class="container">
      <div class="row">
        <h3>404 Not Found</h3>
      </div>
      <!-- /row -->
    </div>
    <!-- /container -->
  </div>
  <!-- /blue -->

<div class="container mtb">
  <div class="row" >
    
      <h2 class="text-center">Sorry, we couldn't find that page</h2>
      <h4 class="text-center">Check the page address or search for it below.</h4>
      
      <form  class="centered" action="${pageContext.request.contextPath}/user" method="get">
          <div class="form-group">
            <input type="search" name="user" class="form-control"
              placeholder="Search">
            
          <div class="validate"></div>
        </div>
      </form>
    
  </div>
</div>

<c:import url="assets/include/footer.jsp"></c:import>
