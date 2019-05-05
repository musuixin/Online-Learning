package top.musuixin.Pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author musuixin
 * @date 2019-04-24 20:55
 */
@Component
@Data
public class CourseInfoPojo {
    private int courseId;
    private String courseName;
    private String courseTime;
    private String courseText;
    private String courseImg;
    private String courseInfo;
    private String teacherId;
    private String courseContent;
}
