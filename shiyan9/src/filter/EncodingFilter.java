package filter;
 
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
 
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebFilter(filterName="EncodingFilter",urlPatterns="/ServletCharacter",
		   initParams= {@WebInitParam(name="encoding",value="utf-8"),
				   		@WebInitParam(name="textType",value="text/html;charset=utf-8")
		   			   })
public class EncodingFilter implements Filter {
	private FilterConfig filterConfig=null;
    @Override
    public void destroy() {
 
    }
 
    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
		req.setCharacterEncoding("UTF-8");
	    res.setContentType("text/html;charset=utf-8");
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        PrintWriter out = response.getWriter();
        System.out.println("encoding:"+this.filterConfig.getInitParameter("encoding"));
        System.out.println("textType:"+this.filterConfig.getInitParameter("textType"));
        out.print("EncodingFilter开始过滤");
        out.print("<br>");
        chain.doFilter(request, response);
        out.print("EncodingFilter执行后的响应");
        out.print("<br>");
    }
 
    @Override
    public void init(FilterConfig config) throws ServletException {
    	this.filterConfig = config;
    }
 
}