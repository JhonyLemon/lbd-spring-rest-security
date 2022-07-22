package pl.fissst.lbd.restsecurity.filters;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SetDecimalFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        doFilter((HttpServletRequest) servletRequest,(HttpServletResponse) servletResponse,filterChain);
    }
    private void doFilter(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws IOException, ServletException {
        if(httpServletRequest.getMethod().equals("PUT")) {
            String decimalPlaces = httpServletRequest.getHeader("decimalPlaces");
            if (decimalPlaces == null || decimalPlaces.isEmpty() || !(decimalPlaces.equals("1") || decimalPlaces.equals("2") || decimalPlaces.equals("3") || decimalPlaces.equals("4"))) {
                httpServletResponse.resetBuffer();
                httpServletResponse.getOutputStream().print("Color is incorrect");
                httpServletResponse.setStatus(400);
                httpServletResponse.flushBuffer();
                return;
            }
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }


    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
