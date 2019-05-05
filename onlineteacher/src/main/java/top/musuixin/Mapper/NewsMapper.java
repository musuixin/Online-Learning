package top.musuixin.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.musuixin.Pojo.NewsPojo;

import java.util.LinkedList;

/**
 * @author musuixin
 * @date 2019-04-25 11:51
 */
@Mapper
@Repository

public interface NewsMapper {

    @Select("select newsId, newsTitle,newsDate from online.news where newsTo!='学生' order by newsDate desc ;")
    LinkedList<NewsPojo> getNewsList();
    @Select("select newsText from  online.news where newsId=#{newsId} ")
    NewsPojo getNewsText(String newsId);

}
