package top.musuixin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.musuixin.Pojo.StudentPoJo;
import top.musuixin.Service.Imple.StudentServiceImple;
import top.musuixin.Util.EncryptUtil;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.HttpCookie;
import java.util.HashMap;

/**
 * @author musuixin
 * @date 2019-04-27 14:54
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class ControllerLogin {
    @Autowired
    HashMap<String, Object> hashMap;
    @Autowired
    StudentServiceImple studentServiceImple;

    @PostMapping("/Login")
    HashMap<String, Object> Login(StudentPoJo studentPoJo, HttpSession httpSession, HttpServletResponse response) {
        hashMap.put("data", null);
        studentPoJo.setStudentPwd(EncryptUtil.md5AndSha(studentPoJo.getStudentPwd()));
        System.out.println(studentPoJo);
        StudentPoJo studentLogin = studentServiceImple.studentLogin(studentPoJo);
        if (studentLogin == null) {
            hashMap.put("status", "400");
            hashMap.put("msg", "用户名或密码错误");
            return hashMap;
        }
        hashMap.put("status", "200");
        httpSession.setAttribute("StudentId", studentPoJo.getStudentId());
        System.out.println(httpSession.getAttribute("StudentId") + "登陆成功");
        String s = String.valueOf(studentPoJo.getStudentId());
        Cookie httpCookie = new Cookie("studentIdPwd", s + "@@" + studentPoJo.getStudentPwd());
        httpCookie.setPath("/");
        httpCookie.setMaxAge(99999999);
        response.addCookie(httpCookie);
        hashMap.put("msg", "登陆成功");
        return hashMap;
    }

}
