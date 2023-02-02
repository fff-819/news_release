package com.uml.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AdministratorLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getSession().getAttribute("administrator")!=null){
            System.out.println("拦截器放行");
        }else{
            System.out.println("拦截器不放行");
        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

}
