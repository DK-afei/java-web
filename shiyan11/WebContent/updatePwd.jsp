<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>updatePwd</title>
<script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link
	href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css"
	rel="stylesheet">
<script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<!-- <script src="./bootstrap/js/jquery/2.0.0/jquery.min.js"></script>
<link href="./bootstrap/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="./bootstrap/js/bootstrap/3.3.6/bootstrap.min.js"></script> -->
<style>
body {
	margin: 0;
	padding: 0;
	font-family: sans-serif;
	background: url(img/3.jpg) no-repeat center 0px;
	background-size: cover;
	background-position: center 0;
	background-repeat: no-repeat;
	background-attachment: fixed;
	-webkit-background-size: cover;
	-o-background-size: cover;
	-moz-background-size: cover;
	-ms-background-size: cover;
}

.form {
	background: rgba(255, 255, 255, 0.3);
	width: 400px;
	margin: 120px auto;
}

.fa {
	display: inline-block;
	top: 27px;
	left: 6px;
	position: relative;
	color: #ccc;
}

input[type="text"], input[type="password"] {
	padding-left: 26px;
}

.checkbox {
	padding-left: 21px;
}
</style>
<script>
var xmlhttp;
function check(){
  var edit_username = document.getElementById("edit_username").value;
  var url = "CheckName?edit_username="+edit_username;
 
  xmlhttp =new XMLHttpRequest();
  xmlhttp.onreadystatechange=checkResult; //响应函数
  xmlhttp.open("GET",url,true);   //设置访问的页面
  xmlhttp.send(null);  //执行访问
}
 
function checkResult(){
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    document.getElementById('checkResult').innerHTML=xmlhttp.responseText;
  
}
 
</script>
</head>
<body>
	<form action="/shiyan11/UpdatePwdServlet" method="post">
		<div class="container">
			<div class="form row">
				<div class="form-horizontal col-md-offset-3" id="login_form">
					<h3 class="form-title">修改密码<input type="button"  class="btn btn-primary pull-right" value="返回登录" onclick="window.location=('login.jsp')" /></h3>
					<div class="col-md-9">
						<div class="form-group">
							<i class="fa fa-user fa-lg"></i> <label>用户名：</label><input
								class="form-control required" type="text" placeholder="Username"
								id="edit_username" name="edit_username" autofocus="autofocus"  onkeyup="check()"
								maxlength="20" />
						</div>
						<div class="form-group">
							<i class="fa fa-lock fa-lg"></i> <label>原始密码：</label><input
								class="form-control required" type="password"
								placeholder="Old_Password" id="edit_password_old" name="edit_password_old"
								maxlength="8" />
						</div>
						<div class="form-group">
							<i class="fa fa-lock fa-lg"></i> <label>更新密码：</label><input
								class="form-control required" type="password"
								placeholder="New_Password" id="edit_password_new" name="edit_password_new"
								maxlength="8" />
						</div>
						<div class="form-group col-md-offset-9">
							<button type="submit" class="btn btn-success pull-left"
								name="submit">修改</button>
							<button type="reset" class="btn btn-danger pull-right"
								name="reset">重置</button>
						</div>
						<div class="alert alert-warning" role="alert" align="center">
							<span id="checkResult"></span>
							<c:choose>
								<c:when test="${empty param.msg}">
								</c:when>
								<c:otherwise>
										<p>${param.msg}</p>
								</c:otherwise>
							</c:choose>
						</div>
					</div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>