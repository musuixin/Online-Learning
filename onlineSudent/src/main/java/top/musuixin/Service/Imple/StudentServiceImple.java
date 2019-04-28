package top.musuixin.Service.Imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.musuixin.Mapper.StudentMapper;
import top.musuixin.Pojo.StudentPoJo;
import top.musuixin.Service.StudentService;

/**
 * @author musuixin
 * @date 2019-04-27 15:09
 */
@Service
public class StudentServiceImple implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public StudentPoJo studentLogin(StudentPoJo studentPoJo) {


        return studentMapper.studentLogin(studentPoJo);
    }
}
