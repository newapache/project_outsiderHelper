<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*" %>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<%
   @SuppressWarnings("unchecked") 
   List<AnonymousDTO> AboardList = (List<AnonymousDTO>)request.getAttribute("AboardList");
   //String curUserId = (String)request.getAttribute("curUserId");
   
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
    <link href="<c:url value='/vendor/fontawesome-free/css/all.min.css'/>" rel="stylesheet" type="text/css" >
    <link href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="<c:url value='/css/clean-blog.min.css'/>" rel="stylesheet">

    <!-- form -->
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
   <script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
   <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

       <!--Bootstrap core CSS -->
    <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
   <!--   커스텀 CSS 추가하기 -->
   <link rel="stylesheet" href="/css/custom.css"/>

<!--   Bootstrap core CSS -->
    <link href="<c:url value='/vendor/bootstrap/css/bootstrap.min.css'/>" rel="stylesheet"> 
    
    
    <!--  Bootstrap core CSS -->
    <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
  

  <!--   Custom fonts for this template -->
    <link href="<c:url value='/vendor/fontawesome-free/css/all.min.css'/>" rel="stylesheet" type="text/css">
    <link href='//fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'> 
   
   
<!------ Include the above in your HEAD tag ---------->

<!-- Include the plugin's CSS and JS: -->
<script type="text/javascript" src="http://davidstutz.github.io/bootstrap-multiselect/dist/js/bootstrap-multiselect.js"></script>

<style type="text/css">
@import url("http://davidstutz.github.io/bootstrap-multiselect/dist/css/bootstrap-multiselect.css");
</style>
  
<!-- 추가 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/foundation/6.2.4/foundation.min.css" /> <!-- 충돌 -->
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css" />
<style type="text/css">
   a, a:hover{
      color: #000000;
      
   }
</style>

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
            <li class="nav-item">
              <a class="nav-link" href="<c:url value='/user/list' />">
              <img src="<c:url value='../img/mail.png'/>" height="30" width="30" alt="rr"/></a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Header -->
    <header class="masthead" style="background-image: url('../img/temp1.png')">
     
      <div class="container" height="50">
        <div class="row">
          <div class="col-lg-4 col-md-1 mx-auto">
            <div class="page-heading">
            <br><br><br>
              <h3>강의게시판</h3>
              <span class="subheading">Have questions? I have answers.</span>
            </div>
          </div>
        </div>
      </div>
    </header>

  
     <!-- filtering -->
   <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <!--  <a class="navbar-brand" href="#">익명게시판</a> -->
             <div class="row pull-left">
            <p style="text-align: center; font-size: 20px">익명게시판</p>
        </div>
   </nav>
  <section class="container">
      <form method="get"  action="<c:url value='/anonymous_board/search'></c:url>" class="form-inline mt-2">
         <select name="AnonymousDivide" class="form-control mx-1 mt-3">
            <option value="전체">전체</option>
            <option value="잡담">잡담</option>
            <option value="고민">고민</option>
            <option value="팀플">팀플</option>
            
         </select> 
         <input type="text" name="search" class="form-control mx-1 mt-3" placeholder="제목+내용을 입력하세요.">
         <button type="submit" class="btn btn-primary mx-1">검색</button>
         <a class="btn btn-danger mx-1" href="<c:url value='/anonymous_board/register/post' />">글쓰기</a>
      </form>
   
   <!-- board -->
      <div class="mt-5" style="text-align: center;">    
      <table width="100%" class="display" id="myTable" cellspacing="0">
                <thead>
                    <tr>
                        
                        <th style="text-align: center;">분류</th>
                        <th style="text-align: center;">제목</th>
                        <th style="text-align: center;">작성날짜</th>
                        <th style="text-align: center;">조회수</th>
                    </tr>
                </thead>
                
                  <tbody>
   <c:forEach var="aboard" items="${AboardList}">
                  <tr>
                        
                        <td>${aboard.category}</td>
                        <td><a href="<c:url value='/anonymous_board/view'><c:param name='aboardID' value= '${aboard.aboardID}'/> </c:url>">
                        ${aboard.title}</td>
                        <td>${aboard.writeTime}</td>
                        <td>${aboard.readCount}</td>
                     </tr>
  </c:forEach>      
</tbody>
        </table>
        <a> ${nowpage}</a>
        <a href="<c:url value='/anonymous_board/list'><c:param name='currentPage' value='1'/></c:url>">[1]</a>
        <a href="<c:url value='/anonymous_board/list'><c:param name='currentPage' value='2'/></c:url>">[2]</a>
        
        </div>
</div>

</section>
<!-- 제이쿼리 자바스크립트 추가하기  -->
   <script src="/js/jquery.min.js"></script>
   <!-- 파퍼 자바스크립트 추가하기  -->
   <script src="/js/popper.js"></script>
   <!-- 부트스트랩 자바스크립트 추가하기  -->
   <script src="/js/bootstrap.min.js"></script>

</body>