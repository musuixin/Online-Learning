package top.musuixin.Pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author musuixin
 * @date 2019-04-28 21:43
 */
@Data
@Component
public class StudyDataPojo {
    private String selectionId;
    private String courseImg;
    private String courseName;
    private String state;
    private String courseTime;
    private String time;
    
}