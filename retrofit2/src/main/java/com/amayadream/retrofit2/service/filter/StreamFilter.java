package com.amayadream.retrofit2.service.filter;

import com.amayadream.retrofit2.util.stream.BufferedServletRequestWrapper;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author : xjding
 * @date :   2017-11-01 10:28
 */
@Component
public class StreamFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (RequestMethod.GET.name().equalsIgnoreCase(request.getMethod())) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            HttpServletRequest httpServletRequest = new BufferedServletRequestWrapper(request);
            filterChain.doFilter(httpServletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}
