<%@page contentType="text/html; charset=utf-8" %>
<%@page import="model.AnonymousDTO" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
   AnonymousDTO aboard = (AnonymousDTO)request.getAttribute("aboard");
%>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Clean Blog - Start Bootstrap Theme</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value='/css/clean-blog.min.css'/>" rel="stylesheet">

    <!-- Custom fonts for this template -->
    <link href="<c:url value='/vendor/fontawesome-free/css/all.min.css'/>" rel="stylesheet" type="text/css">
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="<c:url value='/css/clean-blog.min.css'/>" rel="stylesheet">
    <!--  <link href="css/clean-blog.min.css" rel="stylesheet">-->

<!-- 붙 -->
<!--   Bootstrap core CSS -->
    <link href="<c:url value='/vendor/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet">   
    <!--  Bootstrap core CSS -->
    <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
  

  <!--   Custom fonts for this template -->
    <link href="<c:url value='/vendor/fontawesome-free/css/all.min.css'/>" rel="stylesheet" type="text/css">
    <link href='//fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'> 

<!-- 추가 -->
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
  <script>
function userRemove() {
   return confirm("정말 삭제하시겠습니까?");      
}
</script>
  
  </head>

  <body>

      <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
      <div class="container">
        <a class="navbar-brand" href="index.html">Start Bootstrap</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          Menu
          <i class="fas fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item">
              <a class="nav-link" href="index.html">Home</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="<c:url value='/lecture_board/list' />">Lecture</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="post.html">Sample Post</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="<c:url value='/anonymous_board/list' />">Anonymous</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="login.html">login</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Header -->
    <header class="masthead" style="background-image: url('../img/contact-bg.jpg')">
      <div class="overlay"></div>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <div class="page-heading">
            </div>
          </div>
        </div>
      </div>
    </header>

    <!-- Main Content -->

      <!--header -->
<div class="container">
   <div class="mt-5">
      <div class="panel panel-default">
        <div class="panel-heading clearfix">
          <h3 class="panel-title" style="text-align: center;">익명글&nbsp;${aboard.aboardID}</h2>
        </div>
        <div class="panel-heading clearfix">
        [&nbsp;${aboard.category}&nbsp;]&nbsp;&nbsp;&nbsp;<b>${aboard.title}</b>&nbsp;&nbsp;${aboard.writeTime}
        </div>   
      <div class="panel-body" style="white-space:pre;">${aboard.content}</div> 
         <hr>
        <div class="panel-body" style="text-align: center;">
                        <a class="btn btn-danger mx-1" href="<c:url value='/anonymous_board/update/form?updateId=${aboard.aboardID}' />">수정</a>
                        <a class="btn btn-danger mx-1" href="<c:url value='/anonymous_board/delete'>
                                 <c:param name='deleteId' value='${aboard.aboardID}'/>
                                </c:url>" onclick="return userRemove();">삭제</a>
                        <a class="btn btn-danger mx-1" href="<c:url value='/anonymous_board/list' />">목록</a> 
         </div>
      </div>
   </div>
</div>

    <!-- Footer -->
    <footer>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <ul class="list-inline text-center">
              <li class="list-inline-item">
                <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fas fa-circle fa-stack-2x"></i>
                    <i class="fab fa-twitter fa-stack-1x fa-inverse"></i>
                  </span>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fas fa-circle fa-stack-2x"></i>
                    <i class="fab fa-facebook-f fa-stack-1x fa-inverse"></i>
                  </span>
                </a>
              </li>
              <li class="list-inline-item">
                <a href="#">
                  <span class="fa-stack fa-lg">
                    <i class="fas fa-circle fa-stack-2x"></i>
                    <i class="fab fa-github fa-stack-1x fa-inverse"></i>
                  </span>
                </a>
              </li>
            </ul>
            <p class="copyright text-muted">Copyright &copy; Your Website 2018</p>
          </div>
        </div>
      </div>
    </footer>

    <!--   Bootstrap core JavaScript-->
    <script src="/vendor/jquery/jquery.min.js"></script>
    <script src="/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Contact Form JavaScript-->
    <script src="/js/jqBootstrapValidation.js"></script>
    <script src="/js/contact_me.js"></script>

    <!-- Custom scripts for this template -->
    <script src="/js/clean-blog.min.js"></script>

  </body>

</html>