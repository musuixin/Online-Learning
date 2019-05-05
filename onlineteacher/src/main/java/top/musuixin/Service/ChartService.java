package top.musuixin.Service;

import java.util.HashMap;

/**
 * @author musuixin
 * @date 2019-05-04 10:04
 */
public interface ChartService {
    HashMap<String,Object> getChartData(String teacherId);
}
