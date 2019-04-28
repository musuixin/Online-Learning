package top.musuixin.Service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.musuixin.Mapper.NewsMapper;
import top.musuixin.PoJo.NewsPojo;
import top.musuixin.Service.NewsService;

import java.util.LinkedList;

/**
 * @author musuixin
 * @date 2019-04-25 11:57
 */
@Service
public class NewsServiceImple implements NewsService {
    @Autowired
    NewsMapper newsMapper;

    @Override
    public void addNews(NewsPojo newsPojo) {
        newsMapper.addNews(newsPojo);

    }

    @Override
    public LinkedList<NewsPojo> getNews() {
        return newsMapper.getNewsList();
    }

    @Override
    public int deleteNewsDate(NewsPojo newsPojo) {
        return newsMapper.deleteNews(newsPojo);
    }
}
