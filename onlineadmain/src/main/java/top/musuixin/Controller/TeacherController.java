package top.musuixin.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.musuixin.PoJo.StudentPoJo;
import top.musuixin.PoJo.TeacherPoJo;
import top.musuixin.Service.imple.TeacherrServiceImple;
import top.musuixin.Util.EncryptUtil;

import java.util.HashMap;
import java.util.List;

/**
 * @author musuixin
 * @date 2019-04-24 10:10
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class TeacherController {
    @Autowired
    TeacherrServiceImple teacherrServiceImple;
    @Autowired
    TeacherPoJo teacherPoJo;
    @GetMapping("/teacher")
    public HashMap<String,Object> getTeacher(int num){
        PageHelper.startPage(num,10);
        List<TeacherPoJo> teacherList = teacherrServiceImple.getTeacherList();
        PageInfo pageInfo=new PageInfo(teacherList);
        HashMap<String,Object> hashMap=new HashMap<>();
        hashMap.put("totalData",pageInfo.getTotal());
        hashMap.put("teacherData",teacherList);
        return hashMap;
    }
    @PostMapping("/teacher")
    public HashMap<String,String> addStudent(TeacherPoJo teacherPoJo){
        HashMap<String,String> hashMap=new HashMap<>();
        teacherPoJo.setTeacherPwd(EncryptUtil.md5AndSha("654321"));
        int i = teacherrServiceImple.addTeacher(teacherPoJo);
        if(i==0){
            hashMap.put("status","400");
            hashMap.put("msg","添加失败");
            return hashMap;
        }
        hashMap.put("status","200");
        hashMap.put("msg","添加成功");
        return hashMap;
    }
    @DeleteMapping("/teacher")
    public HashMap<String,String> deleteStudent(int teacherId){
        HashMap<String,String> hashMap=new HashMap<>();
        teacherPoJo.setTeacherId(teacherId);
        int i = teacherrServiceImple.deleteTeacher(teacherPoJo);
        if(i!=0){
            hashMap.put("status","200");
            hashMap.put("msg","删除成功");
            return hashMap;
        }
        hashMap.put("status","400");
        hashMap.put("msg","删除失败");
        return hashMap;
    }
}
