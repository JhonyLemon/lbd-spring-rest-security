package pl.fissst.lbd.restsecurity.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TimestampFilter implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(TimestampFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long befor=System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        long after=System.currentTimeMillis();
        LOG.info("getCalculatedValues time: "+ (after-befor)+" ms");
    }


    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
