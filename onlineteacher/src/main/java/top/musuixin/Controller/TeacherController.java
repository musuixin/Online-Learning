package top.musuixin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.musuixin.Mapper.TeacherMapper;
import top.musuixin.Pojo.TeacherPoJo;
import top.musuixin.Util.EncryptUtil;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author musuixin
 * @date 2019-05-03 16:17
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class TeacherController {
    @Autowired
    TeacherMapper teacherMapper;
    @Autowired
    HashMap<String,Object> hashMap;

    @PostMapping("/login")
    HashMap<String ,Object> login(@RequestBody TeacherPoJo teacherPoJo, HttpSession session){
        hashMap.put("data",null);
        teacherPoJo.setTeacherPwd(EncryptUtil.md5AndSha(teacherPoJo.getTeacherPwd()));
        System.out.println(teacherPoJo);
        TeacherPoJo login = teacherMapper.Login(teacherPoJo);
        if(login!=null){
            hashMap.put("status","200");
            hashMap.put("msg","登陆成功");
            session.setAttribute("teacherId",teacherPoJo.getTeacherId());
            return hashMap;
        }
        hashMap.put("status","400");
        hashMap.put("msg","用户名或密码错误");
        return hashMap;
    }
    @GetMapping("/info")
    public HashMap<String,Object> teacherInfo(@SessionAttribute(value = "teacherId",required = false) String teacherId){
        TeacherPoJo info = teacherMapper.info(teacherId);
        hashMap.put("status","200");
        hashMap.put("msg","获取成功");
        hashMap.put("data",info);
        return hashMap;
    }
    @PutMapping("/upPwd")
    public HashMap<String,Object> upPwd(@RequestBody TeacherPoJo teacherPoJo,@SessionAttribute(value = "teacherId",required = false) String teacherId){
        hashMap.put("data",null);

        teacherPoJo.setTeacherId(teacherId);
        teacherPoJo.setTeacherPwd(EncryptUtil.md5AndSha(teacherPoJo.getTeacherPwd()));
        int i = teacherMapper.upPwd(teacherPoJo);
        if(i==1){
            hashMap.put("status","200");
            hashMap.put("msg","修改成功");
            return hashMap;
        }
        hashMap.put("status","400");
        hashMap.put("msg","修改失败");
        return hashMap;
    }
    @PutMapping("/upInfo")
    public HashMap<String,Object> upInfo(@RequestBody TeacherPoJo teacherPoJo,@SessionAttribute(value = "teacherId",required = false) String teacherId){
        hashMap.put("data",null);
        teacherPoJo.setTeacherId(teacherId);
        int i = teacherMapper.upInfo(teacherPoJo);
        if(i==1){
            hashMap.put("status","200");
            hashMap.put("msg","修改成功");
            return hashMap;
        }
        hashMap.put("status","400");
        hashMap.put("msg","修改失败");
        return hashMap;
    }
}
