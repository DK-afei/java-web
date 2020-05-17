package response;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletRedirect01 extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); 
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		
//		  request.setCharacterEncoding("GBK");
//	        response.setCharacterEncoding("GBK");
//	        response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();

	    //地址栏输入Servlet地址和？参数，读取用户名
	    String username = request.getParameter("username");
	    String message = null;
	    if(username == null){
//	      message="Please input your name";
	      message="请输入你的姓名：";
	    }else{
//	      message="Hello,"+username;
	      message="你好，"+username;
	    }

	   
	    //在request对象中添加msg属性
	    //四大域对象
	    request.setAttribute("msg", message);
	    out.println("Output from CheckServlet01 before redirecting."); 
	    
	    //重定向到ServletRedirectOut
	    String url = "/shiyan7/redirectout?msg=" + URLEncoder.encode(message,"utf-8");
	    response.sendRedirect(url);
//	    response.sendRedirect("/shiyan7/redirectout?msg="+message); 
	    //response.sendRedirect("/output?msg="+message"); 
	   //response.sendRedirect("http://localhost:8080/CourseEx/output?msg="+message); 

	    out.println("Output from CheckServlet01 after redirecting."); 
	  	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
