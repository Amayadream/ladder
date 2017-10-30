package com.amayadream.retrofit2.service.config;

import com.amayadream.retrofit2.service.interceptor.SignInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.annotation.Resource;

/**
 * @author :  Amayadream
 * @date :  2017.10.30 21:48
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Resource
    private SignInterceptor signInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(signInterceptor).addPathPatterns("/**");
    }

}
