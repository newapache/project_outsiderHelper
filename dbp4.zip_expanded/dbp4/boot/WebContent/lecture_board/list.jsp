<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*" %>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ page import="java.io.PrintWriter"%>

<%
	@SuppressWarnings("unchecked") 
	List<LectureDTO> lectureList = (List<LectureDTO>)request.getAttribute("lectureList");
	/* String curUserId = (String)request.getAttribute("curUserId"); */

	if(request.getAttribute("likeresult") != null && request.getAttribute("likeresult2") !=null){
	int likeresult =((Integer)request.getAttribute("likeresult")).intValue();
	int likeresult2 =((Integer)request.getAttribute("likeresult2")).intValue();
	if(likeresult == 0){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('이미 추천을 누른 글입니다.');");
		script.println("history.back();");
		script.println("</script>");
		script.close();
		return;
	}
	if(likeresult2 == 0){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('데이터베이스 오류입니다.');");
		script.println("history.back();");
		script.println("</script>");
		script.close();
		return;
	}
	if(likeresult != 0 && likeresult2 != 0){
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('추천되었습니다.');");
		script.println("location.href='/boot/lecture_board/list'");
		script.println("</script>");
		script.close();
		return;
	}
	}
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
	<script>
	
	
/* 	function modal_view(lectureID,lectureName,totalScore,title,lectureYear,semesterDivide ,content,hasAnnounceMent,hasDebate,hasProject)
	{
		
		$('#registerModal').on('show.bs.modal', function (event) {
			alert(lectureID);
			$(".modal-body #LectureName").val( "ㅚ" );
			$(".modal-body #professorName").val( "ㅚ" );
			modal.find('.modal-body #professorName').val("ㅚ");
		

		})
	} */
	
/* 	$('#registerModal').on('show.bs.modal', function (event) {
		  var a = $(event.relatedTarget)
		  var lectureName = a.data('lectureName')
		  var modal = $(this)
		  modal.find('.modal-body .form-row .form-group col-sm-6 #LectureName').val(lectureName)
		})
 */
		
		$('#exampleModal').on('show.bs.modal', function (event) {
  var button = $(event.relatedTarget)
  var recipient = button.data('whatever')
  var modal = $(this)
  modal.find('.modal-title').text('New message to ' + recipient)
  modal.find('.modal-body input').val(recipient)
})
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
              <a class="btn btn-primary mx-1 mt-2" data-toggle="modal" href="#registerModal">등록하기</a>
            </div>
          </div>
        </div>
      </div>
    </header>

    <!-- Main Content -->
    
	<!-- filtering -->
	<div class="container-fluid bg-light ">
	<form action="<c:url value='/lecture_board/search'/>" method="post" >
	<div class="col">
	<div class="row align-items-center justify-content-start">
						<div class="col-sm-3 col-md-3">
        						<h6>강의명</h6>
        						<div class="input-group">
            					<input type="text" class="form-control" placeholder="" id="LectureName" name="LectureName">
						        </div>
						</div>
						<div class="col-sm-3 col-md-3">
        						<h6>교수명</h6>
        						<div class="input-group">
            					<input type="text" class="form-control" placeholder="" id="professorName" name="professorName">
						        </div>
						</div>
	</div>
	<div class="row align-items-center justify-content-center">
						<div class="col-md-3">
						   <h6>교양영역</h6>
                           <div class="form-group ">
                              <select name="LectureDivide" class="form-control">
                                 <option value="인문" selected>인문</option>
	                              <option value="창감">창감</option>
	                              <option value="사회과학">사회과학</option>
	                              <option value="자연과학">자연과학</option>
	                              <option value="자율">자율</option>
                              </select>
                           </div>
                        </div>
                        <div class="col-md-3">
                           <h6>발표</h6>
                           <div class="form-group">
                              <select name="announcement" class="form-control">
                                <option value="n" >없음</option>
                                <option value="y" >있음</option>
                              </select>
                           </div>
                        </div>
                          <div class="col-md-3">
                            <h6>토론</h6>
                            <div class="form-group">
                              <select  name="discussion" id="inputState" class="form-control">
                                <option value="n" >없음</option>
                                <option value="y" >있음</option>
                              </select>
                           </div>
                        </div>
                        <div class="col-md-3">
                            <h6>팀플</h6>
                            <div class="form-group">
                              <select name="project" class="form-control">
                                <option value="n" >없음</option>
                                <option value="y" >있음</option>
                              </select>
                           </div>
                        </div>
                      
    </div>
   
    </div>
    <div class="col">
          <button type="submit" class="btn btn-primary btn-block">Search</button>
    </div>
    </form>
    </div>
   
      <c:forEach var="lecture" items="${lectureList}">  			  	
  
	
				<div class="card bg-light mt-3">
				<div class="card-header bg-ligth">
					<div class="row">
						<div class="col-8 text-left">${lecture.lectureName}&nbsp;<small>${lecture.professorName}</small></div>
						<div class="col-4 text-right">평점&nbsp;<span style="color: red;">${lecture.totalScore}</span></div>
					</div>
				</div>
				<div class="card-body">
					<h5 class="card-title">
						${lecture.title}&nbsp;<small>(${lecture.lectureYear}년 ${lecture.semesterDivide} ${lecture.lectureDivide}영역)</small>
					</h5>
					<p class="card-text">${lecture.content}</p>
					<div class="row">
						<div class="col-9 text-Left">
							발표&nbsp;
							<span style="color: red;">
									<c:if test="${lecture.hasAnnounceMent eq 'y'}">유</c:if> 
									<c:if test="${lecture.hasAnnounceMent eq 'n'}">무</c:if> 
							</span>
							토론&nbsp;<span style="color: red;">
							<c:if test="${lecture.hasDebate eq 'y'}">유</c:if> 
							<c:if test="${lecture.hasDebate eq 'n'}">무</c:if> 
							</span>
							팀플&nbsp;<span style="color: red;">
							<c:if test="${lecture.hasProject eq 'y'}">유</c:if> 
							<c:if test="${lecture.hasProject eq 'n'}">무</c:if> 
							</span>
							<span style="color: green;">(추천: ${lecture.likeCount})</span>
						</div>
						<div class="col-3 text-right">
						
				
							<a href="<c:url value='/lecture_board/like'><c:param name='likeId' value= '${lecture.lectureID}'/> </c:url>" onclick="return confirm('추천하시겠습니까?')">추천</a>
							<a href="<c:url value='/lecture_board/update/form'><c:param name='updateId' value= '${lecture.lectureID}'/> </c:url>" onclick="return confirm('수정하시겠습니까?')">수정</a>
							<a href="<c:url value='/lecture_board/delete'><c:param name='deleteId' value= '${lecture.lectureID}'/> </c:url>" onclick="return confirm('삭제하시겠습니까?')">삭제</a>
						</div>
					</div>
				</div>
			</div>
	  </c:forEach>  
    
    <hr>


	<!--등록하기 버튼 누르면 나타나는 모달 다이어로그 -->
	<div class="modal" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="madal" aria-hidden	="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal">평가 등록</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="<c:url value='/lecture_board/register' />" method="post">
						<div class="form-row">
							<div class="form-group col-sm-6">
								<label>강의명</label>
								<input type="text" id="LectureName" name="LectureName" class="form-control" maxlength="20">
							</div>
							<div class="form-group col-sm-6">
								<label>교수명</label>
								<input type="text" id="professorName" name="professorName" class="form-control" maxlength="20">
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-sm-4">
								<label>수강 연도</label>
								<select name="lectureYear" class="form-control">
									<option value="2011">2011</option>
									<option value="2012">2012</option>
									<option value="2013">2013</option>
									<option value="2014">2014</option>
									<option value="2015">2015</option>
									<option value="2016">2016</option>
									<option value="2017">2017</option>
									<option value="2018" selected>2018</option>	
								</select>
							</div>
							<div class="form-group col-sm-4">
								<label>수강 학기</label>
								<select name="semesterDivide" class="form-control">
									<option value="1학기" selected>1학기</option>
									<option value="여름학기">하계 계절</option>
									<option value="2학기">2학기</option>
									<option value="겨울학기">동계 계절</option>
								</select>
							</div>
								<div class="form-group col-sm-4">
								<label>수강 학기</label>
								<select name="LectureDivide" class="form-control">
									<option value="전공" selected>전공</option>
		                              <option value="인문">인문</option>
		                              <option value="창감">창감</option>
		                              <option value="사회과학">사회과학</option>
		                              <option value="자연과학">자연과학</option>
		                              <option value="자율">자율</option>
								</select>
							</div>
						</div>
						<div class="from-group">
							<label>제목</label>
							<input type="text" name="title" class="form-control" maxlength="30">
						</div>
						<div class="form-group">
							<label>내용</label>
							<textarea name="content" class="form-control" maxlength="2048" style="height: 180px;"></textarea>
						</div>
						<div class="form-row">
							<div class="form-group col-sm-3">
								<label>발표</label>
								<select name="announcement" class="form-control">
									<option value="n" selected>없음</option>
									<option value="y">있음</option>
								</select>
							</div>
							<div class="form-group col-sm-3">
								<label>토론</label>
								<select name="discussion" class="form-control">
									<option value="n" selected>없음</option>
									<option value="y">있음</option>
								</select>
							</div>
							<div class="form-group col-sm-3">
								<label>팀플</label>
								<select name="project" class="form-control">
									<option value="n" selected>없음</option>
									<option value="y">있음</option>
								</select>
							</div>
							<div class="form-group col-sm-3">
								<label>평점</label>
								<select name="TotalScore" class="form-control">
									<option value="A" selected>A</option>
									<option value="B">B</option>
									<option value="C">C</option>
									<option value="D">D</option>
									<option value="F">F</option>
								</select>
							</div>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
							<button type="submit" class="btn btn-primary">등록하기</button>
						</div>
					</form>
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

   
     <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Custom scripts for this template -->
    <script src="js/clean-blog.min.js"></script>

  </body>

</html>