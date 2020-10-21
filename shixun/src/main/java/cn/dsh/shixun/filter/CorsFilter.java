package cn.dsh.shixun.filter;

import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 解决跨域问题
 *
 * @author dsh
 * @date 2020/3/25
 */
@WebFilter(filterName = "CorsFilter")
@Configuration
public class CorsFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;
        String originHeader = request.getHeader("Origin");
        response.setHeader("Access-Control-Allow-Origin", originHeader);
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST,GET,PATCH,OPTIONS,DELETE,PUT");
        response.setHeader("Access-Control-Max-Age", "36000");
        response.setHeader("Access-Control-Allow-Headers", "If-Modified-Since,x-forwarded-for,Proxy-Client-IP,WL-Proxy-Client-IP,HTTP_CLIENT_IP,HTTP_X_FORWARDED_FOR,Origin,Content-Type,Accept,user-agent,x-requested-with,cache-control,token,responseType");
        response.setHeader("Access-Control-Expose-Headers", "filename,Content-Disposition,content-length,last-modified,content-type,cache-control");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
