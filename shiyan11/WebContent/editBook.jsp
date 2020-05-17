<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>editBook</title>
<script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<!-- <script src="./bootstrap/js/jquery/2.0.0/jquery.min.js"></script>
<link href="./bootstrap/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="./bootstrap/js/bootstrap/3.3.6/bootstrap.min.js"></script> -->
</head>
<body>
	<div class="page-header" align="center">
	  <h1>修改书籍相关信息</h1>
	</div>
	<form action="editBook?no=${param.no}" method="post">
	       书名 ： <input type="text"  class="form-control" name="name"> <br>
		价格 ： <input type="text"  class="form-control" name="price"> <br>
		数量： <input type="text"  class="form-control" name="num"> <br>
         <input type="submit"  class="form-control" value="确定 ">
	</form>
</body>
</html>