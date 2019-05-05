package top.musuixin.Mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import top.musuixin.Pojo.LearningRecordPoJo;
import top.musuixin.Pojo.StudentPoJo;
import top.musuixin.Pojo.StudyDataPojo;

import java.util.LinkedList;

/**
 * @author musuixin
 * @date 2019-04-28 22:29
 */
@Repository
@Mapper
public interface StudyDataMapper {
    @Select("select * from selection,course where selection.courseId=course.courseId and selection.studentId=#{studentId} ")
    LinkedList<StudyDataPojo> getStudyList(StudentPoJo studentPoJo);
    @Insert("INSERT INTO learningrecord(selectionId, startTime, endTime, Time) VALUES (#{selectionId} , #{startTime} , #{endTime} , #{time});")
    int addLearnRecord(LearningRecordPoJo learningRecordPoJo);
}
