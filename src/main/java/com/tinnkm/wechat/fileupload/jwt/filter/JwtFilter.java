package com.tinnkm.wechat.fileupload.jwt.filter;

import com.tinnkm.wechat.fileupload.jwt.config.Audience;
import com.tinnkm.wechat.fileupload.jwt.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author tinnkm
 * @version 1.0
 * @classname JwtFilter
 * @description jwt过滤器
 * @date 2018/11/4 9:54
 **/
@Component
public class JwtFilter extends GenericFilterBean {
    private final Audience audience;

    @Autowired
    public JwtFilter(Audience audience) {
        this.audience = audience;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        final HttpServletRequest request = (HttpServletRequest) servletRequest;
        final HttpServletResponse response = (HttpServletResponse) servletResponse;
        final String auth = request.getHeader("authorization");

        if (request.getRequestURI().equals("/api/user/save") || request.getRequestURI().contains("/api/file/image")){
            filterChain.doFilter(request,response);
            return;
        }
        if ("OPTIONS".equals(request.getMethod())){
            response.setStatus(HttpServletResponse.SC_OK);
            filterChain.doFilter(request,response);
            return;
        }

        if (StringUtils.isEmpty(auth) || !auth.startsWith("Bearer;")){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("unauthorized");
            return;
        }
        final String token = auth.substring(7);

        Claims claims = JwtUtils.parse(token, audience.getSecret());
        if (null == claims){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("unauthorized");
            return;
        }
        request.setAttribute("claims",claims);
        filterChain.doFilter(request,response);
    }
}
