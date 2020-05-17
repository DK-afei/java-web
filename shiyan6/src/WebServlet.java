import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WebServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		req.setCharacterEncoding("UTF-8"); 
		String type = "text/html;charset=UTF-8";
		resp.setContentType(type);
		ServletContext application = this.getServletContext();
		PrintWriter out = resp.getWriter();
		String path = ".";
		out.println("web应用的URL是："+application.getContextPath());
		out.print("<br>");
		out.println("当前位置的物理路径是："+application.getRealPath(path));
		out.print("<br>");
		out.println("Servlet API 主版本是："+application.getMajorVersion());
		out.print("<br>");
		out.println("Servlet容器的名称和版本是："+application.getServerInfo());
		out.print("<br>");
		out.println("当前web应用的名称是："+application.getServletContextName());
		
	}
	
}
