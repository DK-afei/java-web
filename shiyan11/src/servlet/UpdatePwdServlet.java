package servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

/**
 * Servlet implementation class UpdatePwdServlet
 */
@WebServlet("/UpdatePwdServlet")
public class UpdatePwdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePwdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String edit_username = request.getParameter("edit_username");
		String edit_password_old = request.getParameter("edit_password_old");
		String edit_password_new = request.getParameter("edit_password_new");
		
		try {
			if(edit_password_old.equals(new UserDAO().queryById(edit_username).getUserpwd()))
			{
				new UserDAO().update(edit_password_new, edit_username);
				String msg = "�޸ĳɹ��������Է��ؽ��е�½��";
				response.sendRedirect("updatePwd.jsp?msg="+ URLEncoder.encode(msg,"utf-8"));
			}
			else
			{
				String msg = "ԭʼ��������������������룡";
				response.sendRedirect("updatePwd.jsp?msg="+ URLEncoder.encode(msg,"utf-8"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
