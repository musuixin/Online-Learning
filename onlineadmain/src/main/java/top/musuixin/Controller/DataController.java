package top.musuixin.Controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sun.text.resources.FormatData;
import top.musuixin.Mapper.CourseMapper;
import top.musuixin.Mapper.SelectionMapper;
import top.musuixin.PoJo.CoursePojo;
import top.musuixin.PoJo.NewsPojo;
import top.musuixin.PoJo.SelectionPojo;
import top.musuixin.Service.EchartService;
import top.musuixin.Service.NewsService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author musuixin
 * @date 2019-04-24 10:45
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class DataController {
    @Autowired
    EchartService echartService;
    @Autowired
    HashMap<String, Object> hashMap;
    @Autowired
    SelectionMapper selectionMapper;
    @Autowired
    CourseMapper courseMapper;
    @Autowired
    NewsService newsService;

    @GetMapping("/getNumber")
    HashMap<String, Object> getNumber() {
        hashMap.put("data",null);
        HashMap<String, Integer> number = echartService.getNumber();
        hashMap.put("status", "200");
        hashMap.put("data", number);
        return hashMap;
    }

    @GetMapping("/selectionData")
    HashMap<String, Object> getSelecctData(int num) {
        hashMap.put("data",null);
        PageHelper.startPage(num, 10);
        List<SelectionPojo> selectData = selectionMapper.getSelectData();
        PageInfo pageInfo = new PageInfo(selectData);
        long total = pageInfo.getTotal();
        hashMap.put("status", "200");
        hashMap.put("msg", "数据获取成功");
        hashMap.put("totalData", total);
        hashMap.put("data", selectData);
        return hashMap;
    }

    @GetMapping("/CourseData")
    HashMap<String, Object> getCourseData(int num) {
        hashMap.put("data",null);
        PageHelper.startPage(num, 10);
        List<CoursePojo> course = courseMapper.getCourse();
        PageInfo pageInfo = new PageInfo(course);
        long total = pageInfo.getTotal();
        hashMap.put("status", "200");
        hashMap.put("msg", "数据获取成功");
        hashMap.put("totalData", total);
        hashMap.put("data", course);
        return hashMap;
    }

    @PostMapping("/News")
    HashMap<String, Object> addNews(NewsPojo newsPojo) {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date);
        newsPojo.setNewsDate(dateStr);
        newsService.addNews(newsPojo);
        hashMap.put("status", "200");
        hashMap.put("msg", "数据添加成功");
        return hashMap;
    }

    @GetMapping("/News")
    HashMap<String, Object> getNews() {
        LinkedList<NewsPojo> news = newsService.getNews();
        hashMap.put("data", news);
        hashMap.put("status", "200");
        hashMap.put("msg", "获取数据成功");
        return hashMap;
    }

    @DeleteMapping("/News")
    HashMap<String, Object> deleteNews(NewsPojo newsPojo) {
        int i = newsService.deleteNewsDate(newsPojo);
        if (i == 1) {
            hashMap.put("status", "200");
            hashMap.put("msg", "删除成功");
            return hashMap;
        }
        hashMap.put("status", "400");
        hashMap.put("msg", "删除失败");
        return hashMap;

    }
}
