<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>buyBook</title>
<script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<!-- <script src="./bootstrap/js/jquery/2.0.0/jquery.min.js"></script>
<link href="./bootstrap/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="./bootstrap/js/bootstrap/3.3.6/bootstrap.min.js"></script> -->
</head>
<body>
	<div class="page-header" align="center">
	  <h1>购买书籍</h1>
	</div>
	<h4>您好！您想购买的书是： ${param.name}</h4>
	<h4>图书的单价是： ${param.price}</h4>
	<form action="/shiyan11/shopping?no=${param.no}&name= ${param.name}&price=${param.price}" method="post">
		<h4>购买的数量：<input type="text" class="form-control" name="buynum"> 
					   <input type="submit" class="form-control" value="购买 ">
		</h4>
	</form>
</body>
</html>