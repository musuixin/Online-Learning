package top.musuixin.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttribute;
import top.musuixin.PoJo.AdmainPojo;
import top.musuixin.Service.imple.AdmainServiceImple;
import top.musuixin.Util.EncryptUtil;
import top.musuixin.Util.SendmailUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author musuixin
 * @date 2019-04-21 13:01
 * 管理员注册登陆逻辑
 */

@RestController
@CrossOrigin
public class AdmainController {
    @Autowired
    AdmainServiceImple admainServiceImple;
    @RequestMapping("/registerApi")
    public HashMap<String,String> register(AdmainPojo admainPojo,HttpSession httpSession){
        String admainEmail = (String)httpSession.getAttribute("admainEmail");
        String code =(String) httpSession.getAttribute("code");
        HashMap<String,String> hashMap =new HashMap<>();
        if(admainEmail==null){
            hashMap.put("status","400");
            hashMap.put("msg","没有获取验证码");
        }
        else if(!admainEmail.equals(admainPojo.getAdmainEmail())){
            hashMap.put("status","400");
            hashMap.put("msg","邮箱被更改");
        }

        else if(!code.equals(admainPojo.getCode())){
            hashMap.put("status","400");
            hashMap.put("msg","邮箱验证码错误");
        }
        else if(!admainPojo.getInvitationCode().equals("19971031")){
            hashMap.put("status","400");
            hashMap.put("msg","管理员邀请码错误");
        }
        else {
            admainPojo.setAdmainPwd(EncryptUtil.md5AndSha(admainPojo.getAdmainPwd()));
            admainServiceImple.admainRegister(admainPojo);
            hashMap.put("status","200");
            hashMap.put("msg","注册成功");
        }
        return hashMap;
    }
    @RequestMapping("/getEmailCode")
    public HashMap<String,String> getEmailCode(AdmainPojo admainPojo,HttpSession httpSession){
        HashMap<String,String> hashMap=new HashMap<>();
        if(admainServiceImple.selectEmail(admainPojo)!=null){
            hashMap.put("status","400");
            hashMap.put("msg","邮箱重复");
            return hashMap;
        }
        int code = (int) (Math.random() * 1000000);
        httpSession.setAttribute("admainEmail", admainPojo.getAdmainEmail());
        httpSession.setAttribute("code", code+"");
        System.out.println(admainPojo.getAdmainEmail());
        SendmailUtil sendmailUtil=new SendmailUtil();
        sendmailUtil.setToemailECode(admainPojo.getAdmainEmail(),code);
        sendmailUtil.start();
        hashMap.put("status","200");
        hashMap.put("msg","发送成功");
        return hashMap;
    }
    @RequestMapping(value = "/LoginApi")
    public TreeMap<String,String> login(AdmainPojo admainPojo,HttpSession httpSession){
        TreeMap<String,String> hashMap=new TreeMap<>();
        AdmainPojo login = admainServiceImple.login(admainPojo);
        if(login==null){
            hashMap.put("status","400");
            hashMap.put("msg","用户名或密码错误");
            return hashMap;
        }
        httpSession.setAttribute("email",admainPojo.getAdmainEmail());
        hashMap.put("status","200");
        hashMap.put("msg","登陆成功");
        return hashMap;
    }
}
