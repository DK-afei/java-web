<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登陆</title>
</head>
<body>
	<form action="insert3.jsp" method="post">
		输入编号：<input type="text" name="eid"><br>
		输入姓名：<input type="text" name="ename"><br>
		选择部门：
		<select name="dept">
			<option value="1">1</option>
			<option value="2">2</option>
			<option value="3">3</option>
			<option value="4">4</option>
			<option value="5">5</option>
			<option value="6">6</option>
			<option value="7">7</option>
		</select><br>
		<input type="submit" value="提交">
	</form>
</body>
</html>