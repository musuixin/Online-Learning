package top.musuixin.Pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author musuixin
 * @date 2019-05-03 16:10
 */
@Data
@Component
public class DataPojo {
    private int courseTotal;
    private int studentTotal;
    private int timeTotal;
    private int assessTotal;
}
