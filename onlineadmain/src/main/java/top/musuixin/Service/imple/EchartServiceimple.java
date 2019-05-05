package top.musuixin.Service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import top.musuixin.Mapper.EchartMapper;
import top.musuixin.Service.EchartService;

import java.util.HashMap;

/**
 * @author musuixin
 * @date 2019-04-24 10:50
 */
@Service
public class EchartServiceimple implements EchartService {
    @Autowired
    EchartMapper echartMapper;

    @Override
    public HashMap<String, Integer> getNumber() {
        HashMap<String, Integer> hashMap = new HashMap<>();
        int studentNumber = echartMapper.getStudentNumber();
        int teacherNumber = echartMapper.getTeacherNumber();
        int courseNumber = echartMapper.getCourseNumber();
        int totalTime = echartMapper.getTotalTime();
        hashMap.put("studentNumber", studentNumber);
        hashMap.put("teacherNumber", teacherNumber);
        hashMap.put("courserNumber", courseNumber);
        hashMap.put("totalTime", totalTime);
        return hashMap;
    }


}
