package top.musuixin.Mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import top.musuixin.PoJo.NewsPojo;

import java.util.LinkedList;

/**
 * @author musuixin
 * @date 2019-04-25 11:51
 */
@Mapper
@Repository
public interface NewsMapper {
    @Insert("insert into online.news (newsTo, newsTitle, newsText, newsDate) values (#{newsTo} ,#{newsTitle} ,#{newsText} ,#{newsDate} );")
    void addNews(NewsPojo newsPojo);
    @Select("select newsId, newsTo, newsTitle,newsDate from online.news;")
    LinkedList<NewsPojo> getNewsList();
    @Delete("delete from online.news where newsId=#{newsId}")
    int deleteNews(NewsPojo newsPojo);
}
