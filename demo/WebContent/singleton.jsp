<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="bean.PersonInfo" %>
<%
    request.setCharacterEncoding("utf-8");
    response.setCharacterEncoding("utf-8");
    String action = request.getParameter("action");
    String account = request.getParameter("account");

    if("login".equals(action) && account.trim().length() > 0){
        PersonInfo personInfo = new PersonInfo();
        personInfo.setAccount(account);
        personInfo.setIp(request.getRemoteAddr());
        personInfo.setLoginDate(new java.util.Date());

        session.setAttribute("personInfo", personInfo);
        response.sendRedirect(response.encodeRedirectURL(request.getRequestURI()));

        return ;

    }else if("logout".equals(action)){
        session.removeAttribute("personInfo");
        response.sendRedirect(response.encodeRedirectURL(request.getRequestURI()));

        return ;
    }
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登陆</title>
</head>
<body>
    <c:choose>
        <c:when test="${personInfo != null }">
            欢迎你，${personInfo.account }.<br/>
            你的登录ip为：${personInfo.ip }<br/>
            登录时间为：<fmt:formatDate value="${personInfo.loginDate }" pattern="yyyy-MM-dd HH:MM"/>
            <a href="${pageContext.request.requestURI }?action=logout">退出</a>
        </c:when>
        <c:otherwise>
            ${msg }
            <c:remove var="msg" scope="session"/>
            <form action="${pageContext.request.requestURI }?action=login" method="post">
                账号：<input type="text" name="account">
                <input type="submit" value="提交">
            </form>
        </c:otherwise>

    </c:choose>
</body>
</html>