package top.musuixin.Mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import top.musuixin.Pojo.NewsPojo;

import java.util.LinkedList;

/**
 * @author musuixin
 * @date 2019-04-25 11:51
 */
@Mapper
@Repository

public interface NewsMapper {

    @Select("select newsId, newsTo, newsTitle,newsDate from online.news where newsTo!='教师' order by newsDate desc ;")
    LinkedList<NewsPojo> getNewsList();
    @Select("select * from  online.news where newsId=#{newsId} ")
    NewsPojo getNewsText(NewsPojo newsPojo);

}
