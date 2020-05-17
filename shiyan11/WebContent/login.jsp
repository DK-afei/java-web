<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
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
	background: url(img/1.jpg) no-repeat center 0px;
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
	//重新获得验证码
	function refresh() {
		var img = document.getElementById("img_code");
		img.src = "validationCode?random" + Math.random();//加随机参数，以保证每次的src属性都不同
	}
</script>
</head>
<body>
	<form action="check" method="post">
		<div class="container">
			<div class="form row">
				<div class="form-horizontal col-md-offset-3" id="login_form">
					<h3 class="form-title">登陆</h3>
					<div class="col-md-9">
						<div class="form-group">
							<i class="fa fa-user fa-lg"></i> <label>用户名：</label><input
								class="form-control required" type="text" placeholder="Username"
								id="username" name="username" autofocus="autofocus"
								value="${cookie.username.value}" maxlength="20" />
						</div>
						<div class="form-group">
							<i class="fa fa-lock fa-lg"></i> <label>密码：</label><input
								class="form-control required" type="password"
								placeholder="Password" id="password" name="password"
								value="${cookie.password.value}" maxlength="8" />
						</div>
						<div class="form-group">
							<label class="checkbox"> <input type="checkbox" checked
								name="remember" />记住账号密码<a class="pull-right" href="updatePwd.jsp">修改密码</a>
							</label>
						</div>
						<div align="left">
							<div class="form-group">
								<i class="fa fa-user fa-lg"></i> <label>验证码：</label> <img
									title="单击刷新" alt="验证码" src="validationCode" id="img_code"
									onclick="refresh()"><br> <br> <input
									class="form-control required" type="text"
									placeholder="点击图片可进行刷新" id="validation_code"
									name="validation_code" autofocus="autofocus" maxlength="20" />
							</div>
						</div>
						<div class="form-group col-md-offset-9">
							<button type="submit" class="btn btn-success pull-left"
								name="submit">登录</button>
							<input type="button"  class="btn btn-primary pull-right" value="注册" onclick="window.location=('register.jsp')" />
						</div>
						<div>
							<c:choose>
								<c:when test="${empty param.msg}">
								</c:when>
								<c:otherwise>
									<div class="alert alert-danger" role="alert" align="center">
										<p>${param.msg}</p>
									</div>
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