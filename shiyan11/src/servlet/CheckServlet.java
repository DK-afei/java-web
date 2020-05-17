package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Book;
import bean.User;
import dao.BookDAO;
import dao.UserDAO;

/**
 * Servlet implementation class CheckServlet
 */
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private User user = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String validationCode = request.getParameter("validation_code");
		String remember = request.getParameter("remember");
		try {
			this.user = new UserDAO().queryById(username);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(!this.checkValidationCode(request, validationCode))
		{
			String msg = (String)request.getAttribute("info")+"请重新输入！";
			response.sendRedirect("login.jsp?msg="+ URLEncoder.encode(msg,"utf-8"));
		}
		else if(this.user.getUsername().equals(username)&&this.user.getUserpwd().equals(password))
		{
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			List<Book> books = new BookDAO().list();
			session.setAttribute("books", books);
			if(remember!=null)
			{
				Cookie c1 = new Cookie("username", username);
				Cookie c2 = new Cookie("password", password);
				c1.setMaxAge(60*60*24*30);
				c2.setMaxAge(60*60*24*30);
				response.addCookie(c1);
				response.addCookie(c2);
			}
			else
			{
				  Cookie cookies[] = request.getCookies(); 
	              for (Cookie cookie : cookies) {
	                  if(cookie.getName().equals("userame")) {
	                      cookie.setMaxAge(0);
	                  }
	                  if(cookie.getName().equals("password")) {
	                      cookie.setMaxAge(0);
	                  }
	              }
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
	        dispatcher.forward(request, response);
		}
		else
		{
			String msg = "密码错误，请重新输入！";
			response.sendRedirect("login.jsp?msg="+ URLEncoder.encode(msg,"utf-8"));
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
