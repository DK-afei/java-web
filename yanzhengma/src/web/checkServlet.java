package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class checkServlet
 */
public class checkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String validationCode = request.getParameter("validation_code");
		if(this.checkValidationCode(request, validationCode))
		{
			out.print("success!");
		}
		else 
		{
			out.print("fail!");
			out.print("<br>");
			out.print(request.getAttribute("info"));
		}
	}
	
	private boolean checkValidationCode(HttpServletRequest request,String validationCode) {
		// ��HttpSession�л��ϵͳ������ɵ���֤��
		String validationCodeSession = (String) request.getSession().getAttribute("validation_code");
		// �����õ���֤��Ϊnull��˵��������ڣ�����ˢ�¿ͻ������»�ȡ
		if (validationCodeSession == null) {
			request.setAttribute("info", "��֤�����");
			return false;
		}
		// �������֤�벻ƥ��
		if (!validationCode.equalsIgnoreCase(validationCodeSession)) {
			request.setAttribute("info", "��֤�벻��ȷ��");
			return false;
		}
		return true;
	}
}
