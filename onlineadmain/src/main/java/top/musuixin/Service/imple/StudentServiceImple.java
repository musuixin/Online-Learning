package top.musuixin.Service.imple;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import top.musuixin.Mapper.StudentMapper;
import top.musuixin.PoJo.StudentPoJo;
import top.musuixin.Service.studentService;

import java.util.List;

/**
 * @author musuixin
 * @date 2019-04-20 21:11
 */
@Service
public class StudentServiceImple implements studentService {
    @Autowired
    StudentMapper studentapper;
    @Override
    public List<StudentPoJo> getStudentList(int num) {
        PageHelper.startPage(num,10);
        return  studentapper.getStudent();
    }

    @Override
    public int deleteStudent(StudentPoJo studentPoJo) {
        return studentapper.deleteStudent(studentPoJo);
    }

    @Override
    public int addStudent(StudentPoJo studentPoJo) {
        return studentapper.addStudent(studentPoJo);
    }
}
