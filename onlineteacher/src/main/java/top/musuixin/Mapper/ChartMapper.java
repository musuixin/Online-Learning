package top.musuixin.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.musuixin.Pojo.StudentInfoPojo;

import java.util.LinkedList;

/**
 * @author musuixin
 * @date 2019-05-03 16:13
 */
@Mapper
@Repository
public interface ChartMapper {
    @Select("select count(*) from course where teacherId=#{teacher} ")
    int courseTotal(String teacher);
    @Select("select count(*) from selection,course where selection.courseId=course.courseId and course.teacherId=#{teacher} ")
    int studentTotal(String teacher);
    @Select("select COALESCE(SUM(time),0) from selection,course where selection.courseId=course.courseId and course.teacherId=#{teacher} ")
    Integer timeTotal(String teacher);
    @Select("select count(*) from selection,course where selection.courseId=course.courseId and course.teacherId=#{teacher} and selection.assess!='未评论'")
    int assessTotal(String teacher);
    @Select("select studentName,courseName,time from selection,course,student where selection.courseId=course.courseId and selection.studentId=student.studentId and course" +
            ".teacherId=#{teacher}")
    LinkedList<StudentInfoPojo> getStudentInfo(String teacher);

}
