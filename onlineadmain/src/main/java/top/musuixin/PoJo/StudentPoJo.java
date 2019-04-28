package top.musuixin.PoJo;

/**
 * @author musuixin
 * @date 2019-04-20 21:00
 */

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
public class StudentPoJo implements Serializable {
    private int studentId;
    private String studentName;
    private String studentPwd;
    private String studentAge;
    private String studentSex;
    private String studentOc;
}
