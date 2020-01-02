<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*" %>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import="java.io.PrintWriter"%>
<%
	LectureDTO lecture = (LectureDTO)request.getAttribute("lecture");
%>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Clean Blog - Start Bootstrap Theme</title>
    
    
    <!-- Custom styles for this template-->
    <link href="<c:url value='/css/clean-blog.min.css'/>" rel="stylesheet">

   <!--   Custom fonts for this template-->
    <link href="<c:url value='/vendor/fontawesome-free/css/all.min.css'/>" rel="stylesheet" type="text/css" >
    <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel='stylesheet' type='text/css'>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel='stylesheet' type='text/css'>
     <!-- Custom styles for this template -->
    <link href="<c:url value='/css/clean-blog.min.css'/>" rel="stylesheet"> 
   

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

 

    <!-- form-->
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>

    <link href="//netdna.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
	<script src="//netdna.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
	<!---- Include the above in your HEAD tag -------->

	<!-- Include the plugin's CSS and JS:-->
	<script type="text/javascript" src="http://davidstutz.github.io/bootstrap-multiselect/dist/js/bootstrap-multiselect.js"></script>
	<style type="text/css">
	@import url("http://davidstutz.github.io/bootstrap-multiselect/dist/css/bootstrap-multiselect.css");
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
	              <a class="nav-link" href="about.html">About</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="post.html">Sample Post</a>
	            </li>
	            <li class="nav-item">
	              <a class="nav-link" href="contact.html">Contact</a>
	            </li>
	          </ul>
	        </div>
      </div>
    </nav>

    <!-- Page Header -->
    <header class="masthead" style="background-image: url('../img/about-bg.jpg')">
      <div class="overlay"></div>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <div class="page-heading">
              <h1>About Me</h1>
              <span class="subheading">This is what I do.</span>
            </div>
          </div>
        </div>
      </div>
    </header>

    

	<!--등록하기 버튼 누르면 나타나는 모달 다이어로그 -->

		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal">평가 등록</h5>
				</div>
				<div class="modal-body">
					<form action="<c:url value='/lecture_board/update' />" method="post">
						<div class="form-row">
							<div class="form-group col-sm-6">
								<label>강의명</label>
								<input type="text" id="LectureName" name="LectureName"  value = "<%= lecture.getLectureName() %>" class="form-control" maxlength="20">
							</div>
							<div class="form-group col-sm-6">
								<label>교수명</label>
								<input type="text" id="professorName" name="professorName" value = "<%= lecture.getProfessorName() %>" class="form-control" maxlength="20">
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-sm-4">
								<label>수강 연도</label>
								<select name="lectureYear" class="form-control">
									<option value="2011" <c:if test="${lecture.lectureYear == 2011}">selected</c:if> >2011</option>
									<option value="2012" <c:if test="${lecture.lectureYear == 2012}">selected</c:if>>2012</option>
									<option value="2013" <c:if test="${lecture.lectureYear == 2013}">selected</c:if>>2013</option>
									<option value="2014" <c:if test="${lecture.lectureYear == 2014}">selected</c:if>>2014</option>
									<option value="2015" <c:if test="${lecture.lectureYear == 2015}">selected</c:if>>2015</option>
									<option value="2016" <c:if test="${lecture.lectureYear == 2016}">selected</c:if>>2016</option>
									<option value="2017" <c:if test="${lecture.lectureYear == 2017}">selected</c:if>>2017</option>
									<option value="2018" <c:if test="${lecture.lectureYear == 2018}">selected</c:if>>2018</option>	
				
								</select>
							</div>
							<div class="form-group col-sm-4">
								<label>수강 학기</label>
								<select name="semesterDivide" class="form-control">
									<option value="1학기" <c:if test="${lecture.semesterDivide eq '1학기'}">selected</c:if>>1학기</option>
									<option value="여름학기" <c:if test="${lecture.semesterDivide eq '여름학기'}">selected</c:if>>하계 계절</option>
									<option value="2학기" <c:if test="${lecture.semesterDivide eq '2학기'}">selected</c:if>>2학기</option>
									<option value="겨울학기" <c:if test="${lecture.semesterDivide eq '겨울학기'}">selected</c:if>>동계 계절</option>
								</select>
							</div>
								<div class="form-group col-sm-4">
								<label>수강 학기</label>
								<select name="LectureDivide" class="form-control">
									<option value="전공" <c:if test="${lecture.lectureDivide eq '전공'}">selected</c:if>>전공</option>
									<option value="교양" <c:if test="${lecture.lectureDivide eq '교양'}">selected</c:if>>교양</option>
									<option value="기타" <c:if test="${lecture.lectureDivide eq '기타'}">selected</c:if>>기타</option>
								</select>
							</div>
						</div>
						<div class="from-group">
							<label>제목</label>
							<input type="text" name="title" value = "<%= lecture.getTitle() %>" class="form-control" maxlength="30">
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea name="content" class="form-control" maxlength="2048" style="height: 180px;"><%= lecture.getContent()%></textarea>
						</div>
						<div class="form-row">
							<div class="form-group col-sm-3">
								<label>발표</label>
								<select name="announcement" class="form-control">
									<option value="n" <c:if test="${lecture.hasAnnounceMent eq 'n'}">selected</c:if>>없음</option>
									<option value="y" <c:if test="${lecture.hasAnnounceMent eq 'y'}">selected</c:if>>있음</option>
								</select>
							</div>
							<div class="form-group col-sm-3">
								<label>토론</label>
								<select name="discussion" class="form-control">
									<option value="n" <c:if test="${lecture.hasDebate eq 'n'}">selected</c:if>>없음</option>
									<option value="y" <c:if test="${lecture.hasDebate eq 'y'}">selected</c:if>>있음</option>
								</select>
							</div>
							<div class="form-group col-sm-3">
								<label>팀플</label>
								<select name="project" class="form-control">
									<option value="n" <c:if test="${lecture.hasProject eq 'n'}">selected</c:if>>없음</option>
									<option value="y" <c:if test="${lecture.hasProject eq 'y'}">selected</c:if>>있음</option>
								</select>
							</div>
							<div class="form-group col-sm-3">
								<label>평점</label>
								<select name="TotalScore" class="form-control">
									<option value="A" <c:if test="${lecture.totalScore eq 'A'}">selected</c:if>>A</option>
									<option value="B" <c:if test="${lecture.totalScore eq 'B'}">selected</c:if>>B</option>
									<option value="C" <c:if test="${lecture.totalScore eq 'C'}">selected</c:if>>C</option>
									<option value="D" <c:if test="${lecture.totalScore eq 'D'}">selected</c:if>>D</option>
									<option value="F" <c:if test="${lecture.totalScore eq 'F'}">selected</c:if>>F</option>
								</select>
							</div>
						</div>
						<div class="modal-footer">
							<input type="" hidden="" name="lectureID" value="<%= lecture.getLectureID()%>">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
							<button type="submit" class="btn btn-primary">수정하기</button>
						</div>
					</form>
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

   
     <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Custom scripts for this template -->
    <script src="js/clean-blog.min.js"></script>

  </body>

</html>