package top.musuixin.Mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.musuixin.PoJo.TeacherPoJo;

import java.util.List;

/**
 * @author musuixin
 * @date 2019-04-24 09:59
 */

@Repository
@Mapper
public interface TeacherMapper {
    @Select("select teacherId, teacherName,teacherSex,teacherAge,teacherEdu from teacher")
    List<TeacherPoJo> getTeacherList();
    @Select("select teacherName from teacher where teacherId=#{id} ")
    String getTeacher(Integer id);
    @Insert("insert into teacher (teacherName, teacherPwd, teacherSex, teacherAge, teacherEdu) values (#{teacherName} ,#{teacherPwd} ,#{teacherSex} ,#{teacherAge} ,#{teacherEdu} );")
    int addTeacher(TeacherPoJo teacherPoJo);
    @Delete("delete from teacher where teacherId=#{teacherId} ")
    int deleteTeacher(TeacherPoJo teacherPoJo);
}
