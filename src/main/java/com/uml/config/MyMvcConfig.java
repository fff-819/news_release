package com.uml.config;

import com.uml.interceptor.AdministratorLoginInterceptor;
import com.uml.interceptor.UserLoginInterceptor;
import com.uml.pojo.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * mvc拦截器配置类
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Autowired
    UserLoginInterceptor userloginInterceptor;
    @Autowired
    AdministratorLoginInterceptor administratorLoginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(userloginInterceptor).addPathPatterns("/users/*");
        registry.addInterceptor(administratorLoginInterceptor).addPathPatterns("/administrator/*");
        WebMvcConfigurer.super.addInterceptors(registry);
    }
}
