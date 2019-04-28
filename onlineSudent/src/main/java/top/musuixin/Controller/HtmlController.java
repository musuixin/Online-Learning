package top.musuixin.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author musuixin
 * @date 2019-04-27 16:59
 */
@Controller
public class HtmlController {
    @RequestMapping("/news/{id}")
    String showNews(){
        return "news";
    }
    @RequestMapping("/courseshow/{id}")
    String showCOurse(){
        return "courseshow";
    }
}
