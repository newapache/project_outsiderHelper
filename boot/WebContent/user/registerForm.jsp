<%@page contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>


<head>
<meta charset="utf-8">
<meta name="viewport"
   content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="">
<meta name="author" content="">


<!-- Bootstrap core CSS -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

<!-- Custom fonts for this template -->
<link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet"
   type="text/css">
<link
   href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic'
   rel='stylesheet' type='text/css'>
<link
   href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
   rel='stylesheet' type='text/css'>

<!-- Custom styles for this template -->
<link href="css/clean-blog.min.css" rel="stylesheet">

<link
   href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css"
   rel="stylesheet" id="bootstrap-css">
<script
   src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!------ Include the above in your HEAD tag ---------->
   
   
   

<script>
function userCreate() {
   if (form.userId.value == "") {
      alert("사용자 ID를 입력하십시오.");
      form.userId.focus();
      return false;
   } 
   if (form.password.value == "") {
      alert("비밀번호를 입력하십시오.");
      form.password.focus();
      return false;
   }
   if (form.password.value != form.password2.value) {
      alert("비밀번호가 일치하지 않습니다.");
      form.name.focus();
      return false;
   }
   if (form.name.value == "") {
      alert("이름을 입력하십시오.");
      form.name.focus();
      return false;
   }
   var emailExp = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
   if(emailExp.test(form.email.value)==false) {
      alert("이메일 형식이 올바르지 않습니다.");
      form.email.focus();
      return false;
   }
   var phoneExp = /^\d{2,3}-\d{3,4}-\d{4}$/;
   if(phoneExp.test(form.phone.value)==false) {
      alert("전화번호 형식이 올바르지 않습니다.");
      form.phone.focus();
      return false;
   }
   form.submit();
}

function userList(targetUri) {
   form.action = targetUri;
   form.submit();
}
</script>



<style>
body#LoginForm {
   background: #e5dac3;
   background-repeat: no-repeat;
   background-position: center;
}

.form-heading {
   color: #fff;
   font-size: 23px;
}

.panel h2 {
   color: #444444;
   font-size: 18px;
   margin: 0 0 8px 0;
}

.panel p {
   color: #777777;
   font-size: 14px;
   margin-bottom: 30px;
   line-height: 24px;
}

.login-form .form-control {
   background: #f7f7f7 none repeat scroll 0 0;
   border: 1px solid #d4d4d4;
   border-radius: 4px;
   font-size: 14px;
   height: 50px;
   line-height: 50px;
}

.main-div {
   background: #ffffff none repeat scroll 0 0;
   border-radius: 2px;
   margin: 10px auto 30px;
   max-width: 52%;
   padding: 50px 70px 70px 71px;
}

.login-form .form-group {
   margin-bottom: 10px;
}

.login-form {
   text-align: center;
}

.forgot a {
   color: #777777;
   font-size: 14px;
   text-decoration: underline;
}

.login-form  .btn.btn-primary {
   background: #f0ad4e none repeat scroll 0 0;
   border-color: #f0ad4e;
   color: #ffffff;
   font-size: 14px;
   width: 100%;
   height: 50px;
   line-height: 50px;
   padding: 0;
}

.forgot {
   text-align: left;
   margin-bottom: 30px;
}

.botto-text {
   color: #ffffff;
   font-size: 14px;
   margin: auto;
}

.login-form .btn.btn-primary.reset {
   background: #ff9900 none repeat scroll 0 0;
}

.back {
   text-align: left;
   margin-top: 10px;
}

.back a {
   color: #444444;
   font-size: 13px;
   text-decoration: none;
}
</style>


</head>



<body id="LoginForm"><br><br><br>
	<div class="container"><br><br><br><br>
		<div class="login-form">
			<div class="main-div">
				<div class="panel"><h2>Sign up</h2></div>
            
            <!-- registration form  -->
            <form class="form-horizontal" name="form" method="POST" action="<c:url value='/user/register' />">
            	<c:if test="${registerFailed}">
                  <font color="red"><c:out value="${exception.getMessage()}" /></font>
                </c:if>
                
                <div class="form-group">
                  <label class="control-label col-sm-3">아이디 <span class="text-danger">*</span></label>
                  <div class="col-md-8 col-sm-9">
                  <input type="text" class="form-control" name="userId"
                        id="mem_name" placeholder="아이디 ">
                  </div>
                </div>
                
                <div class="form-group">
                	<label class="control-label col-sm-3">Set Password <span class="text-danger">*</span></label>
						<div class="col-md-5 col-sm-8">
							<div class="input-group">
								<span class="input-group-addon"><i class="glyphicon glyphicon-lock"></i></span>
								<input type="password"
									class="form-control" name="password" id="password"
									placeholder="비밀번호 " value="">
							</div>
						</div>
				</div>
				
				<div class="form-group">
						<label class="control-label col-sm-3">Confirm Password <span
							class="text-danger">*</span></label>
						<div class="col-md-5 col-sm-8">
							<div class="input-group">
								<span class="input-group-addon"><i
									class="glyphicon glyphicon-lock"></i></span> <input type="password"
									class="form-control" name="cpassword" id="password2"
									placeholder="비밀번호 확인 " value="">
							</div>
						</div>
				</div>
				
				<div class="form-group">
	                  <label class="control-label col-sm-3">이름 <span
	                     class="text-danger">*</span></label>
	                  <div class="col-md-8 col-sm-9">
	                  
	                     <input type="text" class="form-control" name="name"
	                        id="mem_name" placeholder="이름 " <c:if test="${registerFailed}">value="${user.name}"</c:if>>
	                        
	                  </div>
                </div>
                
                <div class="form-group">
	                  <label class="control-label col-sm-3">Email ID <span
	                     class="text-danger">*</span></label>
	                  <div class="col-md-8 col-sm-9">
	                     <div class="input-group">
	                        <span class="input-group-addon"><i
	                           class="glyphicon glyphicon-envelope"></i></span> 
	                           
	                           <input type="text" 
	                           class="form-control" name="email" id="emailid"
	                           placeholder="학교 이메일 주소를 입력하세요 " value=""  <c:if test="${registerFailed}">value="${user.email}"</c:if>>
	               
	                     </div>
	                     <small> Your Email Id is being used for ensuring the
	                        security of your account, authorization and access recovery. </small>
	                  </div>
                </div>
                
                <div class="form-group">
	                  <label class="control-label col-sm-3">전화번호<span
	                     class="text-danger">*</span></label>
	                  <div class="col-md-8 col-sm-9">
	                  
	                     <input type="text" class="form-control" name="phone"
	                        id="mem_name" placeholder="전화번호"   <c:if test="${registerFailed}">value="${user.phone}"</c:if>>
	                        
	                  </div>
           	   </div>
               

               <div class="form-group">
						<div class="col-xs-offset-3 col-md-8 col-sm-9">
							<span class="text-muted"><span class="label label-danger">Note:-</span>
								By clicking Sign Up, you agree to our <a href="#">Terms</a> and
								that you have read our <a href="#">Policy</a>, including our <a
								href="#">Cookie Use</a>.</span>
						</div>
			  </div>
			  
			  <div class="form-group">
						<div class="col-xs-offset-3 col-xs-10">
							<input  type="button" 
								class="btn btn-primary" value="회원 가입"
                        onClick="userCreate()">								
								 
						</div>
			  </div><br> 
			  
			  <!-- 회원가입이 실패한 경우 exception 객체에 저장된 오류 메시지를 출력 --> <c:if
                  test="${registerFailed}">
                  <font color="red"><c:out value="${exception.getMessage()}" /></font>
               </c:if> <br>
               
               </form>
               
               </div> <p class="botto-text">Designed by Sunil Rajput</p>
      </div>
   </div>


</body>
</html>

