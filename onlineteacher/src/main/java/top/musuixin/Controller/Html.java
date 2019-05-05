package top.musuixin.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * @author musuixin
 * @date 2019-05-04 21:30
 */
@Controller
@CrossOrigin
public class Html {
    @GetMapping("/news/{id}")
    public String getNews(){
        return "news.html";
    }
}
