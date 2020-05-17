<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>javabean</title>
</head>
<body>
	<jsp:useBean id="hero" class="bean.Hero"></jsp:useBean>
	<jsp:setProperty property="*" name="hero"/>
	<p>填写结果如下</p>
	<jsp:getProperty property="id" name="hero"/><br>
	<jsp:getProperty property="name" name="hero"/><br>
	<jsp:getProperty property="hp" name="hero"/><br>
	<jsp:getProperty property="damage" name="hero"/>
</body>
</html>