package top.musuixin.Service;


import top.musuixin.PoJo.StudentPoJo;

import java.util.List;

public interface studentService {
   List<StudentPoJo> getStudentList(int num);
   int deleteStudent(StudentPoJo studentPoJo);
   int addStudent(StudentPoJo studentPoJo);
}
