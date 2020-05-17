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
 
public class BookEditServlet extends HttpServlet {
 
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Book book = new Book();
        book.setNo(request.getParameter("no"));
        book.setName(request.getParameter("name"));
        book.setPrice(Float.parseFloat(request.getParameter("price")));
        book.setNum(Integer.parseInt(request.getParameter("num")));
        new BookDAO().update(book);
        HttpSession session = request.getSession();
        List<Book> books = new BookDAO().list();
		session.setAttribute("books", books);
        response.sendRedirect("showBook.jsp");
    }
}