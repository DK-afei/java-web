package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Shoppingcart;

/**
 * Servlet implementation class ServletShopping
 */
@WebServlet("/ServletShopping")
public class ServletShopping extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Shoppingcart shoppingcart=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletShopping() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		doGet(request, response);
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.println("<br>");
		HttpSession session = request.getSession();
		if(this.shoppingcart==null)
		{
			this.shoppingcart = new Shoppingcart();
			session.setAttribute("shoppingcat", this.shoppingcart);
		}
		String[] books = request.getParameterValues("books");
		out.println("your books are:");
	    for (String book : books)
	    {
//	    	out.print(book+" ");
	    	this.shoppingcart.addItem(book);
	    }
	    out.println("<br>");
	    List<String> l = new ArrayList<String>();
	    for(String k:this.shoppingcart.getItems().keySet())
	    {
	    	out.print(k+":"+this.shoppingcart.getItems().get(k)); 
	    	l.add(k+":"+this.shoppingcart.getItems().get(k));
	    	out.println("<br>");
	    }
	    out.println("<br>");
	    out.print("总数："+this.shoppingcart.get());
	    out.println("<br>");
	    out.print("<a href='shopping.jsp'>继续购物</a>");
	    System.out.println("JSESSIONID");
	    System.out.println(session.getId());
	    System.out.println(l.toString());
	    
	}

}
