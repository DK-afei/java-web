package response;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletRefresh extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//姣忎竴绉掑埛鏂颁竴娆�,鑷姩璺宠浆
		response.setHeader("Refresh", "3;url=http://www.baidu.com");

		PrintWriter writer = response.getWriter();
		writer.println(new java.util.Date());

	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
