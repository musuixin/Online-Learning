package top.musuixin.Service;

import top.musuixin.Pojo.SelectionPojo;
import top.musuixin.Pojo.StudentPoJo;

import java.util.HashMap;

/**
 * @author musuixin
 * @date 2019-04-28 13:05
 */
public interface SelectionService {
    HashMap<String,Object> addSelectAssess(StudentPoJo studentPoJo, SelectionPojo selectionPojo);
}
