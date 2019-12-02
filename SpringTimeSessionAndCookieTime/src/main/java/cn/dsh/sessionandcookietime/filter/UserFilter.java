package cn.dsh.sessionandcookietime.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(filterName = "userFilter", urlPatterns = "/mainpage.html")
public class UserFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest hrequest = (HttpServletRequest) request;
        HttpServletResponse hresponse = (HttpServletResponse) response;

        String onLineUser = (String) hrequest.getSession().getAttribute("onLineUser");
        if (null == onLineUser) {
            hresponse.sendRedirect(hrequest.getContextPath() + "/filterUser");
            return;
        } else {
            chain.doFilter(hrequest, hresponse);
        }

    }

    @Override
    public void destroy() {

    }
}
