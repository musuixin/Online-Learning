package top.musuixin.Service.Imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import top.musuixin.Mapper.NewsMapper;

import top.musuixin.Pojo.NewsPojo;
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

    public LinkedList<NewsPojo> getNews() {
        return newsMapper.getNewsList();
    }

    @Override
    public NewsPojo getNewsText(NewsPojo newsPojo) {
        return newsMapper.getNewsText(newsPojo);
    }

}
