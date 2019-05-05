package top.musuixin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.musuixin.Service.Imple.ChartServiceImpl;

import java.util.HashMap;

/**
 * @author musuixin
 * @date 2019-05-04 10:26
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class ControllerData {
    @Autowired
    ChartServiceImpl chartService;

    @GetMapping("/indexData")
    public HashMap<String, Object> getData(@SessionAttribute(value = "teacherId", required = false) String teacherId) {
        System.out.println(teacherId);
        HashMap<String, Object> chartData = chartService.getChartData(teacherId);
        return chartData;
    }
}
