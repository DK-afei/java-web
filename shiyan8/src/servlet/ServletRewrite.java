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
		//��URL�������±��� 
		//�����ӻ�form
		String url = response.encodeURL("rewrite01");
		//�ض���
		//response.encodeRedirectURL(arg0)
		
		
		out.println("�Ѵ���һ��Session��ID��"+session.getId());
		
		//out.println("<a href=/CourseEx/ServletRewrite01>ֱ����ת</a>");
		out.println("<a href=/shiyan8/"+url+">��ת</a>");
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
