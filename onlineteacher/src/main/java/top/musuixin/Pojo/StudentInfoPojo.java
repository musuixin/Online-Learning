package top.musuixin.Pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author musuixin
 * @date 2019-05-04 10:13
 */
@Data
@Component
public class StudentInfoPojo {
    String studentName;
    String courseName;
    String time;
}
