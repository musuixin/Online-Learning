package top.musuixin.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.musuixin.Pojo.CourseInfoPojo;

import java.util.LinkedList;

/**
 * @author musuixin
 * @date 2019-04-27 22:07
 */

@Mapper
@Repository

public interface CourseInfoMapper {
    @Select("SELECT courseId,courseName,courseTime,courseText,courseImg from course")
    LinkedList<CourseInfoPojo> getCourseList();

    @Select("SELECT * from course,teacher where course.teacherId=teacher.teacherId and courseId=#{courseId} ")
    CourseInfoPojo getCourse(CourseInfoPojo courseInfoPojo);
}
