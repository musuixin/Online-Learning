package top.musuixin.Interceptor;

import org.omg.PortableInterceptor.Interceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import top.musuixin.Config.SpringbootTest;
import top.musuixin.Mapper.StudentMapper;
import top.musuixin.Pojo.StudentPoJo;
import top.musuixin.Service.Imple.StudentServiceImple;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author musuixin
 * @date 2019-04-27 13:11
 */
@Component
public class MyInterceptorLogin implements HandlerInterceptor {
    @Autowired
    StudentMapper studentMapper;
    private static final Logger logger= LoggerFactory.getLogger(MyInterceptorLogin.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //自动登陆逻辑
        StudentPoJo studentPoJo=new StudentPoJo();
        try {
            Cookie[] cookies = request.getCookies();
            for(Cookie cookie:cookies){
                if(cookie.getName().equals("studentIdPwd")){
                    String[] split = cookie.getValue().split("@@");
                    int i = Integer.parseInt(split[0]);
                    studentPoJo.setStudentId(i);
                    studentPoJo.setStudentPwd(split[1]);
                    System.out.println(studentPoJo);
                    StudentPoJo studentLogin = studentMapper.studentLogin(studentPoJo);
                    if(studentLogin!=null){
                        request.getSession().setAttribute("StudentId",studentPoJo.getStudentId());
                    }
                }
            }
        }
        catch (Exception e){
            logger.info("出现异常");
        }

        if(request.getSession().getAttribute("StudentId")==null){
            logger.info("被拦截了");
            response.sendRedirect("login");
            return false;
        }
        logger.info("现在用户为"+request.getSession().getAttribute("StudentId"));
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
