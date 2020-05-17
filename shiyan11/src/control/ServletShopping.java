package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.BookItem;

/**
 * Servlet implementation class ServletShopping
 */
public class ServletShopping extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private List<BookItem> bookitems = null;
	private HttpSession session = null;
	private int zongshu = 0;
	private float heji = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletShopping() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.session = request.getSession();
		if(this.bookitems==null)
		{
			this.bookitems = new ArrayList<BookItem>();
			this.session.setAttribute("bookitems", this.bookitems);
		}
		String no = request.getParameter("no");
		int buynum = Integer.parseInt(request.getParameter("buynum"));
		String shuming = request.getParameter("shuming");
		Iterator<BookItem> it = this.bookitems.iterator();
		if("nothing".equals(no))
		{
			this.bookitems.clear();
			this.zongshu = 0;
			this.heji = 0;
		}
		else if(shuming!=null)
		{
			while(it.hasNext())
			{
				BookItem bookitem = it.next();
				if(bookitem.getShuming().equals(shuming))
				{
					this.zongshu-=bookitem.getShuliang();
					this.heji-=bookitem.getZongjia();
					it.remove();
					
				}
			}
		}
		else
		{
			String name = request.getParameter("name");
			float price =  Float.parseFloat(request.getParameter("price"));
			BookItem bi = new BookItem();
			bi.setShuming(name);
			bi.setDanjia(price);
			bi.setShuliang(buynum);
			bi.setZongjia(price*buynum);
			while(it.hasNext())
			{
				BookItem bookitem = it.next();
				if(bookitem.getShuming().equals(name))
				{
					bi.setShuliang(buynum+bookitem.getShuliang());
					bi.setZongjia(price*buynum+bookitem.getZongjia());
					it.remove();
				}
			}
			this.bookitems.add(bi);
			this.zongshu+=buynum;
			this.heji+=price*buynum;
		}
		this.session.setAttribute("zongshu", this.zongshu);
		this.session.setAttribute("heji", this.heji);
		response.sendRedirect("shopcar.jsp?no="+no+"&buynum="+buynum);
	    
	    
	}

}
