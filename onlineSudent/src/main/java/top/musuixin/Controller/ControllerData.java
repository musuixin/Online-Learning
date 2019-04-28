package top.musuixin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.musuixin.Mapper.CourseInfoMapper;
import top.musuixin.Mapper.SelectionMapper;
import top.musuixin.Pojo.CourseInfoPojo;
import top.musuixin.Pojo.NewsPojo;
import top.musuixin.Pojo.SelectionPojo;
import top.musuixin.Pojo.StudentPoJo;
import top.musuixin.Service.Imple.NewsServiceImple;
import top.musuixin.Service.Imple.SelectionServiceImple;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author musuixin
 * @date 2019-04-27 15:53
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class ControllerData {
    @Autowired
    HashMap<String, Object> hashMap;
    @Autowired
    NewsServiceImple newsServiceImple;
    @Autowired
    CourseInfoMapper courseInfoMapper;
    @Autowired
    SelectionMapper selectionMapper;
    @Autowired
    SelectionServiceImple selectionServiceImple;
    @Autowired
    StudentPoJo studentPoJo;

    @GetMapping("/getNewsList")
    HashMap<String, Object> getNewsList() {
        hashMap.put("data", null);
        hashMap.put("data", newsServiceImple.getNews());
        hashMap.put("status", "200");
        hashMap.put("msg", "获取成功");


        return hashMap;
    }

    @GetMapping("/getNewsText")
    HashMap<String, Object> getNewsText(NewsPojo newsPojo) {
        NewsPojo newsText = newsServiceImple.getNewsText(newsPojo);
        if (newsText == null) {
            hashMap.put("data", null);
            hashMap.put("status", "400");
            hashMap.put("msg", "没有此新闻信息");
            return hashMap;
        }
        hashMap.put("status", "200");
        hashMap.put("msg", "获取信息成功");

        hashMap.put("data", newsText);
        return hashMap;

    }

    @GetMapping("/getCourseList")
    HashMap<String, Object> getCourseList() {
        hashMap.put("data", null);
        hashMap.put("data", courseInfoMapper.getCourseList());
        hashMap.put("status", "200");
        hashMap.put("msg", "获取成功");
        return hashMap;

    }

    @GetMapping("/getCourse")
    HashMap<String, Object> getCourse(CourseInfoPojo courseInfoPojo) {
        CourseInfoPojo course = courseInfoMapper.getCourse(courseInfoPojo);
        if (course == null) {
            hashMap.put("status", "400");
            hashMap.put("data", null);
            hashMap.put("msg", "没有此课程信息");
            return hashMap;
        }
        hashMap.put("status", "200");
        hashMap.put("msg", "获取信息成功");
        hashMap.put("data", course);
        return hashMap;
    }

    @GetMapping("/getSelectInfo")
    HashMap<String, Object> getSelectInfo(SelectionPojo selectionPojo) {
        LinkedList<SelectionPojo> selectList = selectionMapper.getSelectList(selectionPojo);

        if (selectList.isEmpty()) {
            hashMap.put("data", null);
            hashMap.put("status", "400");
            hashMap.put("msg", "没有此课程选课评论信息");
            return hashMap;
        }
        hashMap.put("status", "200");
        hashMap.put("msg", "获取信息成功");
        hashMap.put("data", selectList);
        return hashMap;
    }

    @PostMapping("/addSelectAssess")
    HashMap<String, Object> addSelectAssess(SelectionPojo selectionPojo, @SessionAttribute(value = "StudentId", required = false) String studentId) {
        System.out.println(studentId);
        hashMap.put("data", null);
        if (studentId == null) {
            hashMap.put("status", "400");
            hashMap.put("msg", "请先登陆");
            return hashMap;

        }
        int i = Integer.parseInt(studentId);
        studentPoJo.setStudentId(i);
        HashMap<String, Object> hashMap = selectionServiceImple.addSelectAssess(studentPoJo, selectionPojo);
        return hashMap;
    }
}
