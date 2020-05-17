<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>表单</title>
</head>
<body>
	<form action="testbean.jsp" method="post">
		id ：<input type="text" name="id"><br>
	       名字 ： <input type="text" name="name"> <br>
		血量 ： <input type="text" name="hp"> <br>
		伤害： <input type="text" name="damage"> <br>
		         <input type="submit" value="提交 ">
	</form>
</body>
</html>