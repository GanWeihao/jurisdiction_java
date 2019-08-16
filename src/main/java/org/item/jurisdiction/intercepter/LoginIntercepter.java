package org.item.jurisdiction.intercepter;

import org.item.jurisdiction.controller.FileController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginIntercepter implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(LoginIntercepter.class);

    @Autowired
    RedisTemplate redisTemplate;


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle方法执行了");
        System.out.println(handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e) throws Exception {
        System.out.println("afterCompletion方法执行了");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        // 在拦截点执行前拦截，如果返回true则不执行拦截点后的操作（拦截成功）
        // 返回false则不执行拦截
        Cookie [] cookies = request.getCookies();
        String token = null;

        if(cookies.length!=0){
            for (Cookie cookie : cookies) {
                switch(cookie.getName()){
                    case "userLogin":
                        token = cookie.getValue();
                        break;
                    default:
                        break;
                }
            }
        }

        String uri = request.getRequestURI(); // 获取登录的uri，这个是不进行拦截的
        //if(session.getAttribute("LOGIN_USER")!=null || uri.indexOf("system/login")!=-1) {// 说明登录成功 或者 执行登录功能
        if(token!=null || uri.indexOf("/user/login")!=-1) {
            // 登录成功不拦截
            System.out.println("--------------------------");
            return true;
        }else {
            // 拦截后进入登录页面
            System.out.println(uri);
            return false;
        }
    }
}
