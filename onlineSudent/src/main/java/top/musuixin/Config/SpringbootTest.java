package top.musuixin.Config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.expression.spel.ast.Selection;
import org.springframework.test.context.junit4.SpringRunner;
import top.musuixin.Mapper.SelectionMapper;
import top.musuixin.Mapper.StudentMapper;
import top.musuixin.Pojo.SelectionPojo;
import top.musuixin.Pojo.StudentPoJo;

/**
 * @author musuixin
 * @date 2019-03-30 19:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTest {
    @Autowired
    SelectionPojo selectionPojo;
    @Autowired
    StudentPoJo studentPoJo;
    @Autowired
    SelectionMapper selectionMapper;
    @Test
    public void Test1() {
        studentPoJo.setStudentId(100003);
        selectionPojo.setCourseId("33");
        selectionMapper.getStudentSelect(studentPoJo,selectionPojo);


    }
}
