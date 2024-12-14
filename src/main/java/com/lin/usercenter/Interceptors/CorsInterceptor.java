package com.lin.usercenter.Interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CorsInterceptor implements HandlerInterceptor {
    //todo 这里怎么根据当前环境切换正确的FRONT_HOST
    //public static final String FRONT_HOST="https://user-center-frontend-mocha.vercel.app,http://localhost:8000";
    public static final String FRONT_HOST="https://user-center-frontend-131899-9-1325475313.sh.run.tcloudbase.com";
    //public static final String FRONT_HOST1="http://localhost:8000";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setHeader("Access-Control-Allow-Origin",FRONT_HOST);
        response.setHeader("Access-Control-Allow-Methods","GET,HEAD,OPTIONS,POST,PUT");
        response.setHeader("Access-Control-Allow-Headers","Origin, X-Requested-With, Content-Type, Accept, Authorization");
        response.setHeader("Access-Control-Allow-Credentials","true");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}