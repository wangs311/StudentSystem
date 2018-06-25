package com.nenu.software.common.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description:
 * @author: Dongsl161
 * @Date: 2017/9/18 19:17
 */
public class LoginInterceptor implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 设置字符编码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        String uri = request.getRequestURI().substring(11);
        if(uri.contains("back")) {
            if(uri.equals("backTeacher/login")) {
                return true;
            }else if(session.getAttribute("teacher") != null) {
                return true;
            }
            response.sendRedirect("/StuSystem/loginBack.html");
            return false;
        }
        if(uri.equals("student/login")) {
            return true;
        }else if(session.getAttribute("student") != null) {
            return true;
        }
        response.sendRedirect("/StuSystem/login.html");
        return false;

    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
