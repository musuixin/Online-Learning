package top.musuixin.Service;

import top.musuixin.PoJo.AdmainPojo;

/**
 * @author musuixin
 * @date 2019-04-21 14:43
 */
public interface AdmainService {
    void admainRegister(AdmainPojo admainPojo);
    AdmainPojo selectEmail(AdmainPojo admainPojo);
    AdmainPojo login(AdmainPojo admainPojo);
}
