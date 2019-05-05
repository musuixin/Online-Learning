package top.musuixin.Service.Imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.musuixin.Mapper.ChartMapper;
import top.musuixin.Pojo.DataPojo;
import top.musuixin.Service.ChartService;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author musuixin
 * @date 2019-05-04 10:05
 */
@Service
public class ChartServiceImpl implements ChartService {
    @Autowired
    ChartMapper chartMapper;
    @Autowired
    DataPojo dataPojo;

    @Override
    public HashMap<String, Object> getChartData(String teacherId) {
        HashMap<String,Object> hashMap=new HashMap<>();
        HashMap<String,Object> hashMap1=new HashMap<>();
        dataPojo.setAssessTotal(chartMapper.assessTotal(teacherId));
        dataPojo.setCourseTotal(chartMapper.courseTotal(teacherId));
        dataPojo.setStudentTotal(chartMapper.studentTotal(teacherId));
        dataPojo.setTimeTotal(chartMapper.timeTotal(teacherId));
        hashMap1.put("chart",dataPojo);
        hashMap1.put("table",chartMapper.getStudentInfo(teacherId));
        hashMap.put("data",hashMap1);
        hashMap.put("status","200");
        hashMap.put("msg","获取成功");
        return hashMap;
    }
}
