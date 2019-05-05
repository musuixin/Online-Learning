package top.musuixin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.musuixin.Mapper.CourseInfoMapper;
import top.musuixin.Mapper.SelectionMapper;
import top.musuixin.Mapper.StudyDataMapper;
import top.musuixin.Pojo.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author musuixin
 * @date 2019-04-28 21:26
 */
@RestController
@CrossOrigin
@RequestMapping("/api")
public class ControllerCore {
    @Autowired
    StudyDataMapper studyDataMapper;
    @Autowired
    StudentPoJo studentPoJo;
    @Autowired
    LearningRecordPoJo learningRecordPoJo;
    @Autowired
    HashMap<String, Object> hashMap;
    @Autowired
    SelectionMapper selectionMapper;
    @Autowired
    CourseInfoMapper courseInfoMapper;

    @GetMapping("/studyData")
    HashMap<String, Object> studyData(@SessionAttribute(value = "StudentId", required = false) String StudentID) {
        HashMap<String, Object> hashMap = new HashMap<>();
        int i = Integer.parseInt(StudentID);
        studentPoJo.setStudentId(i);
        LinkedList<StudyDataPojo> studyList = studyDataMapper.getStudyList(studentPoJo);
        hashMap.put("status", "200");
        hashMap.put("data", studyList);
        hashMap.put("msg", "获取成功");
        return hashMap;
    }

    @GetMapping("/startStudy")
    HashMap<String, Object> startStudy(LearningRecordPoJo learningRecordPoJo, @SessionAttribute(value = "StudentId", required = false) String StudentID, HttpSession httpSession) {
        hashMap.put("data", null);
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime time = LocalDateTime.now();
        String localTime = df.format(time);
        studentPoJo.setStudentId(Integer.parseInt(StudentID));
        LinkedList<StudyDataPojo> studyList = studyDataMapper.getStudyList(studentPoJo);

        for (StudyDataPojo studyDataPojo : studyList) {
            if (studyDataPojo.getSelectionId().equals(learningRecordPoJo.getSelectionId())) {
                httpSession.setAttribute("startTime", learningRecordPoJo.getSelectionId() + "@@" + localTime);
                Object startTime = httpSession.getAttribute("startTime");
                hashMap.put("status", "200");
                hashMap.put("msg", "开始记录时间");
                hashMap.put("data",courseInfoMapper.selectContent(learningRecordPoJo.getSelectionId()).getCourseContent());
                return hashMap;
            }
        }
        hashMap.put("status", "400");
        hashMap.put("msg", "发生错误！");
        return hashMap;
    }

    @GetMapping("/stopStudy")
    HashMap<String, Object> stopStudy(LearningRecordPoJo learningRecordPoJo, @SessionAttribute(value = "startTime", required = false) String starTime) {
        hashMap.put("data", null);
        if (starTime != null) {
            String[] split = starTime.split("@@");
            if (split[0].equals(learningRecordPoJo.getSelectionId())) {
                DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime time = LocalDateTime.now();
                String endTime = df.format(time);
                learningRecordPoJo.setStartTime(split[1]);
                learningRecordPoJo.setEndTime(endTime);
                LocalDateTime parse1 = LocalDateTime.parse(split[1], df);
                LocalDateTime parse2 = LocalDateTime.parse(endTime, df);
                long betweenTime = ChronoUnit.MINUTES.between(parse1, parse2);
                learningRecordPoJo.setTime(betweenTime);
                studyDataMapper.addLearnRecord(learningRecordPoJo);
                hashMap.put("status", "200");
                hashMap.put("msg", betweenTime);
                return hashMap;
            }
        }
        hashMap.put("status", "400");
        hashMap.put("msg", "停止学习错误！");
        return hashMap;
    }
    @DeleteMapping("/deleteStudy")
    public HashMap<String,Object> deleteStudy(SelectionPojo selectionPojo,@SessionAttribute(value = "StudentId",required = false) String studentID){
        hashMap.put("data",null);
        selectionPojo.setStudentId(studentID);
        System.out.println(selectionPojo);
        int i = selectionMapper.deleteSelection(selectionPojo);
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
