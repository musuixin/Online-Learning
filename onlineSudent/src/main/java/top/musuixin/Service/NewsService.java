package top.musuixin.Service;


import top.musuixin.Pojo.NewsPojo;

import java.util.LinkedList;

/**
 * @author musuixin
 * @date 2019-04-25 11:55
 */
public interface NewsService {

    LinkedList<NewsPojo> getNews();
    NewsPojo getNewsText(NewsPojo newsPojo);

}
