<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>评论</title>
</head>
<body>
	<form action="/shiyan9/ServletSentiveWord">
		<table border="1" align="center">
			<tr>
				<th>标题：</th>
				<td><input type="text" name="title"></td>
			</tr>
			
			<tr>
				<th>内容：</th>
				<td><textarea rows="10" cols="30" name="commit">我是一个文本框。</textarea></td>
			</tr>
			
			<tr>
				<td colspan="2" align="center"><input type="submit" value="提交"> <input type="reset" value="重置"></td>
			</tr>
		
		</table>
		
	</form>
</body>
</html>