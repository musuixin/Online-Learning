package top.musuixin.Service;

import top.musuixin.PoJo.NewsPojo;

import java.util.LinkedList;

/**
 * @author musuixin
 * @date 2019-04-25 11:55
 */
public interface NewsService {
    void addNews(NewsPojo newsPojo);
    LinkedList<NewsPojo> getNews();
    int deleteNewsDate(NewsPojo newsPojo);
}
