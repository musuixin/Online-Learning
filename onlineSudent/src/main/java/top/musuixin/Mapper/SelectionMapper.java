package top.musuixin.Mapper;

import org.apache.ibatis.annotations.*;
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
    LinkedList<SelectionPojo> getSelectList(SelectionPojo selectionPojo);

    @Select("select * from selection where studentId=#{studentId.studentId}  and courseId=#{courseId.courseId}   ")
    SelectionPojo getStudentSelect(@Param("studentId") StudentPoJo studentPoJo, @Param("courseId") SelectionPojo selectionPojo);

    @Select("update selection set assess=#{courseId.assess}  where studentId=#{studentId.studentId}  and courseId=#{courseId.courseId}  ")
    SelectionPojo addSelectionAssess(@Param("studentId") StudentPoJo studentPoJo, @Param("courseId") SelectionPojo selectionPojo);

    @Insert("insert into selection (studentId, courseId, assess,time,state) values (#{studentId} ,#{courseId} ,#{assess} ,#{time} ,#{state} );")
    int addSelect(SelectionPojo selectionPojo);

    @Select("select * from selection where studentId=#{studentId} and courseId=#{courseId} ")
    SelectionPojo querySelection(SelectionPojo selectionPojo);

    @Delete("delete from selection where selectionId=#{selectionId} and studentId=#{studentId}")
    int deleteSelection(SelectionPojo selectionPojo);
}
