package top.musuixin.Config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.musuixin.Mapper.ChartMapper;
import top.musuixin.Mapper.CourseMapper;
import top.musuixin.Pojo.DataPojo;
import top.musuixin.Pojo.StudentInfoPojo;
import top.musuixin.Service.Imple.ChartServiceImpl;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author musuixin
 * @date 2019-03-30 19:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTest {
    @Autowired
    ChartServiceImpl chartService;
    @Autowired
    ChartMapper chartMapper;

    @Test
    public void Test1() {
        HashMap<String, Object> chartData = chartService.getChartData("1000000");
        Object data = chartData.get("data");
        System.out.println(data);
    }
}
