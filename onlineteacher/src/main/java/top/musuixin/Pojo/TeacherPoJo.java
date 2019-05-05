package top.musuixin.Pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author musuixin
 * @date 2019-04-24 09:55
 */
@Data
@Component
public class TeacherPoJo {
    private String teacherId;
    private String teacherName;
    @JSONField(serialize=false)
    private String teacherPwd;
    private String teacherSex;
    private String teacherAge;
    private String teacherEdu;
}
