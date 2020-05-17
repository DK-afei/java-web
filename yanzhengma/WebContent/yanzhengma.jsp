<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
 
<!DOCTYPE html>
<html>
  <head>
	<title>登陆</title>
	<script>
		//重新获得验证码
		function refresh(){
			var img = document.getElementById("img_code");
			img.src = "validationCode?" + Math.random();//加随机参数，以保证每次的src属性都不同
		}
	</script>
</head>
 
	<body>
		<form action="check" method="post" align="center">
			用 户 名：
			<input type="text" name="userName">
			<br />
			密 码：
			<input type="password" name="pwd">
			<br />
			验 证 码：
			<input type="text" name="validation_code">
			<img title="单击刷新" alt="验证码" src="validationCode" id="img_code" onclick="refresh()">
			<br />
			<input type="submit" value="登陆">
			<input type="reset" value="重置">
		</form>
	</body>
</html>