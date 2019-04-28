package top.musuixin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.musuixin.Pojo.StudentPoJo;
import top.musuixin.Service.Imple.StudentServiceImple;
import top.musuixin.Util.EncryptUtil;

import javax.servlet.http.HttpSession;
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
    HashMap<String, Object> Login(StudentPoJo studentPoJo, HttpSession httpSession) {
        studentPoJo.setStudentPwd(EncryptUtil.md5AndSha(studentPoJo.getStudentPwd()));
        System.out.println(studentPoJo);
        StudentPoJo studentLogin = studentServiceImple.studentLogin(studentPoJo);
        if (studentLogin == null) {
            hashMap.put("status", "400");
            hashMap.put("msg", "用户名或密码错误");
            return hashMap;
        }
        httpSession.setAttribute("StudentId", studentPoJo.getStudentId());
        System.out.println(httpSession.getAttribute("StudentId") + "登陆成功");
        hashMap.put("status", "200");
        hashMap.put("msg", "登陆成功");
        return hashMap;


    }

}
