<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="dao.BookDAO,java.util.List,bean.Book"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>shopcar</title>
<script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<!-- <script src="./bootstrap/js/jquery/2.0.0/jquery.min.js"></script>
<link href="./bootstrap/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="./bootstrap/js/bootstrap/3.3.6/bootstrap.min.js"></script> -->
</head>
<body>
	<div class="page-header" align="center">
	  <h1>购物车</h1>
	</div>
	
	<table class="table table-bordered table-hover table-condensed" align='center' border='1' cellspacing='0'>
		<tr class="warning"><td>书名</td><td>数量</td><td>单价</td><td>总价</td><td>删除</td></tr>
		<c:forEach items="${sessionScope.bookitems}" var="bookitem">
		 <tr class="success">
	        <td>${bookitem.shuming}</td>
	        <td>${bookitem.shuliang}</td>
	        <td>${bookitem.danjia}</td>
	        <td>${bookitem.zongjia}</td>
	        <td><a href="/shiyan11/shopping?shuming=${bookitem.shuming}&buynum=${param.buynum}">delete</a></td>
   		 </tr>
		</c:forEach>
		<tr class="info">
			<td>总数</td>
			<td>${sessionScope.zongshu}</td>
			<td>合计</td>
			<td>${sessionScope.heji}</td>
			<td><a href="/shiyan11/shopping?no=nothing&buynum=0">clear</a></td>
		</tr>
	</table>
	<div align="center">
		<a href="/shiyan11/updateBook?no=${param.no}&buynum=${param.buynum}">继续购物</a><br><br>
		<a href="index.jsp">返回首页</a>
	</div>
</body>
</html>