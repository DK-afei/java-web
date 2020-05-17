

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WebServiceTest
 */
@WebServlet(name = "ServletTest",urlPatterns="/WebServiceTest",initParams= {@WebInitParam(name="p1",value="第一个参数"),
										   									@WebInitParam(name="p2",value="第二个参数")})
public class WebServiceTest extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WebServiceTest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext application = this.getServletContext();
		String version = application.getMajorVersion()+"";
		String type = "text/html;charset=utf-8";
		response.setContentType(type);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().append("<br>");
		response.getWriter().append("servlet version:"+version);
		response.getWriter().append("<br>");
		response.getWriter().append(this.getInitParameter("p1"));
		response.getWriter().append("<br>");
		response.getWriter().append(this.getInitParameter("p2"));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
