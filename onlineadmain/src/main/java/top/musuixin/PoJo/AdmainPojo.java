package top.musuixin.PoJo;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @author musuixin
 * @date 2019-04-21 12:56
 */
@Data
@Component
public class AdmainPojo {
    private String admainName;
    private String admainEmail;
    private String code;
    private String admainPwd;
    private String admainRePwd;
    private String invitationCode;
}
