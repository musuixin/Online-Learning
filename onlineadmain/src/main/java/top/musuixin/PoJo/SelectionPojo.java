package top.musuixin.PoJo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author musuixin
 * @date 2019-04-24 20:06
 */
@Component
@Data
public class SelectionPojo {
    private  String studentName;
    private  String teacherName;
    private String courseName;
    private  String assess;
}
