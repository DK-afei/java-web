<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册</title>
</head>
<body>
	<form action="main.jsp" method="get">
		账号 ： <input type="text" name="name"> <br>
		密码 ：  <input type="password" name="password" > <br/>
		性别 ： <input type="radio" name="sex" value="male">男
			   <input type="radio" name="sex" value="female">女 <br>
		爱好：
		<select name="hobits" multiple>
			<option value="dance">跳舞</option>
			<option value="draw">绘画</option>
			<option value="sing">唱歌</option>
			<option value="chess">下棋</option>
		</select> <br>
			 <input type="submit" value="注册">
	</form>
</body>
</html>