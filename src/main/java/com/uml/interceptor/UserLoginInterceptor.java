package com.uml.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器：用户在未登录的情况下会被此拦截器拦截，会自动跳转到登录页面
 * 普通用户的
 */
@Component
public class UserLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("user")!=null){
            System.out.println("拦截器放行");
        }else{
            System.out.println("拦截器不放行");
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

}
