package top.musuixin.Pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author musuixin
 * @date 2019-04-29 19:25
 */
@Data
@Component
public class LearningRecordPoJo {
    private  String selectionId;
    private String startTime;
    private String endTime;
    private Long Time;
}
