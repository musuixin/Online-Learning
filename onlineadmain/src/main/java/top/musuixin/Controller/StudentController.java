package top.musuixin.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.musuixin.PoJo.StudentPoJo;
import top.musuixin.Service.imple.StudentServiceImple;
import top.musuixin.Util.EncryptUtil;

import java.util.HashMap;
import java.util.List;

/**
 * @author musuixin
 * @date 2019-04-20 20:42
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class StudentController {
    @Autowired
    StudentPoJo studentPoJo;
    @Autowired
    StudentServiceImple studentServiceImple;
    @GetMapping("/student")
    public HashMap<String,Object> getStudentList(int num){
        List<StudentPoJo> studentList = studentServiceImple.getStudentList(num);
        PageInfo pageInfo=new PageInfo(studentList);
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("totalData",pageInfo.getTotal());
        hashMap.put("studentData",studentList);
        return hashMap;
    }
    @DeleteMapping("/student")
    public HashMap<String,String> deleteStudent(int studentId){
        HashMap<String,String> hashMap=new HashMap<>();
        studentPoJo.setStudentId(studentId);
        int i = studentServiceImple.deleteStudent(studentPoJo);
        if(i!=0){
            hashMap.put("status","200");
            hashMap.put("msg","删除成功");
            return hashMap;
        }
        hashMap.put("status","400");
        hashMap.put("msg","删除失败");
        return hashMap;
    }
    @PostMapping("/student")
    public HashMap<String,String> addStudent(StudentPoJo studentPoJo){
        HashMap<String,String> hashMap=new HashMap<>();
        studentPoJo.setStudentPwd(EncryptUtil.md5AndSha("123456"));
        int i = studentServiceImple.addStudent(studentPoJo);
        if(i==0){
            hashMap.put("status","400");
            hashMap.put("msg","添加失败");
            return hashMap;
        }
        hashMap.put("status","200");
        hashMap.put("msg","添加成功");
        return hashMap;

    }
}
