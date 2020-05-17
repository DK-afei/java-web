<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>页面跳转</title>
</head>
<body>
	<jsp:forward page="dynamicTable.jsp">
		<jsp:param value="007" name="id"></jsp:param>
	</jsp:forward>
</body>
</html>