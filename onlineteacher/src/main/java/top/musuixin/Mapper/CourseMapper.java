package top.musuixin.Mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import top.musuixin.Pojo.CourseInfoPojo;

import java.util.LinkedList;

/**
 * @author musuixin
 * @date 2019-05-03 20:45
 */
@Repository
@Mapper
public interface CourseMapper {
    @Insert("insert into course (courseName, teacherId, courseTime, courseText, courseImg, courseInfo, courseContent) values " +
            "(#{courseName} ,#{teacherId} ,#{courseTime} ,#{courseText} ,#{courseImg} ,#{courseInfo} ,#{courseContent} );")
    int addCourse(CourseInfoPojo courseInfoPojo);
    @Delete("delete from course where courseId=#{courseId}  and teacherId=#{teacherId} ")
    int deleteCourse(CourseInfoPojo courseInfoPojo);
    @Select("select courseId,courseImg,courseName,courseTime from course where teacherId=#{teacherId} ")
    LinkedList<CourseInfoPojo> getList(String teacherId);

    @Select("select courseId from course where teacherId=#{teacherId} ")
    LinkedList<Integer> getId(String teacherId);


    @Update("update course set courseTime=#{courseTime} ,courseName=#{courseName} ,courseImg=#{courseImg} ,courseContent=#{courseContent} ,courseInfo=#{courseInfo} ,courseText=#{courseText} where courseId=#{courseId} and teacherId=#{teacherId} ;")
    int upCourse(CourseInfoPojo courseInfoPojo);
}
