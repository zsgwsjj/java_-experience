package spider1.util;


import com.zsgwsjj.jiang.util.enums.EnumUserError;
import com.zsgwsjj.jiang.util.other.YaoException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author : jiang
 * @time : 2018/4/13 14:45
 */
public class AuthFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        if (!userName.equals("jiang") || !password.equals("123456")) {
            throw new YaoException(EnumUserError.PASSWORD_ERROR);
        }
        LOGGER.info("auth pass!!!");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
//
    }
}
