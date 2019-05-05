package top.musuixin.Controller;

import org.apache.logging.log4j.message.StringFormattedMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.musuixin.Mapper.NewsMapper;

import java.util.HashMap;

/**
 * @author musuixin
 * @date 2019-05-04 21:07
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ControllerNews {
    @Autowired
    HashMap<String,Object> hashMap;

    @Autowired
    NewsMapper newsMapper;
    @GetMapping("/newsList")
    public HashMap<String,Object> getList(){
        hashMap.put("data",newsMapper.getNewsList());
        hashMap.put("status","200");
        hashMap.put("msg","获取成功");
        return hashMap;
    }
    @GetMapping("/news")
    public HashMap<String,Object> getList(String newsId){
        hashMap.put("data",newsMapper.getNewsText(newsId));
        hashMap.put("status","200");
        hashMap.put("msg","获取成功");
        return hashMap;
    }
}
