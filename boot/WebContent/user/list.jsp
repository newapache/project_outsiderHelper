<%@page contentType="text/html; charset=utf-8"%>
<%@page import="java.util.*"%>
<%@page import="model.User"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	@SuppressWarnings("unchecked") 
	List<User> userList = (List<User>)request.getAttribute("userList");
	String curUserId = (String)request.getAttribute("curUserId");
%>
<html>
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
<body >
	
	
	    <nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav" >
      <div class="container">

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
               내 쪽지함<a class="nav-link" href="<c:url value='/user/list' />">
              <img src="<c:url value='../img/rcmail.png'/>" height="30" width="30" alt="rr"/></a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    
    <!-- Page Header -->
    
    
	<br>
	<table style="width: 100%">
		<tr>
			<td width="20"></td>
			
		</tr>
		<tr>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td width="20"></td>
			<td>
				<table>
					<tr>
			
					</tr>
				</table> <br>
				<table style="background-color: YellowGreen">
					<tr>
						<td width="190" align="center" bgcolor="F0DE9E" height="22">사용자
							ID</td>
						<td width="200" align="center" bgcolor="F0DE9E">이름</td>
						<td width="200" align="center" bgcolor="F0DE9E">쪽지보내기</td>
					</tr>
					<%
					
	if (userList != null) {	
	  Iterator<User> userIter = userList.iterator();
	
	  //사용자 리스트를 클라이언트에게 보여주기 위하여 출력.
	  while ( userIter.hasNext() ) {
		User user = (User)userIter.next();
%>
					<tr>
						<td width="190" align="center" bgcolor="ffffff" height="20">
							<%=user.getUserId()%>
						</td>
						<td width="200" align="center" bgcolor="ffffff" style="padding-left: 10"><a
							href="<c:url value='/user/view'>
					   <c:param name='userId' value='<%=user.getUserId()%>'/>
			 		 </c:url>">
								<%=user.getName()%></a></td>
						<td width="200" align="center" bgcolor="ffffff" height="20">
							 <a class="nav-link" href="<c:url value='/user/list' />">
              					<img src="<c:url value='../img/paper-plane.png'/>" height="30" width="30" alt="rr"/></a>
						</td>
					</tr>
					<%
	  }
	}
%>
				</table> <br>
			</td>
		</tr>
	</table>
</body>
</html>