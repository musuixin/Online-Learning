package top.musuixin.Config;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.musuixin.Mapper.*;
import top.musuixin.PoJo.*;
import top.musuixin.Service.NewsService;
import top.musuixin.Service.imple.AdmainServiceImple;
import top.musuixin.Service.imple.EchartServiceimple;
import top.musuixin.Service.imple.StudentServiceImple;

import java.util.HashMap;
import java.util.List;

/**
 * @author musuixin
 * @date 2019-03-30 19:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTest {

   @Autowired
    NewsService newsService;
   @Autowired
    NewsPojo newsPojo;

    @Test
    public void Test1() {
//        newsPojo.setNewsDate("2009-12-30 12:12:22");
//        newsPojo.setNewsText("dddd");
//        newsPojo.setNewsTitle("fff");
//        newsPojo.setNewsTo("fff");
        System.out.println("哈哈");
//        newsService.addNews(newsPojo);
    }
}
