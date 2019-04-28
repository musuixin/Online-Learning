package top.musuixin.Mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.musuixin.PoJo.CoursePojo;

import java.util.List;

/**
 * @author musuixin
 * @date 2019-04-24 20:59
 */
@Repository
@Mapper
public interface CourseMapper {
    @Select("select * from teacher,course where teacher.teacherId=course.teacherId")
    @Results({
            @Result(property = "teacherName", column = "teacherId", one = @One(select = "top.musuixin.Mapper.TeacherMapper.getTeacher"))
    })
    List<CoursePojo> getCourse();
}
