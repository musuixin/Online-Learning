package top.musuixin.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.musuixin.PoJo.SelectionPojo;

import java.util.List;

/**
 * @author musuixin
 * @date 2019-04-24 20:13
 */
@Repository
@Mapper
public interface SelectionMapper {
    @Select("select studentName,teacherName,courseName,assess\n" +
            "from student,selection,course,teacher\n" +
            "where student.studentId=selection.studentId and\n" +
            "     course.courseId=selection.courseId and  course.teacherId=teacher.teacherId")
    List<SelectionPojo> getSelectData();
}
