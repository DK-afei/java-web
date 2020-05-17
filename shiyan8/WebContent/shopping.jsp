<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>购买图书页面</title>
</head>
<body>
	<h3>请购买您需要的图书</h3>
	<hr>
	<form action="/shiyan8/shopping" method="post">
		<input type="checkbox" name="books" value="c">c<br>
		<input type="checkbox" name="books" value="c++">c++<br>
		<input type="checkbox" name="books" value="c#">c#<br>
		<input type="checkbox" name="books" value="java">java<br>
		<input type="checkbox" name="books" value="web">web<br>
		<input type="checkbox" name="books" value="python">python<br>
		<hr>
			 <input type="submit" value="加入购物车">
	</form>
</body>
</html>