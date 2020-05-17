import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CounterServlet extends HttpServlet {
	  private Counter ct = new Counter(1);
	  public void doGet(HttpServletRequest request, HttpServletResponse response){
          
	        ServletContext application = this.getServletContext();
	        String counter = application.getInitParameter("counter");
	        if("0".equals(counter))
	        	ct = new Counter(ct.getCounter());
	        application.setAttribute("counter", ct.getCounter());
	        System.out.println("ÄúÊÇµÚ:"+ ct.getCounter()+"Î»");
	        ct.add();
	    }
}
