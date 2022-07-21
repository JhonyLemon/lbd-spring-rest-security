package pl.fissst.lbd.restsecurity.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

@Component
@Order(value = 1)
public class TimeLoggerFilter implements Filter {

    private static final Logger LOG = LoggerFactory.getLogger(TimeLoggerFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long befor=System.currentTimeMillis();
        filterChain.doFilter(servletRequest,servletResponse);
        long after=System.currentTimeMillis();
        LOG.info("Request time: "+ (after-befor)+" ms");

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
