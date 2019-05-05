package top.musuixin.Interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author musuixin
 * @date 2019-04-27 13:11
 */
@Component
public class MyInterceptorLogin implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(MyInterceptorLogin.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //自动登陆逻辑
        if (request.getSession().getAttribute("teacherId") == null) {
            logger.info("被拦截了");
            response.sendRedirect("login");
            return false;
        }
        logger.info("现在用户为" + request.getSession().getAttribute("teacherId"));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
