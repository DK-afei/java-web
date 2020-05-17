package response;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletCache extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8"); 
		//����ʧЧʱ��
        response.setDateHeader("Expires",0);
        //�������
        response.setHeader("Cache-Control","no-cache"); 

		PrintWriter out = response.getWriter();
		out.println("������Ӧ�������Ϊ��" + Math.random());
		out.println("<form action='/CourseEx/ServletOutput'" + "method='POST'>" +
			"��һ��������<input type='text' name='p1'><br>" +
			"�ڶ���������<textarea name='p2'></textarea><br>" +
			"<input type='submit' value='�ύ'> " +
			"</form>");
	}
	//public  private  no-cache  no-store

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
