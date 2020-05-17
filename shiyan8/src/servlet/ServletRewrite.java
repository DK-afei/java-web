package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ServletRewrite extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		//对URL进行重新编码 
		//超链接或form
		String url = response.encodeURL("rewrite01");
		//重定向
		//response.encodeRedirectURL(arg0)
		
		
		out.println("已创建一个Session，ID："+session.getId());
		
		//out.println("<a href=/CourseEx/ServletRewrite01>直接跳转</a>");
		out.println("<a href=/shiyan8/"+url+">跳转</a>");
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
