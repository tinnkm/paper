package com.tinnkm.wechat.fileupload.jwt.config;

import com.tinnkm.wechat.fileupload.jwt.filter.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tinnkm
 * @version 1.0
 * @classname JwtFilterConfig
 * @description filter注册
 * @date 2018/11/4 16:33
 **/
@Configuration
public class JwtFilterConfig {
    @Bean
    public FilterRegistrationBean filter(JwtFilter jwtFilter){
        FilterRegistrationBean<JwtFilter> jwtFilterFilterRegistrationBean = new FilterRegistrationBean<>();
        jwtFilterFilterRegistrationBean.setFilter(jwtFilter);
        jwtFilterFilterRegistrationBean.addUrlPatterns("/api/*");
        return jwtFilterFilterRegistrationBean;
    }
}
