package top.musuixin.Pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author musuixin
 * @date 2019-04-24 20:06
 */
@Component
@Data
public class SelectionPojo implements Serializable {
    private  String studentName;
    private String courseId;
    private  String assess;
}
