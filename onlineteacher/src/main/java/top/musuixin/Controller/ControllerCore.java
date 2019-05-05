package top.musuixin.Controller;

import com.sun.jersey.api.client.Client;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.musuixin.Mapper.CourseMapper;
import top.musuixin.Pojo.CourseInfoPojo;
import top.musuixin.Util.Upload;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.PUT;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author musuixin
 * @date 2019-05-03 20:49
 */
@CrossOrigin
@RestController
@PropertySource("classpath:config.properties")
@RequestMapping("/api")
public class ControllerCore {
    @Value(value = "${ueditor}")    //后台图片保存地址
    private String ueditor;
    @Value(value = "${uploadHost}")
    private String uploadHost;    //项目host路径
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    HashMap<String,Object> hashMap;
    @Autowired
    CourseInfoPojo courseInfoPojo;
    @PostMapping("/course")
    public HashMap<String,Object> addCourse(CourseInfoPojo courseInfoPojo, MultipartFile img, HttpServletRequest request, HttpServletResponse response){
        hashMap.put("data",null);
        Client client = new Client();
        try {
            String uploadInfo = Upload.upload(client, img, request, response, uploadHost, ueditor);
            String[] infoList = uploadInfo.split(";");
            courseInfoPojo.setCourseImg(infoList[2]);
        } catch (Exception e) {
            System.out.println(e);
        }
        String teacherId = (String)request.getSession().getAttribute("teacherId");
        courseInfoPojo.setTeacherId(teacherId);
        int i = courseMapper.addCourse(courseInfoPojo);
        if(i==1){
            hashMap.put("status","200");
            hashMap.put("msg","课程添加成功");
            return hashMap;
        }
        hashMap.put("status","400");
        hashMap.put("msg","课程添加失败");
        return hashMap;
    }
    @PutMapping("/course")
    public HashMap<String,Object> upCourse(CourseInfoPojo courseInfoPojo, MultipartFile img, HttpServletRequest request, HttpServletResponse response){
        hashMap.put("data",null);
        Client client = new Client();
        try {
            String uploadInfo = Upload.upload(client, img, request, response, uploadHost, ueditor);
            String[] infoList = uploadInfo.split(";");
            courseInfoPojo.setCourseImg(infoList[2]);
        } catch (Exception e) {
            System.out.println(e);
        }
        String teacherId = (String)request.getSession().getAttribute("teacherId");
        courseInfoPojo.setTeacherId(teacherId);
        int i = courseMapper.upCourse(courseInfoPojo);
        if(i==1){
            hashMap.put("status","200");
            hashMap.put("msg","课程修改成功");
            return hashMap;
        }
        hashMap.put("status","400");
        hashMap.put("msg","课程修改失败");
        return hashMap;
    }
    @GetMapping("getId")
    public HashMap<String,Object> getId(@SessionAttribute(value = "teacherId",required = false) String teacherId){
        LinkedList<Integer> id = courseMapper.getId(teacherId);
        hashMap.put("data",id);
        hashMap.put("status","200");
        hashMap.put("msg","获取成功");
        return  hashMap;


    }
    @GetMapping("/course")
    public HashMap<String,Object> getList(@SessionAttribute(value = "teacherId",required = false) String teacherId){
        LinkedList<CourseInfoPojo> list = courseMapper.getList(teacherId);
        hashMap.put("data",list);
        hashMap.put("status","200");
        hashMap.put("msg","获取成功");
        return hashMap;
    }
    @DeleteMapping("/course")
    public HashMap<String,Object> deleteCourse(Integer courseId,@SessionAttribute(value = "teacherId",required = false) String teacherId){
        hashMap.put("data",null);
        courseInfoPojo.setTeacherId(teacherId);
        courseInfoPojo.setCourseId(courseId);
        int i = courseMapper.deleteCourse(courseInfoPojo);
        if(i==1){
            hashMap.put("status","200");
            hashMap.put("msg","删除成功");
            return hashMap;
        }
        hashMap.put("status","400");
        hashMap.put("msg","删除失败");
        return hashMap;
    }
}
