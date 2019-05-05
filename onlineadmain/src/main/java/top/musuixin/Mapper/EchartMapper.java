package top.musuixin.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author musuixin
 * @date 2019-04-24 10:46
 */
@Mapper
@Repository
public interface EchartMapper {
    @Select("select count(*) from teacher")
    int getTeacherNumber();
    @Select("select count(*) from student")
    int getStudentNumber();
    @Select("select count(*) from course")
    int getCourseNumber();
    @Select("select sum(courseTime)  from course")
    int getTotalTime();
}
