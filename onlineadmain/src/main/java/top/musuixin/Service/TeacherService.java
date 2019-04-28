package top.musuixin.Service;

import top.musuixin.PoJo.TeacherPoJo;

import java.util.List;
import java.util.ListIterator;

public interface TeacherService {
    List<TeacherPoJo> getTeacherList();
    int addTeacher(TeacherPoJo teacherPoJo);
    int deleteTeacher(TeacherPoJo teacherPoJo);

}
