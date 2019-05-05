package top.musuixin.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;
import top.musuixin.Pojo.StudentPoJo;

/**
 * @author musuixin
 * @date 2019-04-27 15:01
 */
@Repository
@Mapper
public interface StudentMapper {
    @Select("select * from student where studentId= #{studentId} and studentPwd=#{studentPwd} ")
    StudentPoJo studentLogin(StudentPoJo studentPoJo);

    @Select("select * from student where studentId=#{studentId} ")
    StudentPoJo getIngo(StudentPoJo studentPoJo);

    @Update("update student set  studentSex =#{studentSex} ,studentName=#{studentName} ,studentAge=#{studentAge} ,studentOc=#{studentOc} where studentId=#{studentId}   ;")
    int updataInfo(StudentPoJo studentPoJo);

    @Update("update student set  studentPwd=#{studentPwd}   where studentId=#{studentId}  ;")
    int changePwd(StudentPoJo studentPoJo);
}
