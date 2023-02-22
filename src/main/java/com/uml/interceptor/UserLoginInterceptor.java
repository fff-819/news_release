package com.uml.interceptor;

import com.auth0.jwt.exceptions.TokenExpiredException;
import com.uml.utils.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    TokenUtil tokenUtil;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = tokenUtil.getToken(request) ;
        System.out.println("拦截器："+token);
        if(token.isEmpty()){
            throw new Exception("不存在token");
        }
        return true ;
    }

}
