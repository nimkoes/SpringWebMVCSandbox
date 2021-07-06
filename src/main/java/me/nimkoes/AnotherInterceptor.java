package me.nimkoes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class AnotherInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("========== AnotherInterceptor preHandle ==========");
        System.out.println(">>>>>>>>>> handler");
        System.out.println("getClass : " + handler.getClass());
        System.out.println("toString : " + handler.toString());
        System.out.println();
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("========== AnotherInterceptor postHandle ==========");
        System.out.println("isEmpty : " + (modelAndView == null));
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("========== AnotherInterceptor afterCompletion ==========");
    }
}
