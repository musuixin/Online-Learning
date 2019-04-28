package top.musuixin.PoJo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author musuixin
 * @date 2019-04-25 11:36
 */
@Component
@Data
public class NewsPojo {
    private String newsId;
    private String newsTo;
    private String newsTitle;
    private String newsText;
    private String newsDate;
}
