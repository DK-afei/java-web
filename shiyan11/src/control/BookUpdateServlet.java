package control;
 
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Book;
import dao.BookDAO;
 
public class BookUpdateServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String no = request.getParameter("no");
        int buynum = Integer.parseInt(request.getParameter("buynum"));
        new BookDAO().update0(no,buynum);
        HttpSession session = request.getSession();
        List<Book> books = new BookDAO().list();
		session.setAttribute("books", books);
        response.sendRedirect("showBook.jsp");
    }
}