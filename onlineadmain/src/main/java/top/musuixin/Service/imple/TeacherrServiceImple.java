package top.musuixin.Service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.musuixin.Mapper.TeacherMapper;
import top.musuixin.PoJo.TeacherPoJo;
import top.musuixin.Service.TeacherService;

import java.util.List;

/**
 * @author musuixin
 * @date 2019-04-24 10:09
 */
@Service
public class TeacherrServiceImple implements TeacherService {
    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public List<TeacherPoJo> getTeacherList() {
        return teacherMapper.getTeacherList();
    }

    @Override
    public int addTeacher(TeacherPoJo teacherPoJo) {
        return teacherMapper.addTeacher(teacherPoJo);
    }

    @Override
    public int deleteTeacher(TeacherPoJo teacherPoJo) {
        return teacherMapper.deleteTeacher(teacherPoJo);
    }
}
