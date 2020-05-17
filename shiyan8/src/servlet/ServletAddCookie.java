package servlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletAddCookie extends HttpServlet {

	int number = 0;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		
		//获取所有Cookie
		Cookie[] cookies = request.getCookies();
		if (cookies != null){
			for (int i = 0; i < cookies.length; i++) {
				String cookiename = cookies[i].getName();
				String cookievalue = cookies[i].getValue();
				int cookieage = cookies[i].getMaxAge();
				writer.println(cookiename);
				writer.println(cookievalue);
				writer.println(cookieage);
			}
			}else{
				System.out.println("No cookies!");			
			}
		Cookie newcookie = new Cookie("name"+number,"value"+number);
		//MaxAge的值为0则删除该Cookie
		//newcookie.setMaxAge(0);
		response.addCookie(newcookie);
		number++;
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
