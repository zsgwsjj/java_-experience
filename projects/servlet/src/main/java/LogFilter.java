import javax.servlet.*;
import java.io.IOException;

/**
 * @author : jiang
 * @time : 2018/3/30 17:38
 */
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String site = filterConfig.getInitParameter("Site");
        System.out.println("网站名称：" + site);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("站点网址：baidu.com");
        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
