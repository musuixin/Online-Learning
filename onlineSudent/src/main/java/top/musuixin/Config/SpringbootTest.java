package top.musuixin.Config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import top.musuixin.Mapper.StudentMapper;
import top.musuixin.Pojo.StudentPoJo;

/**
 * @author musuixin
 * @date 2019-03-30 19:16
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTest {
    @Autowired
    StudentMapper studentMapper;
    @Autowired
    StudentPoJo studentPoJo;
    @Test
    public void Test1() {
        studentPoJo.setStudentId(1000);
        studentPoJo.setStudentPwd("2222");
        StudentPoJo studentPoJo = studentMapper.studentLogin(this.studentPoJo);
        System.out.println(studentPoJo);
    }
}
