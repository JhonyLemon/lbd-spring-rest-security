package pl.fissst.lbd.restsecurity.filters;


import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthorizationStudentFilter implements Filter {

    private static final String newContent = "{ \"errorMessage\" : \"User unauthorized!\" }";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        doFilter((HttpServletRequest) servletRequest,(HttpServletResponse) servletResponse,filterChain);
    }
    private void doFilter(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws IOException, ServletException {
            String role=httpServletRequest.getHeader("role");
            if(role==null || !(role.equals("STUDENT_ROLE") || role.equals("TEACHER_ROLE"))){
                httpServletResponse.resetBuffer();
                httpServletResponse.setStatus(401);
                httpServletResponse.getOutputStream().print(newContent);
                httpServletResponse.getOutputStream().flush();
                httpServletResponse.flushBuffer();
                return;
            }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
