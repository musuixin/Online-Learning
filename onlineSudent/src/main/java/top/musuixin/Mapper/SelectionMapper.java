package top.musuixin.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;
import top.musuixin.Pojo.SelectionPojo;
import top.musuixin.Pojo.StudentPoJo;

import java.util.LinkedList;

/**
 * @author musuixin
 * @date 2019-04-28 12:14
 */
@Mapper
@Repository
public interface SelectionMapper {
    @Select("select * from selection,student where student.studentId=selection.studentId and courseId=#{courseId}  ")
//    @Cacheable(value = "Select", key = "'Select'+#selectionPojo.courseId")
    LinkedList<SelectionPojo> getSelectList(SelectionPojo selectionPojo);

    @Select("select * from selection where studentId=#{studentId.studentId}  and courseId=#{courseId.courseId}   ")
    SelectionPojo getStudentSelect(@Param("studentId")StudentPoJo studentPoJo, @Param("courseId")SelectionPojo selectionPojo);

    @Select("update selection set assess=#{courseId.assess}  where studentId=#{studentId.studentId}  and courseId=#{courseId.courseId}  ")
    SelectionPojo addSelectionAssess(@Param("studentId")StudentPoJo studentPoJo, @Param("courseId")SelectionPojo selectionPojo);
}
