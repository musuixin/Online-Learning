package top.musuixin.PoJo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author musuixin
 * @date 2019-04-24 09:55
 */
@Data
@Component
public class TeacherPoJo {
    private int teacherId;
    private String teacherName;
    private String teacherPwd;
    private String teacherSex;
    private String teacherAge;
    private String teacherEdu;
}
