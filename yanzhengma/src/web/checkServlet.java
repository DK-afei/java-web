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
		// 从HttpSession中获得系统随机生成的验证码
		String validationCodeSession = (String) request.getSession().getAttribute("validation_code");
		// 如果获得的验证码为null，说明难码过期，必须刷新客户端重新获取
		if (validationCodeSession == null) {
			request.setAttribute("info", "验证码过期");
			return false;
		}
		// 输入的验证码不匹配
		if (!validationCode.equalsIgnoreCase(validationCodeSession)) {
			request.setAttribute("info", "验证码不正确！");
			return false;
		}
		return true;
	}
}
