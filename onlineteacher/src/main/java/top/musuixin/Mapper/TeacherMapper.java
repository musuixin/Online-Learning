package top.musuixin.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import top.musuixin.Pojo.TeacherPoJo;

/**
 * @author musuixin
 * @date 2019-05-03 16:15
 */
@Mapper
@Repository
public interface TeacherMapper {
    @Select("select  * from teacher where teacherId=#{teacherId} and teacherPwd=#{teacherPwd} ")
    TeacherPoJo Login(TeacherPoJo teacherPoJo);
    @Select("select * from teacher where teacherId=#{teacherId}")
    TeacherPoJo info(String teacherId);
    @Update("update teacher set teacherPwd  =#{teacherPwd}   where teacherId=#{teacherId}  ;")
    int upPwd(TeacherPoJo teacherPoJo);
    @Update("update teacher set teacherEdu=#{teacherEdu} ,teacherName=#{teacherName} ,teacherAge=#{teacherAge} ," +
            "teacherSex=#{teacherSex}   where teacherId=#{teacherId}  ;")
    int upInfo(TeacherPoJo teacherPoJo);
}
