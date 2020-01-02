<%@page contentType="text/html; charset=utf-8" %>
<%@page import="java.util.*" %>
<%@page import="model.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page import="java.io.PrintWriter"%>

<!DOCTYPE html>

<%
	@SuppressWarnings("unchecked") 
	List<CommercialDTO> commercialList = (List<CommercialDTO>)request.getAttribute("commercialList");
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

    <!-- Custom fonts for this template-->
    <link href="<c:url value='/vendor/fontawesome-free/css/all.min.css'/>" rel="stylesheet" type="text/css" >
    <link href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic" rel='stylesheet' type='text/css'>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800" rel='stylesheet' type='text/css'>
    
     <!-- Custom styles for this template -->
    <link href="<c:url value='/css/clean-blog.min.css'/>" rel="stylesheet"> 
   
    <!--Bootstrap core CSS -->
    <link href="<c:url value='/css/bootstrap.min.css'/>" rel="stylesheet">
	<!-- 커스텀 CSS 추가하기 -->
	<link rel="stylesheet" href="/css/custom.css"/>

    <!-- Bootstrap core CSS -->
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
    <header class="masthead" style="background-image: url('../img/post-bg.jpg')">
      <div class="overlay"></div>
      <div class="container">
        <div class="row">
          <div class="col-lg-8 col-md-10 mx-auto">
            <div class="post-heading">
              <h1>Man must explore, and this is exploration at its greatest</h1>
              <h2 class="subheading">Problems look mighty small from 150 miles up</h2>
              <span class="meta">Posted by
                <a href="#">Start Bootstrap</a>
                on August 24, 2018</span>
                     <a class="btn btn-primary mx-1 mt-2" data-toggle="modal" href="#registerModal">등록하기</a>
            </div>
          </div>
        </div>
      </div>
    </header>
	
	<!-- COMMERCIAL_BOARD: FILTERING BAR -->
	<div class="container-fluid bg-light ">
		<form action="<c:url value='/commercial_board/filter'/>" method="post" >
		<div class="row align-items-center justify-content-center">
			<div class="form-group col-md-2 pt-3">
				<label>상권명</label>
				<input type="text" name="commercialName" class="form-control" maxlength="20">
			</div>
			<div class="form-group col-md-2 pt-3">
				<label>상권분류</label>
				<label><small>*필수값입니다!</small></label>
				<select name="commercialCategory" class="form-control">
					<option value="restaurant">음식점</option>
					<option value="cafe">카페</option>
					<option value="etc" selected>기타</option>	
				</select>
             </div>
         </div>
         <div class="row align-items-center justify-content-center">
             <div class="form-group col-md-2 pt-3">
					<label>WIFI</label>
					<select name="hasWifi" class="form-control">
						<option value=""></option>
						<option value="n">없음</option>
						<option value="y">있음</option>
					</select>
			</div>
			<div class="form-group col-md-2 pt-3">
				<label>1/2인 테이블</label>
				<select name="hasSingleTable" class="form-control">
					<option value=""></option>
					<option value="n">없음</option>
					<option value="y">있음</option>
				</select>
			</div>
            <div class="form-group col-md-2 pt-3">
				<label>콘센트</label>
					<select name="hasSocket" class="form-control">
						<option value=""></option>
						<option value="n">없음</option>
						<option value="y">있음</option>
					</select>
			</div>
			<!-- </div>
			<div class="row align-items-center justify-content-center"> -->
			<div class="form-group col-md-2 pt-3">
				<label>혼잡도</label>
					<select name="congestion" class="form-control">
						<option value=""></option>
						<option value="A">여유</option>
						<option value="B">보통</option>
						<option value="C">혼잡</option>
					</select>
			</div>
			<div class="form-group col-md-2 pt-3">
				<label>가격대</label>
				<select name="price" class="form-control">
					<option value=""></option>
					<option value="z">1만원 미만</option>
					<option value="o">1 - 2만원</option>
					<option value="t">2 - 3만원</option>
				</select>
			</div>
		</div>
	   <div class="col">
           	<button type="submit" class="btn btn-primary btn-block">Search</button>
    	</div>
    	</form>
	</div>
    
	<!-- COMMECIAL_BOARD:LIST -->
	<c:forEach var="commercial" items="${commercialList}">
		<div class="card bg-light mt-3">
				<div class="card-header bg-ligth">
					<div class="row">
						<div class="col-8 text-left">${commercial.getCommercialName()}&nbsp;<small>${commercial.getCommercialCategory()}&nbsp;${commercial.getUserId()}</small></div>
						<div class="col-4 text-right">평점&nbsp;<span style="color: red;">${commercial.getGrade()}</span></div>
					</div>
				</div>
				<div class="card-body">
					<p class="card-text">${commercial.getContent()}</p>
					<div class="row">
						<div class="col-9 text-Left">
							1/2인 테이블&nbsp;<span style="color: red;">
								<c:if test="${commercial.getHasSingleTable() eq 'y'}">유</c:if> 
								<c:if test="${commercial.getHasSingleTable() eq 'n'}">무</c:if>  
							</span>
							콘센트&nbsp;<span style="color: red;">
								<c:if test="${commercial.getHasSocket() eq 'y'}">유</c:if> 
								<c:if test="${commercial.getHasSocket() eq 'n'}">무</c:if> 
							</span>
							WIFI&nbsp;<span style="color: red;">
								<c:if test="${commercial.getHasWifi() eq 'y'}">유</c:if> 
								<c:if test="${commercial.getHasWifi() eq 'n'}">무</c:if> 
							</span>
							혼잡도&nbsp;<span style="color: red;">
							<c:if test="${commercial.congestion eq 'A'}">여유</c:if> 
							<c:if test="${commercial.congestion eq 'B'}">보통</c:if> 
							<c:if test="${commercial.congestion eq 'C'}">혼잡</c:if> 
							</span>
							가격대&nbsp;<span style="color: red;">
							<c:if test="${commercial.price eq 'z'}">1만원 미만</c:if> 
							<c:if test="${commercial.price eq 'o'}">1 - 2만원</c:if> 
							<c:if test="${commercial.price eq 't'}">2 - 2만원</c:if> 
							</span>
							<span style="color: green;">(추천: ${commercial.getLikeCount()})</span>
						</div>
						<div align="right" class="col-3 text-right">
						<a href="<c:url value='/commercial_board/like'><c:param name='cBoardId' value= '${commercial.getCBoardId()}'/> </c:url>" onclick="return confirm('추천하시겠습니까?')">추천</a>
						<a href="<c:url value='/commercial_board/modify/form'><c:param name='cBoardId' value= '${commercial.getCBoardId()}'/> </c:url>" onclick="return confirm('수정하시겠습니까?')">수정</a>
						<a href="<c:url value='/commercial_board/delete'><c:param name='deleteId' value= '${commercial.getCBoardId()}'/> </c:url>" onclick="return confirm('삭제하시겠습니까?')">삭제</a>
					</div>
					</div>
				</div>
			</div>
	</c:forEach>

	<!--COMMERCIAL_BOARD:REGISTER DIALOG-->
	<div class="modal" id="registerModal" tabindex="-1" role="dialog" aria-labelledby="madal" aria-hidden	="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="modal">상권 등록</h5>
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">
					<form action="<c:url value='/commercial_board/register' />" method="post">
						<div class="form-row">
							<div class="form-group col-sm-6">
								<label>상권명</label>
								<input type="text" name="commercialName" class="form-control" maxlength="20">
							</div>
							<div class="form-group col-sm-6">
								<label>상권 종류</label>
								<select name="commercialCategory" class="form-control">
									<option value="restaurant">음식점</option>
									<option value="cafe">카페</option>
									<option value="etc" selected>기타</option>	
								</select>
							</div>
						</div>

						<div class="form-group">
							<label>내용</label>
							<textarea name="content" class="form-control" maxlength="2048" style="height: 180px;"></textarea>
						</div>
						<div class="form-row">
						<div class="form-group col-md-4">
								<label>WIFI</label>
								<select name="hasWifi" class="form-control">
									<option value="n">없음</option>
									<option value="y">있음</option>
								</select>
							</div>
							<div class="form-group col-md-4">
								<label>1/2인 테이블</label>
								<select name="hasSingleTable" class="form-control">
									<option value="n" selected>없음</option>
									<option value="y">있음</option>
								</select>
							</div>
							<div class="form-group col-md-4">
								<label>콘센트</label>
								<select name="hasSocket" class="form-control">
									<option value="n" selected>없음</option>
									<option value="y">있음</option>
								</select>
							</div>
						</div>
						<div class="form-row">
						<div class="form-group col-sm-6">
								<label>혼잡도</label>
								<select name="congestion" class="form-control">
									<option value="A" selected>여유</option>
									<option value="B">보통</option>
									<option value="C">혼잡</option>
								</select>
							</div>
							<div class="form-group col-md-4">
								<label>가격대</label>
								<select name="price" class="form-control">
									<option value="z" selected>1만원 미만</option>
									<option value="o">1 - 2만원</option>
									<option value="t">2 - 3만원</option>
								</select>
							</div>
							<div class="form-group col-sm-6">
								<label>평점</label>
								<select name="grade" class="form-control">
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

    <hr>

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