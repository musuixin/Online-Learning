package top.musuixin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.musuixin.Mapper.StudentMapper;
import top.musuixin.Pojo.StudentPoJo;
import top.musuixin.Util.EncryptUtil;

import java.util.HashMap;

/**
 * @author musuixin
 * @date 2019-05-01 13:58
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class ControllerInfo {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    HashMap<String,Object> hashMap;
    @Autowired
    StudentPoJo studentPoJo;
    @GetMapping("/getInfo")
    public HashMap<String,Object> getInfo(@SessionAttribute(value = "StudentId",required = false) String studentId){

        int i = Integer.parseInt(studentId);
        studentPoJo.setStudentId(i);
        StudentPoJo ingo = studentMapper.getIngo(studentPoJo);
        hashMap.put("msg","获取成功");
        hashMap.put("status","200");
        hashMap.put("data",ingo);
        return hashMap;

    }



    @PutMapping("/changeInfo")
    public HashMap<String,Object> changeInfo( @SessionAttribute(value = "StudentId",required = false) String studentId,@RequestBody StudentPoJo studentPoJo){
        hashMap.put("data",null);
        int i = Integer.parseInt(studentId);
        studentPoJo.setStudentId(i);
        int i1 = studentMapper.updataInfo(studentPoJo);
        if(i1==1){
            hashMap.put("status","200");
            hashMap.put("msg","修改成功");
            return hashMap;
        }
        hashMap.put("status","400");
        hashMap.put("msg","修改失败");
        return hashMap;
    }
    @PutMapping("/changePwd")
    public HashMap<String,Object> changePwd( @SessionAttribute(value = "StudentId",required = false) String studentId,@RequestBody StudentPoJo studentPoJo){
        int i = Integer.parseInt(studentId);
        studentPoJo.setStudentId(i);
        studentPoJo.setStudentPwd(EncryptUtil.md5AndSha(studentPoJo.getStudentPwd()));
        int i1 = studentMapper.changePwd(studentPoJo);
        if(i1==1){
            hashMap.put("status","200");
            hashMap.put("msg","修改成功");
            return hashMap;
        }
        hashMap.put("status","400");
        hashMap.put("msg","修改失败");
        return hashMap;


    }
}
