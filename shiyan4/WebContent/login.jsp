<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆</title>
</head>
<body>
	<form action="checklogin.jsp" method="post">
		账号：<input type="text" name="name"> <br/>
		密码：<input type="password" name="password" > <br/>
		<input type="submit" value="登陆">
		<input type="reset" name="button" id="button" value="重置">
	</form>
</body>
</html>