package top.musuixin.Service.Imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;
import top.musuixin.Mapper.SelectionMapper;
import top.musuixin.Pojo.SelectionPojo;
import top.musuixin.Pojo.StudentPoJo;
import top.musuixin.Service.SelectionService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * @author musuixin
 * @date 2019-04-28 13:06
 */
@Service
public class SelectionServiceImple implements SelectionService {
    @Autowired
    SelectionMapper selectionMapper;

    @Override
    public HashMap<String, Object> addSelectAssess(StudentPoJo studentPoJo, SelectionPojo selectionPojo) {
        HashMap<String, Object> hashMap = new HashMap<>();


        SelectionPojo studentSelect = selectionMapper.getStudentSelect(studentPoJo, selectionPojo);
        if (studentSelect == null) {
            hashMap.put("status", "400");
            hashMap.put("msg", "请先选课");
            return hashMap;
        }
        System.out.println(studentSelect);
        if (studentSelect.getAssess().equals("未评论")) {
            selectionMapper.addSelectionAssess(studentPoJo, selectionPojo);
            hashMap.put("status", "200");
            hashMap.put("msg", "成功评论");
            return hashMap;
        }
        if (!studentSelect.getAssess().equals("未评论")) {
            hashMap.put("status", "400");
            hashMap.put("msg", "已经评论了");
            return hashMap;
        }
        return hashMap;
    }

    @Override
    public HashMap<String, Object> addSelection(SelectionPojo selectionPojo) {

        SelectionPojo selectionPojo1 = selectionMapper.querySelection(selectionPojo);

        HashMap<String, Object> hashMap = new HashMap<>();
        if (selectionPojo1 != null) {
            hashMap.put("status", "400");
            hashMap.put("msg", "已经选了此课，请到个人中心--课程学习中学习");
            return hashMap;
        }
        selectionPojo.setState("正在学习");
        selectionPojo.setTime("0");
        selectionPojo.setAssess("未评论");
        selectionMapper.addSelect(selectionPojo);
        hashMap.put("status", "200");
        hashMap.put("msg", "选课成功");
        return hashMap;
    }
}
