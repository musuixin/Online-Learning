package top.musuixin.Mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import sun.awt.image.ImageWatched;
import top.musuixin.PoJo.StudentPoJo;

import java.util.LinkedList;
import java.util.List;

/**
 * @author musuixin
 * @date 2019-04-20 21:03
 * 数据库学生表
 */
@Mapper
@Repository
public interface StudentMapper {
    @Select("select * from student")
    List<StudentPoJo> getStudent();
    @Delete("delete from student where studentId=#{studentId} ")
    int deleteStudent(StudentPoJo studentPoJo);
    @Insert("insert into student (studentName, studentPwd, studentAge, studentSex,studentOc) values (#{studentName} ,#{studentPwd},#{studentAge} ,#{studentSex} ,#{studentOc})")
    int addStudent(StudentPoJo studentPoJo);
}
