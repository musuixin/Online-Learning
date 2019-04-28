package top.musuixin.Service.imple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.musuixin.Mapper.AdmainMapper;
import top.musuixin.PoJo.AdmainPojo;
import top.musuixin.Service.AdmainService;
import top.musuixin.Util.EncryptUtil;

/**
 * @author musuixin
 * @date 2019-04-21 14:44
 */
@Service
public class AdmainServiceImple implements AdmainService {
    @Autowired
    AdmainMapper admainMapper;
    @Override
    public void admainRegister(AdmainPojo admainPojo) {
        admainMapper.register(admainPojo);
    }

    @Override
    public AdmainPojo  selectEmail(AdmainPojo admainPojo) {
        return  admainMapper.selectEmail(admainPojo);
    }

    @Override
    public AdmainPojo login(AdmainPojo admainPojo) {
        admainPojo.setAdmainPwd(EncryptUtil.md5AndSha(admainPojo.getAdmainPwd()));
        return admainMapper.login(admainPojo);
    }

}
