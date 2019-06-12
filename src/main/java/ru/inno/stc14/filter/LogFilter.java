package ru.inno.stc14.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.Logger;

@WebServlet("/")
public class LogFilter implements Filter {
    private Logger logger = Logger.getLogger(LogFilter.class.getName());

    @Override
    public void init(FilterConfig filterConfig) {
        logger.warning("init logFilter");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String uri = "Requested Uri::" + req.getRequestURI();
        logger.warning(uri);
        String method = "Requested Method::" + req.getMethod();
        logger.warning(method);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        logger.warning("destroy logFilter");
    }
}
