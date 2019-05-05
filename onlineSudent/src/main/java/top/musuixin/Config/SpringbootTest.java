package top.musuixin.Config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.spel.ast.Selection;
import org.springframework.test.context.junit4.SpringRunner;
import top.musuixin.Mapper.SelectionMapper;
import top.musuixin.Mapper.StudentMapper;
import top.musuixin.Mapper.StudyDataMapper;
import top.musuixin.Pojo.LearningRecordPoJo;
import top.musuixin.Pojo.SelectionPojo;
import top.musuixin.Pojo.StudentPoJo;
import top.musuixin.Pojo.StudyDataPojo;
import top.musuixin.Service.Imple.SelectionServiceImple;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    StudyDataMapper studyDataMapper;
    @Autowired
    LearningRecordPoJo learningRecordPoJo;

    @Test
    public void Test1() {

        learningRecordPoJo.setSelectionId("3698");
        learningRecordPoJo.setStartTime("2018-8-23 21:23:23");
        learningRecordPoJo.setEndTime("2018-8-23 21:23:23");
        learningRecordPoJo.setTime(23L);
        studyDataMapper.addLearnRecord(learningRecordPoJo);
//        LOG.info("哈哈");
    }
}
