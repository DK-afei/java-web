import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContextServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		super.doGet(req, resp);
		req.setCharacterEncoding("UTF-8"); 
		String type = "text/html;charset=UTF-8";
		resp.setContentType(type);
		ServletContext application = this.getServletContext();
		Enumeration<String> params = application.getInitParameterNames();
		PrintWriter out = resp.getWriter();
		while(params.hasMoreElements())
		{
			String pname = (String) params.nextElement();
			String pvalue = application.getInitParameter(pname);
			out.println(pname+":"+pvalue+"<br>");
		}
	}
	
}
