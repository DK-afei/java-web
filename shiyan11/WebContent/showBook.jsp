<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="dao.BookDAO,java.util.List,bean.Book"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>showBook</title>
<script src="https://how2j.cn/study/js/jquery/2.0.0/jquery.min.js"></script>
<link
	href="https://how2j.cn/study/css/bootstrap/3.3.6/bootstrap.min.css"
	rel="stylesheet">
<script src="https://how2j.cn/study/js/bootstrap/3.3.6/bootstrap.min.js"></script>
<!-- <script src="./bootstrap/js/jquery/2.0.0/jquery.min.js"></script>
<link href="./bootstrap/css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="./bootstrap/js/bootstrap/3.3.6/bootstrap.min.js"></script> -->
</head>
<body>
	<div class="page-header" align="center">
		<h1>书籍列表信息</h1>
	</div>
	<c:set var="arrayvalue" value="	本书结合最新的Tomcat 9版本，详细介绍了开发Java Web应用的各种技术。主要内容包括：Tomcat和Java Web开发的基础知识，Java Web开发的高级技术，在Java Web应用中运用第三方提供的实用软件（如Spring、Velocity和Log4J）的方法，以及Tomcat的各种高级功能。 书中内容注重理论与实践相结合，列举了大量具有典型性和实用价值的Web应用实例，并提供了详细的开发和部署步骤。由于Java Web技术是Oracle公司在Java Servlet规范中提出的通用技术，因此本书讲解的Java Web应用例子可以运行在任何一个实现Oracle的Servlet规范的Java Web服务器上。随书附赠光盘内容为本书所有范例源程序，视频教程，以及本书涉及的部分软件的最新版本的安装程序。 本书语言深入浅出，通俗易懂。无论对于Java Web开发的新手还是行家来说，本书都是精通Tomcat和开发Java Web应用的必备的实用手册。本书还可作为高校的学习Java Web开发的教材，以及企业Java Web培训教材。#
							              本书是软件工程领域的经典教材。全书由5 篇(16 章) 构成，第 1 篇( 第 1、2 章) 讲述软件工程与软件过程；第 2 篇讲述传统方法学( 第3 ～ 5 章)，包括结构化分析、设计与实现；第3 篇讲述面向对象方法学( 第6 ～ 10 章)，包括面向对象的概念、模型、分析、设计、实现，同时介绍了统一建模语言UML； 第4 篇讲述软件项目管理( 第 11 ～ 14 章)，包括软件项目的计划、组织和控制， 软件维护与软件文档；第5 篇讲述软件工程的课题( 第 15、16 章)，包括形式化方法和软件重用。#
							 		本书全面、深入地探讨了编译器设计方面的重要主题，包括词法分析、语法分析、语法制导定义和语法制导翻译、运行时刻环境、目标代码生成、代码优化技术、并行性检测以及过程间分析技术，并在相关章节中给出大量的实例。与上一版相比，本书进行了全面修订，涵盖了编译器开发方面最新进展。每章中都提供了大量的实例及参考文献。
									本书是编译原理课程方面的经典教材，内容丰富，适合作为高等院校计算机及相关专业本科生及研究生的编译原理课程的教材，也是广大技术人员的极佳参考读物。
								    " />
	<c:set var="delim" value="#" />
	<c:set var="array" value="${fn:split(arrayvalue, delim)}" />
	<%-- <table border="1" align="center">
		<tr>
			<td>A</td>
			<td>B</td>
		</tr>
		<c:forEach var="i" begin="0" end="2">
			<tr>
				<td><c:out value="${i}" /></td>
				<td><c:out value="${array[i]}" />
			</tr>
		</c:forEach>
	</table> --%>
	<table class="table table-bordered table-hover table-condensed"
		align='center' border='1' cellspacing='0'>
		<tr class="warning">
			<td>编号</td>
			<td>书名</td>
			<td>价格</td>
			<td>数量</td>
			<td>编辑</td>
			<td>购买</td>
			<td>删除</td>
		</tr>
		<c:forEach items="${sessionScope.books}" var="book" varStatus="st">
			<c:set var="i" value="${st.count-1}" />
			<tr class="success">
				<td>${book.no}</td>
				<td align="center">
					<div class="panel panel-info">
						<div class="panel-heading" role="tab" id="heading_${book.no}">

							<h4 class="panel-title">
								<a class="collapsed" role="button" data-toggle="collapse"
									data-parent="#accordion" href="#collapse_${book.no}"
									aria-expanded="false" aria-controls="collapse_${book.no}">
									${book.name} </a>

							</h4>

						</div>
						<div id="collapse_${book.no}" class="panel-collapse collapse"
							role="tabpanel" aria-labelledby="heading_${book.no}">
							<div class="panel-body">
								<img alt=""
									title="${array[i]}"
									src="./img/${book.no}.jpg">
							</div>
						</div>
					</div>
				</td>
				<td>${book.price}</td>
				<td>${book.num}</td>
				<td><a href="editBook.jsp?no=${book.no}">edit</a></td>
				<td><a
					href="buyBook.jsp?no=${book.no}&name=${book.name}&price=${book.price}&num=${book.num}">buy</a></td>
				<td><a href="deleteBook?no=${book.no}">delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<div align="center">
		<a href="/shiyan11/addBook.jsp">add</a><br> <br> <a
			href="index.jsp">返回首页</a>
	</div>
</body>
</html>