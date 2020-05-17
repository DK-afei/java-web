package servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDAO;

/**
 * Servlet implementation class CheckName
 */
@WebServlet("/CheckName")
public class CheckName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckName() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String edit_username = request.getParameter("edit_username");
		if(username!=null)
		{
			try {
				if(new UserDAO().queryById(username)!=null)
				{
					response.getWriter().append("���˺��Ѵ����޷�ע�ᣡ");
				}
				else
				{
					response.getWriter().append("���˺ſ���ע�ᣡ");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(edit_username!=null)
		{
			try {
				if(new UserDAO().queryById(edit_username)!=null)
				{
					response.getWriter().append("���ڴ��û��������޸ģ�");
				}
				else
				{
					response.getWriter().append("�����ڴ��û��������޸ģ�");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
