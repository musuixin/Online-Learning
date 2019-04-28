package top.musuixin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.musuixin.Mapper.CourseInfoMapper;
import top.musuixin.Pojo.CourseInfoPojo;
import top.musuixin.Pojo.NewsPojo;
import top.musuixin.Service.Imple.NewsServiceImple;

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

    @GetMapping("/getNewsList")
    HashMap<String, Object> getNewsList() {
        hashMap.put("data", newsServiceImple.getNews());
        hashMap.put("status", "200");
        hashMap.put("msg", "获取成功");


        return hashMap;
    }

    @GetMapping("/getNewsText")
    HashMap<String, Object> getNewsText(NewsPojo newsPojo) {
        NewsPojo newsText = newsServiceImple.getNewsText(newsPojo);
        if (newsText == null) {
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
            hashMap.put("msg", "没有此课程信息");
            return hashMap;
        }
        hashMap.put("status", "200");
        hashMap.put("msg", "获取信息成功");
        hashMap.put("data", course);
        return hashMap;

    }
}
